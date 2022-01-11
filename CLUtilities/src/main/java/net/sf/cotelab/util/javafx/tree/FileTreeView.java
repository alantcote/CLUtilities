package net.sf.cotelab.util.javafx.tree;

import java.io.File;

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

		setCellFactory(new FileTreeCellFactory(fileIconFactory));
	}

	/**
	 * @return a new {@link FileIconFactory} instance.
	 */
	protected FileIconFactory newFileIconFactory() {
		return new FileIconFactory();
	}

}
