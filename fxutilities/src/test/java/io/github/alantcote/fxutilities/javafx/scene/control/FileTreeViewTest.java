package io.github.alantcote.fxutilities.javafx.scene.control;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.alantcote.fxutilities.javafx.scene.control.FileIconFactory;
import io.github.alantcote.fxutilities.javafx.scene.control.FileTreeItem;
import io.github.alantcote.fxutilities.javafx.scene.control.FileTreeView;

/**
 * Test case for {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeView}.
 */
public class FileTreeViewTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeView#FileTreeView(javafx.scene.control.TreeItem)}.
	 */
	@Test
	public void testFileTreeView() {
		final FileTreeItem fileTreeItem = new FileTreeItem(null);
		FileTreeView fixture = new FileTreeView(fileTreeItem);

		assertNotNull(fixture);

		assertEquals(fileTreeItem, fixture.getRoot());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeView#newFileIconFactory()}.
	 */
	@Test
	public void testNewFileIconFactory() {
		final FileTreeItem fileTreeItem = new FileTreeItem(null);
		FileTreeView fixture = new FileTreeView(fileTreeItem);

		assertNotNull(fixture.newFileIconFactory());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeView#newFileTreeCellFactory(io.github.alantcote.fxutilities.javafx.scene.control.FileIconFactory)}.
	 */
	@Test
	public void testNewFileTreeCellFactory() {
		final FileTreeItem fileTreeItem = new FileTreeItem(null);
		final FileIconFactory fileIconFactory = new FileIconFactory();
		FileTreeView fixture = new FileTreeView(fileTreeItem);

		assertNotNull(fixture.newFileTreeCellFactory(fileIconFactory));
	}

}
