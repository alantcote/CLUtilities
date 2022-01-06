package net.sf.cotelab.util.javafx.tree;

import java.io.File;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class FileTreeView extends TreeView<File> {

	public FileTreeView(TreeItem<File> root) {
		super(root);

		FileIconFactory fileIconFactory = new FileIconFactory();
		
		setCellFactory(new FileTreeCellFactory(fileIconFactory));
	}

}
