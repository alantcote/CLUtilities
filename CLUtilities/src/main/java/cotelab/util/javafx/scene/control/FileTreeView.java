package cotelab.util.javafx.scene.control;

import java.io.File;

import cotelab.util.javafx.util.callback.FileTreeCellFactory;
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

		FileIconFactory fileIconFactory = new FileIconFactory();

		setCellFactory(new FileTreeCellFactory(fileIconFactory));
	}

	/**
	 * @return a new {@link FileIconFactory} instance.
	 */
	protected FileIconFactory newFileIconFactory() {
		return new FileIconFactory();
	}

}
