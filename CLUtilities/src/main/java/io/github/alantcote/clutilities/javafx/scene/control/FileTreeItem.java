package cotelab.util.javafx.scene.control;

import java.io.File;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * A {@link TreeItem} to be used with {@link FileTreeView}.
 */
public class FileTreeItem extends TreeItem<File> {
	/**
	 * This item's child items.
	 */
	protected ObservableList<TreeItem<File>> childItems = null;

	/**
	 * Construct a new object.
	 * @param aValue the {@link File} represented by this {@link TreeItem}.
	 */
	public FileTreeItem(File aValue) {
		super(aValue);

		childItems = super.getChildren();

		// if aValue is a directory, we'd like to be able to register a listener
		// with a monitor that would notify the listener when the set of
		// children in the underlying filesystem changes. This can be done via
		// the NIO classes. But it's not done yet, so we'll have to settle for
		// an unchanging view of aValue's children, for now.
	}

	/**
	 * {@inheritDoc}
	 */
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
					childItems.add(newFileTreeItem(fsRoot));
				}
			} else {
				// normal situation
				if (myFile.isDirectory()) {
					File[] kidFiles = myFile.listFiles();

//					System.out.println("FileTreeItem.getChildren(): kidFiles = " + kidFiles);

					if (kidFiles != null) {
						for (File kidFile : kidFiles) {
							childItems.add(newFileTreeItem(kidFile));
						}
					}
				}
			}
		}

//		System.out.println("FileTreeItem.getChildren(): childItems = " + childItems);

		return childItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLeaf() {
//		System.out.println("FileTreeItem.isLeaf(): myFile = " + myFile);

		ObservableList<TreeItem<File>> kids = getChildren();

//		System.out.println("FileTreeItem.isLeaf(): kids = " + kids);

		boolean myLeaf = (0 == kids.size());

//		System.out.println("FileTreeItem.isLeaf(): myLeaf = " + myLeaf);

		return myLeaf;
	}

	/**
	 * A factory for tree items.
	 * @param aFile the {@link File} wrapped by a new tree item.
	 * @return the new tree item.
	 */
	protected FileTreeItem newFileTreeItem(File aFile) {
		return new FileTreeItem(aFile);
	}
}
