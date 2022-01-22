package cotelab.util.javafx.util.callback;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;

import cotelab.jfxrunner.JavaFxJUnit4ClassRunner;
import cotelab.util.demo.TestCaseWithJMockAndByteBuddy;
import cotelab.util.javafx.scene.control.FileIconFactory;
import cotelab.util.javafx.scene.control.FileTreeCell;
import javafx.scene.control.TreeView;

/**
 * Test case for {@link cotelab.util.javafx.util.callback.FileTreeCellFactory}.
 */
@RunWith(JavaFxJUnit4ClassRunner.class)
public class FileTreeCellFactoryTest extends TestCaseWithJMockAndByteBuddy {

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.util.callback.FileTreeCellFactory#call(javafx.scene.control.TreeView)}.
	 */
	@Test
	public void testCall() {
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		@SuppressWarnings("unchecked")
		final TreeView<File> mockTreeView = context.mock(TreeView.class, "mockTreeView");
		final FileTreeCell mockFileTreeCell = context.mock(FileTreeCell.class, "mockFileTreeCell");
		FileTreeCellFactory fixture = new FileTreeCellFactory(mockFileIconFactory) {

			@Override
			protected FileTreeCell newFileTreeCell() {
				return mockFileTreeCell;
			}

		};

		assertEquals(mockFileTreeCell, fixture.call(mockTreeView));
	}

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.util.callback.FileTreeCellFactory#FileTreeCellFactory(cotelab.util.javafx.scene.control.FileIconFactory)}.
	 */
	@Test
	public void testFileTreeCellFactory() {
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		FileTreeCellFactory fixture = new FileTreeCellFactory(mockFileIconFactory);

		assertNotNull(fixture);

		assertEquals(mockFileIconFactory, fixture.fileIconFactory);
	}

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.util.callback.FileTreeCellFactory#newFileTreeCell()}.
	 */
	@Test
	public void testNewFileTreeCell() {
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		FileTreeCellFactory fixture = new FileTreeCellFactory(mockFileIconFactory);

		assertNotNull(fixture.newFileTreeCell());
	}

}
