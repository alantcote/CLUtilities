package cotelab.util.javafx.scene.control;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import cotelab.jfxrunner.JavaFxJUnit4ClassRunner;
import cotelab.util.demo.TestCaseWithJMockAndByteBuddy;
import javafx.event.EventHandler;
import javafx.event.EventType;

/**
 * Test case for {@link cotelab.util.javafx.scene.control.FileTreeView}.
 */
@RunWith(JavaFxJUnit4ClassRunner.class)
public class FileTreeViewTest extends TestCaseWithJMockAndByteBuddy {

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.scene.control.FileTreeView#FileTreeView(javafx.scene.control.TreeItem)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testFileTreeView() {
		final FileTreeItem mockFileTreeItem = context.mock(FileTreeItem.class, "mockFileTreeItem");

		context.checking(new Expectations() {
			{
				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));
			}
		});

		FileTreeView fixture = new FileTreeView(mockFileTreeItem);

		assertNotNull(fixture);

		assertEquals(mockFileTreeItem, fixture.getRoot());
	}

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.scene.control.FileTreeView#newFileIconFactory()}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testNewFileIconFactory() {
		final FileTreeItem mockFileTreeItem = context.mock(FileTreeItem.class, "mockFileTreeItem");

		context.checking(new Expectations() {
			{
				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));
			}
		});

		FileTreeView fixture = new FileTreeView(mockFileTreeItem);

		assertNotNull(fixture.newFileIconFactory());
	}

	/**
	 * Test method for
	 * {@link cotelab.util.javafx.scene.control.FileTreeView#newFileTreeCellFactory(cotelab.util.javafx.scene.control.FileIconFactory)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testNewFileTreeCellFactory() {
		final FileTreeItem mockFileTreeItem = context.mock(FileTreeItem.class, "mockFileTreeItem");
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");

		context.checking(new Expectations() {
			{
				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(EventHandler.class)));
			}
		});

		FileTreeView fixture = new FileTreeView(mockFileTreeItem);

		assertNotNull(fixture.newFileTreeCellFactory(mockFileIconFactory));
	}

}
