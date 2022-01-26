package io.github.alantcote.clutilities.javafx.util.callback;

import java.nio.file.Path;

import javax.swing.filechooser.FileSystemView;

import io.github.alantcote.clutilities.javafx.scene.control.PathIconFactory;
import io.github.alantcote.clutilities.javafx.scene.control.PathTreeCell;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

/**
 * Tree cell factory to manufacture {@link PathTreeCell} objects.
 */
public class PathTreeCellFactory implements Callback<TreeView<Path>, TreeCell<Path>> {
	/**
	 * A supplier of platform-authentic icons and such.
	 */
	public static final FileSystemView fileSystemView = FileSystemView.getFileSystemView();

	/**
	 * A {@link PathIconFactory} to be passed on to the manufactured tree cells.
	 */
	protected PathIconFactory pathIconFactory;

	/**
	 * Construct a new object.
	 * @param aPathIconFactory a {@link PathIconFactory} to be passed on to the manufactured tree cells.
	 */
	public PathTreeCellFactory(PathIconFactory aPathIconFactory) {
		pathIconFactory = aPathIconFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TreeCell<Path> call(TreeView<Path> param) {
		PathTreeCell newPathTreeCell = newPathTreeCell();
		TreeCell<Path> result = null;

		if (newPathTreeCell instanceof TreeCell) {
			result = (TreeCell<Path>) newPathTreeCell;
		}

		return result;
	}

	/**
	 * @return a new {@link PathTreeCell} object.
	 */
	protected PathTreeCell newPathTreeCell() {
		return new PathTreeCell(pathIconFactory);
	}

}
