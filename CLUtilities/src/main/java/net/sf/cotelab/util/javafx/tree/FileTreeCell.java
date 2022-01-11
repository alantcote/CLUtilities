package net.sf.cotelab.util.javafx.tree;

import java.io.File;

import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeCell;
import javafx.scene.image.ImageView;

public class FileTreeCell extends TreeCell<File> {
	public static final String SYNTH_ROOT_NAME = "Filesystems";

	protected FileIconFactory fileIconFactory;

	/**
	 * A tree cell for {@link File} objects.
	 * 
	 * @param aFileIconFactory a source for platform-authentic icon images that are
	 *                         appropriate to files being represented.
	 */
	public FileTreeCell(FileIconFactory aFileIconFactory) {
		super();

		fileIconFactory = aFileIconFactory;
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
				String presText = FileIconFactory.fileSystemView.getSystemDisplayName(item);
				ImageView iconImage = fileIconFactory.getIcon(item);

//				System.out.println("FileTreeCell.updateItem(): presText = " + presText);

				setText(presText);
				setGraphic(iconImage);
				setTooltip(newTooltip(presText));
			}
		}
	}

}
