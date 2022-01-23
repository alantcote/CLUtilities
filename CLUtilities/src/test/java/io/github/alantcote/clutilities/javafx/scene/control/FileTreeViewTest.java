package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import io.github.alantcote.clutilities.jmock.TestCaseWithJMock;
import javafx.event.EventHandler;
import javafx.event.EventType;

/**
 * Test case for {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeView}.
 */
@RunWith(JfxRunner.class)
public class FileTreeViewTest extends TestCaseWithJMock {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeView#FileTreeView(javafx.scene.control.TreeItem)}.
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
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeView#newFileIconFactory()}.
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
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeView#newFileTreeCellFactory(io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory)}.
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
