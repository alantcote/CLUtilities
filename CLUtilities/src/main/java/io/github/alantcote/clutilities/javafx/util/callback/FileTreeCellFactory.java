package cotelab.util.javafx.util.callback;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import cotelab.util.javafx.scene.control.FileIconFactory;
import cotelab.util.javafx.scene.control.FileTreeCell;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

/**
 * Tree cell factory to manufacture {@link FileTreeCell} objects.
 */
public class FileTreeCellFactory implements Callback<TreeView<File>, TreeCell<File>> {
	/**
	 * A supplier of platform-authentic icons and such.
	 */
	public static final FileSystemView fileSystemView = FileSystemView.getFileSystemView();

	/**
	 * A {@link FileIconFactory} to be passed on to the manufactured tree cells.
	 */
	protected FileIconFactory fileIconFactory;

	/**
	 * Construct a new tree cell factory.
	 * 
	 * @param aFileIconFactory a {@link FileIconFactory} to be passed on to the
	 *                         manufactured tree cells.
	 */
	public FileTreeCellFactory(FileIconFactory aFileIconFactory) {
		super();

		fileIconFactory = aFileIconFactory;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public TreeCell<File> call(TreeView<File> param) {
		FileTreeCell newFileTreeCell = newFileTreeCell();
		TreeCell<File> result = null;

		if (newFileTreeCell instanceof TreeCell) {
			result = (TreeCell<File>) newFileTreeCell;
		}

		return result;
	}

	/**
	 * @return a new {@link FileTreeCell} object.
	 */
	protected FileTreeCell newFileTreeCell() {
		return new FileTreeCell(fileIconFactory);
	}

}
