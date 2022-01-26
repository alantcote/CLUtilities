package io.github.alantcote.clutilities.javafx.scene.control;

import java.nio.file.Path;

import javafx.scene.control.Tooltip;
import javafx.scene.control.TreeCell;
import javafx.scene.image.ImageView;

/**
 * {@link TreeCell} meant to be used with {@link PathTreeView}.
 */
public class PathTreeCell extends TreeCell<Path> {
	/**
	 * The displayed text for the synthetic root (<code>null</code>).
	 */
	public static final String SYNTH_ROOT_NAME = "Filesystems";
	
	/**
	 * The {@link PathIconFactory} to use.
	 */
	protected PathIconFactory pathIconFactory;

	/**
	 * Construct a new object.
	 * 
	 * @param aPathIconFactory the {@link PathIconFactory} to use.
	 */
	public PathTreeCell(PathIconFactory aPathIconFactory) {
		pathIconFactory = aPathIconFactory;
	}

	/**
	 * Get the display name for the path.
	 * 
	 * @param item the path.
	 * @return the display name.
	 */
	protected String displayName(Path item) {
		if (item.getParent() == null) {
			return item.toString();
		}
		
		return item.getName(item.getNameCount() - 1).toString();
	}

	/**
	 * Get the icon to use for the path.
	 * 
	 * @param item the path.
	 * @return the icon.
	 */
	protected ImageView getIconImage(Path item) {
		return pathIconFactory.getIcon(item);
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
	protected void updateItem(Path item, boolean empty) {
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

				setText(presText);
				setGraphic(iconImage);
				setTooltip(newTooltip(presText));
			}
		}
	}

}
