package io.github.alantcote.fxutilities.javafx.util.callback;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import io.github.alantcote.fxutilities.javafx.scene.control.FileIconFactory;
import io.github.alantcote.fxutilities.javafx.scene.control.FileTreeCell;
import io.github.alantcote.fxutilities.javafx.util.callback.FileTreeCellFactory;
import javafx.scene.control.TreeView;

/**
 * Test case for {@link io.github.alantcote.fxutilities.javafx.util.callback.FileTreeCellFactory}.
 */
public class FileTreeCellFactoryTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.util.callback.FileTreeCellFactory#call(javafx.scene.control.TreeView)}.
	 */
	@Test
	public void testCall() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		final TreeView<File> treeView = new TreeView<File>();
		final FileTreeCell fileTreeCell = new FileTreeCell(fileIconFactory);
		FileTreeCellFactory fixture = new FileTreeCellFactory(fileIconFactory) {

			@Override
			protected FileTreeCell newFileTreeCell() {
				return fileTreeCell;
			}

		};

		assertEquals(fileTreeCell, fixture.call(treeView));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.util.callback.FileTreeCellFactory#FileTreeCellFactory(io.github.alantcote.fxutilities.javafx.scene.control.FileIconFactory)}.
	 */
	@Test
	public void testFileTreeCellFactory() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		FileTreeCellFactory fixture = new FileTreeCellFactory(fileIconFactory);

		assertNotNull(fixture);

		assertEquals(fileIconFactory, fixture.fileIconFactory);
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.util.callback.FileTreeCellFactory#newFileTreeCell()}.
	 */
	@Test
	public void testNewFileTreeCell() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		FileTreeCellFactory fixture = new FileTreeCellFactory(fileIconFactory);

		assertNotNull(fixture.newFileTreeCell());
	}

}
