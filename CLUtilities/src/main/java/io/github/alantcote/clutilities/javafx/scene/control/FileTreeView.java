package io.github.alantcote.clutilities.javafx.scene.control;

import java.io.File;

import io.github.alantcote.clutilities.javafx.util.callback.FileTreeCellFactory;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

/**
 * A {@link TreeView} customized to display file system directory trees with
 * system-authentic icons.
 */
public class FileTreeView extends TreeView<File> {

	/**
	 * Construct a new object.
	 * 
	 * @param root the root {@link TreeItem}.
	 */
	public FileTreeView(TreeItem<File> root) {
		super(root);

		FileIconFactory fileIconFactory = newFileIconFactory();

		setCellFactory(newFileTreeCellFactory(fileIconFactory));
	}

	/**
	 * @return a new {@link FileIconFactory} instance.
	 */
	protected FileIconFactory newFileIconFactory() {
		return new FileIconFactory();
	}

	/**
	 * @param fileIconFactory
	 * @return
	 */
	protected FileTreeCellFactory newFileTreeCellFactory(FileIconFactory fileIconFactory) {
		return new FileTreeCellFactory(fileIconFactory);
	}

}
