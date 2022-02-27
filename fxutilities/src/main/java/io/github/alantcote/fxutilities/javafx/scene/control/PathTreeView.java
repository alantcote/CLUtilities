package io.github.alantcote.fxutilities.javafx.scene.control;

import java.nio.file.Path;

import io.github.alantcote.fxutilities.javafx.util.callback.PathTreeCellFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * A {@link TreeView} customized to display file system directory trees with
 * system-authentic icons.
 */
public class PathTreeView extends TreeView<Path> {

	/**
	 * Construct a new object.
	 * 
	 * @param root the root {@link TreeItem}.
	 */
	public PathTreeView(TreeItem<Path> root) {
		super(root);

		PathIconFactory pathIconFactory = newPathIconFactory();

		setCellFactory(newPathTreeCellFactory(pathIconFactory));
	}

	/**
	 * @return a new {@link FileIconFactory} instance.
	 */
	protected PathIconFactory newPathIconFactory() {
		return new PathIconFactory();
	}

	/**
	 * Manufacture a new {@link PathTreeCellFactory}.
	 * 
	 * @param pathIconFactory the {@link PathIconFactory} to use.
	 * @return the new object.
	 */
	protected PathTreeCellFactory newPathTreeCellFactory(PathIconFactory pathIconFactory) {
		return new PathTreeCellFactory(pathIconFactory);
	}
}
