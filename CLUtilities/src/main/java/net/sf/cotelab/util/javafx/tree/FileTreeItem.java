package net.sf.cotelab.util.javafx.tree;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class FileTreeItem extends TreeItem<File> {
	protected ObservableList<TreeItem<File>> childItems = null;

	public FileTreeItem(File aValue) {
		super(aValue);

		childItems = super.getChildren();

		// if aValue is a directory, we'd like to be able to register a listener
		// with a monitor that would notify the listener when the set of
		// children in the underlying filesystem changes. This can be done via
		// the NIO classes. But it's not done yet, so we'll have to settle for
		// an unchanging view of aValue's children, for now.
	}

	@Override
	public ObservableList<TreeItem<File>> getChildren() {
		File myFile = getValue();

//		System.out.println("FileTreeItem.getChildren(): myFile = " + myFile);

		if (childItems.isEmpty()) {
			if (myFile == null) {
				// super-root synthetic node
				File[] fsRoots = File.listRoots();

//				System.out.println("FileTreeItem.getChildren(): fsRoots = " + fsRoots);

				for (File fsRoot : fsRoots) {
					childItems.add(new FileTreeItem(fsRoot));
				}
			} else {
				// normal situation
				if (myFile.isDirectory()) {
					File[] kidFiles = myFile.listFiles();

//					System.out.println("FileTreeItem.getChildren(): kidFiles = " + kidFiles);

					if (kidFiles != null) {
						for (File kidFile : kidFiles) {
							childItems.add(new FileTreeItem(kidFile));
						}
					}
				}
			}
		}

//		System.out.println("FileTreeItem.getChildren(): childItems = " + childItems);

		return childItems;
	}

	@Override
	public boolean isLeaf() {
		File myFile = getValue(); // at this writing, it's only useful when tracing

//		System.out.println("FileTreeItem.isLeaf(): myFile = " + myFile);

		ObservableList<TreeItem<File>> kids = getChildren();

//		System.out.println("FileTreeItem.isLeaf(): kids = " + kids);

		boolean myLeaf = (0 == kids.size());

//		System.out.println("FileTreeItem.isLeaf(): myLeaf = " + myLeaf);

		return myLeaf;
	}
}
