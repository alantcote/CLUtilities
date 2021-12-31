/**
 * 
 */
package net.sf.cotelab.util.javafx.tree;

import java.io.File;

import javax.swing.filechooser.FileSystemView;

import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

/**
 * @author alantcote
 */
public class FileTreeCellFactory implements Callback<TreeView<File>, TreeCell<File>> {
	/**
	 * A supplier of platform-authentic icons and such.
	 */
	public static final FileSystemView fileSystemView = FileSystemView.getFileSystemView();

	protected FileIconFactory fileIconFactory;
	
	public FileTreeCellFactory(FileIconFactory aFileIconFactory) {
		super();

		fileIconFactory = aFileIconFactory;
	}

	@Override
	public TreeCell<File> call(TreeView<File> param) {
		FileTreeCell newFileTreeCell = new FileTreeCell(fileIconFactory);
		TreeCell<File> result = null;
		
		if (newFileTreeCell instanceof TreeCell) {
			result = (TreeCell<File>) newFileTreeCell;
		}
		
		return result;
	}

}
