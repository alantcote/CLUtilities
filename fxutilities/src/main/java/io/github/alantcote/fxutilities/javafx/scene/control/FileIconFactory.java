package io.github.alantcote.fxutilities.javafx.scene.control;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Hashtable;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileSystemView;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

/**
 * A caching provider of system-authentic icons for files.
 */
public class FileIconFactory {
	/**
	 * A supplier of platform-authentic icons and such.
	 */
	public static final FileSystemView fileSystemView = FileSystemView.getFileSystemView();

	/**
	 * The cache of {@link ImageView} objects, keyed by {@link Icon} objects.
	 * 
	 * This exists because converting the latter to the former is expensive.
	 */
	protected Hashtable<Icon, ImageView> cache = newHashtable();

	/**
	 * Get the system-authentic icon image appropriate for a given file.
	 * 
	 * @param aFile the given file.
	 * @return the icon image.
	 */
	public ImageView getIcon(File aFile) {
		Icon swingIcon = getSystemIcon(aFile);

		return getImageView(swingIcon);
	}

	/**
	 * Convert an {@link Icon} to an {@link ImageView}.
	 * 
	 * @param swingIcon the {@link Icon}.
	 * @return the {@link ImageView}.
	 */
	protected ImageView getIconImage(Icon swingIcon) {
		ImageIcon imageIcon = null;

		if (swingIcon instanceof ImageIcon) {
			imageIcon = (ImageIcon) swingIcon;
		}

		java.awt.Image awtImage = imageIcon.getImage();

		BufferedImage bImg;

		if (awtImage instanceof BufferedImage) {
			bImg = (BufferedImage) awtImage;
		} else {
			bImg = newBufferedImage(awtImage);
			Graphics2D graphics = bImg.createGraphics();
			graphics.drawImage(awtImage, 0, 0, null);
			graphics.dispose();
		}

		Image fxImage = swingFXUtilsToFXImage(bImg, null);
		ImageView imageView = newImageView(fxImage);

		return imageView;
	}

	/**
	 * Get an {@link ImageView} object corresponding to a {@link Icon} object.
	 * 
	 * The {@link #cache} is used and/or updated to accomplish this.
	 * 
	 * @param swingIcon a {@link Icon} object.
	 * @return the {@link ImageView} object.
	 */
	protected ImageView getImageView(Icon swingIcon) {
		ImageView imageView = null;

		if (swingIcon != null) {
			imageView = cache.get(swingIcon);

			if (imageView == null) {
				imageView = getIconImage(swingIcon);

				cache.put(swingIcon, imageView);
			}
		}

		return imageView;
	}

	/**
	 * Get the local system-authentic icon for a file.
	 * 
	 * @param aFile a file.
	 * @return the icon.
	 */
	protected Icon getSystemIcon(File aFile) {
		return fileSystemView.getSystemIcon(aFile);
	}

	/**
	 * Create a new {@link BufferedImage} to fit a given {@link java.awt.Image}.
	 * 
	 * @param awtImage an {@link java.awt.Image}.
	 * @return a {@link BufferedImage}.
	 */
	protected BufferedImage newBufferedImage(java.awt.Image awtImage) {
		return new BufferedImage(awtImage.getWidth(null), awtImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	}

	/**
	 * Construct a new {@link Hashtable}.
	 * 
	 * @return the new {@link Hashtable}.
	 */
	protected Hashtable<Icon, ImageView> newHashtable() {
		return new Hashtable<Icon, ImageView>();
	}

	/**
	 * Manufacture an {@link ImageView} from an {@link Image}.
	 * 
	 * @param fxImage the {@link Image}.
	 * @return the {@link ImageView}.
	 */
	protected ImageView newImageView(Image fxImage) {
		return new ImageView(fxImage);
	}

	/**
	 * Snapshots the specified BufferedImage and stores a copy of its pixels into a
	 * JavaFX Image object, creating a new object if needed.
	 * 
	 * @param bImg the BufferedImage object to be converted.
	 * @param wimg an optional WritableImage object that can be used to store the
	 *             returned pixel data.
	 * @return an Image object representing a snapshot of the current pixels in the
	 *         BufferedImage.
	 */
	protected Image swingFXUtilsToFXImage(BufferedImage bImg, WritableImage wimg) {
		return SwingFXUtils.toFXImage(bImg, wimg);
	}

}
