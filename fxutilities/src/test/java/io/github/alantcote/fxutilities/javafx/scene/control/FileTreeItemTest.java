package io.github.alantcote.fxutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import io.github.alantcote.fxutilities.javafx.scene.control.FileTreeItem;

/**
 * Test case for {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeItem}.
 */
public class FileTreeItemTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeItem#FileTreeItem(java.io.File)}.
	 */
	@Test
	public void testFileTreeItem() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertNotNull(fixture);

		assertEquals(realFile, fixture.getValue());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeItem#getChildren()}.
	 */
	@Test
	public void testGetChildren() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertNotNull(fixture.getChildren());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeItem#isLeaf()}.
	 */
	@Test
	public void testIsLeaf() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertFalse(fixture.isLeaf());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.FileTreeItem#newFileTreeItem(java.io.File)}.
	 */
	@Test
	public void testNewFileTreeItem() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertNotNull(fixture.newFileTreeItem(realFile));
	}

}
