package io.github.alantcote.fxutilities.javafx.scene.control;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;

import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * A {@link TreeItem} to be used with {@link PathTreeView}.
 */
public class PathTreeItem extends TreeItem<Path> {
	/**
	 * This item's child items.
	 */
	protected ObservableList<TreeItem<Path>> childItems = null;

	/**
	 * Construct a new object.
	 * 
	 * @param aValue the {@link Path} represented by this {@link TreeItem}.
	 */
	public PathTreeItem(Path aValue) {
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
	public ObservableList<TreeItem<Path>> getChildren() {
		Path myPath = getValue();

		if (childItems.isEmpty()) {
			if (myPath == null) {
				// super-root synthetic node
				Iterable<Path> fsRoots = FileSystems.getDefault().getRootDirectories();

				for (Path fsRoot : fsRoots) {
					childItems.add(newPathTreeItem(fsRoot));
				}
			} else {
				// normal situation
				if (Files.isDirectory(myPath, LinkOption.NOFOLLOW_LINKS)) {
					DirectoryStream<Path> directoryStream;

					try {
						directoryStream = Files.newDirectoryStream(myPath);

						if (directoryStream != null) {
							for (Path kidFile : directoryStream) {
								childItems.add(newPathTreeItem(kidFile));
							}
						}
					} catch (IOException e) {
						// NOTHING
					}
				}
			}
		}

		return childItems;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isLeaf() {
		ObservableList<TreeItem<Path>> kids = getChildren();
		boolean myLeaf = (0 == kids.size());

		return myLeaf;
	}

	/**
	 * A factory for tree items.
	 * 
	 * @param aFile the {@link Path} wrapped by a new tree item.
	 * @return the new tree item.
	 */
	protected PathTreeItem newPathTreeItem(Path aFile) {
		return new PathTreeItem(aFile);
	}
}
