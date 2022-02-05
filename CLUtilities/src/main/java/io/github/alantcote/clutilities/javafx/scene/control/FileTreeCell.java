package io.github.alantcote.clutilities.javafx.scene.control;

import java.io.File;

import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeCell;
import javafx.scene.image.ImageView;

/**
 * A {@link TreeCell<File>} extended to understand {@link File} objects and to
 * display system-authentic icons for them.
 */
public class FileTreeCell extends TreeCell<File> {
	/**
	 * A display name for the root of a file tree.
	 */
	public static final String SYNTH_ROOT_NAME = "Filesystems";

	/**
	 * A factory for platform-authentic file icons.
	 */
	protected FileIconFactory fileIconFactory;

	/**
	 * A tree cell for {@link File} objects.
	 * 
	 * @param aFileIconFactory a factory for platform-authentic file icons.
	 */
	public FileTreeCell(FileIconFactory aFileIconFactory) {
		super();

		fileIconFactory = aFileIconFactory;
	}

	/**
	 * Get a presentable name for a file.
	 * 
	 * @param item the file.
	 * @return the presentable name.
	 */
	protected String displayName(File item) {
		return FileIconFactory.fileSystemView.getSystemDisplayName(item);
	}

	/**
	 * Get a platform-authentic icon for a file.
	 * 
	 * @param item the file.
	 * @return the icon.
	 */
	protected ImageView getIconImage(File item) {
		return fileIconFactory.getIcon(item);
	}

	/**
	 * Create a {@link Tooltip} containing a given bit of text.
	 * 
	 * @param presText the bit of text.
	 * @return the {@link Tooltip}.
	 */
	protected Tooltip newTooltip(String presText) {
		return new Tooltip(presText);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void updateItem(File item, boolean empty) {
//		System.out.println("FileTreeCell.updateItem(): item = " + item);
//		System.out.println("FileTreeCell.updateItem(): empty = " + empty);

		super.updateItem(item, empty);

		if (empty) {
			setText(null);
			setGraphic(null);
		} else {
			if (item == null) {
				// synthetic root node
				setText(SYNTH_ROOT_NAME);
			} else {
				// normal File node
				String presText = displayName(item);
				ImageView iconImage = getIconImage(item);

//				System.out.println("FileTreeCell.updateItem(): presText = " + presText);

				setText(presText);
				setGraphic(iconImage);
				setTooltip(newTooltip(presText));
			}
		}
	}

}
