package cotelab.util.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;

import cotelab.jfxrunner.JavaFxJUnit4ClassRunner;
import cotelab.util.demo.TestCaseWithJMockAndByteBuddy;

/**
 * Test case for {@link cotelab.util.javafx.scene.control.FileTreeItem}.
 */
@RunWith(JavaFxJUnit4ClassRunner.class)
public class FileTreeItemTest extends TestCaseWithJMockAndByteBuddy {

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.scene.control.FileTreeItem#FileTreeItem(java.io.File)}.
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
	 * {@link cotelab.util.javafx.scene.control.FileTreeItem#getChildren()}.
	 */
	@Test
	public void testGetChildren() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertNotNull(fixture.getChildren());
	}

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.scene.control.FileTreeItem#isLeaf()}.
	 */
	@Test
	public void testIsLeaf() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertFalse(fixture.isLeaf());
	}

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.scene.control.FileTreeItem#newFileTreeItem(java.io.File)}.
	 */
	@Test
	public void testNewFileTreeItem() {
		final File realFile = new File("/");
		FileTreeItem fixture = new FileTreeItem(realFile);

		assertNotNull(fixture.newFileTreeItem(realFile));
	}

}
