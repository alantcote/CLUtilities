package net.sf.cotelab.util.javafx.tree;

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

public class FileIconFactory {

	/**
	 * A supplier of platform-authentic icons and such.
	 */
	public static final FileSystemView fileSystemView = FileSystemView.getFileSystemView();

	protected Hashtable<Icon, ImageView> cache = new Hashtable<Icon, ImageView>();

	public ImageView getIcon(File aFile) {
		Icon swingIcon = fileSystemView.getSystemIcon(aFile);
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
			bImg = new BufferedImage(awtImage.getWidth(null), awtImage.getHeight(null), BufferedImage.TYPE_INT_ARGB);
			Graphics2D graphics = bImg.createGraphics();
			graphics.drawImage(awtImage, 0, 0, null);
			graphics.dispose();
		}

		Image fxImage = SwingFXUtils.toFXImage(bImg, null);
		ImageView imageView = new ImageView(fxImage);

		return imageView;
	}

}
