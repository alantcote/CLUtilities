package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import io.github.alantcote.clutilities.jmock.TestCaseWithJMock;

/**
 * Test case for {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem}.
 */
@RunWith(JfxRunner.class)
public class FileTreeItemTest extends TestCaseWithJMock {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem#FileTreeItem(java.io.File)}.
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
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem#getChildren()}.
	 */
	@Test
	public void testGetChildren() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertNotNull(fixture.getChildren());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem#isLeaf()}.
	 */
	@Test
	public void testIsLeaf() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertFalse(fixture.isLeaf());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem#newFileTreeItem(java.io.File)}.
	 */
	@Test
	public void testNewFileTreeItem() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertNotNull(fixture.newFileTreeItem(realFile));
	}

}
