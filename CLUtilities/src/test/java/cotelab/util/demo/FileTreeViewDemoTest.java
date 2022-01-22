package cotelab.util.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import cotelab.jfxrunner.JavaFxJUnit4ClassRunner;
import cotelab.util.javafx.scene.control.FileTreeItem;
import cotelab.util.javafx.scene.control.FileTreeView;
import javafx.application.HostServices;
import javafx.event.EventType;
import javafx.event.WeakEventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Test case for {@link cotelab.util.demo.FileTreeViewDemo}.
 */
@RunWith(JavaFxJUnit4ClassRunner.class)
public class FileTreeViewDemoTest extends TestCaseWithJMockAndByteBuddy {

	/**
	 * Test method for
	 * {@link cotelab.util.demo.FileTreeViewDemo#createFileTreeView()}.
	 */
	@Test
	public void testCreateFileTreeView() {
		final FileTreeItem mockFileTreeItem = context.mock(FileTreeItem.class, "mockFileTreeItem");
		final FileTreeView mockFileTreeView = context.mock(FileTreeView.class, "mockFileTreeView");
		final FileTreeViewDemo fixture = new FileTreeViewDemo() {

			@Override
			protected FileTreeItem newFileTreeItem() {
				return mockFileTreeItem;
			}

			@Override
			protected FileTreeView newFileTreeView(TreeItem<File> rootFileTreeItem) {
				return mockFileTreeView;
			}

		};

		TreeView<File> result = fixture.createFileTreeView();

		assertEquals(mockFileTreeView, result);
	}

	/**
	 * Test method for
	 * {@link cotelab.util.demo.FileTreeViewDemo#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		// Calls a static method in its superclass. I have no idea how to write
		// a legitimate unit test class for that.
	}

	/**
	 * Test method for {@link cotelab.util.demo.FileTreeViewDemo#newBorderPane()}.
	 */
	@Test
	public void testNewBorderPane() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();

		assertNotNull(fixture.newBorderPane());
	}

	/**
	 * Test method for {@link cotelab.util.demo.FileTreeViewDemo#newFileTreeItem()}.
	 */
	@Test
	public void testNewFileTreeItem() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();

		assertNotNull(fixture.newFileTreeItem());
	}

	/**
	 * Test method for
	 * {@link cotelab.util.demo.FileTreeViewDemo#newFileTreeView(javafx.scene.control.TreeItem)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testNewFileTreeView() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();
		final TreeItem<File> mockFileTreeItem = context.mock(TreeItem.class, "mockFileTreeItem");

		context.checking(new Expectations() {
			{
				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(WeakEventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(WeakEventHandler.class)));

				oneOf(mockFileTreeItem).addEventHandler(with(any(EventType.class)), with(any(WeakEventHandler.class)));
			}
		});

		assertNotNull(fixture.newFileTreeView(mockFileTreeItem));
	}

	/**
	 * Test method for
	 * {@link cotelab.util.demo.FileTreeViewDemo#newScene(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testNewScene() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();
		final BorderPane mockBorderPane = new BorderPane();

		assertNotNull(fixture.newScene(mockBorderPane));
	}

	/**
	 * Test method for
	 * {@link cotelab.util.demo.FileTreeViewDemo#populateFileTreeViewPane(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testPopulateFileTreeViewPane() {
		final BorderPane realBorderPane = new BorderPane();
		@SuppressWarnings("unchecked")
		final TreeView<File> mockTreeView = context.mock(TreeView.class, "mockTreeView");
		final FileTreeViewDemo fixture = new FileTreeViewDemo() {

			@Override
			protected TreeView<File> createFileTreeView() {
				return mockTreeView;
			}

		};

		fixture.populateFileTreeViewPane(realBorderPane);
	}

	/**
	 * Test method for
	 * {@link cotelab.util.demo.FileTreeViewDemo#start(javafx.stage.Stage)}.
	 */
	@Test
	public void testStartStage() {
		final BorderPane mockBorderPane = context.mock(BorderPane.class, "mockBorderPane");
		final Scene mockScene = context.mock(Scene.class, "mockScene");
		final Stage mockStage = context.mock(Stage.class, "mockStage");
		final FileTreeViewDemo fixture = new FileTreeViewDemo() {

			@Override
			protected BorderPane newBorderPane() {
				return mockBorderPane;
			}

			@Override
			protected Scene newScene(BorderPane root) {
				return mockScene;
			}

			@Override
			protected void populateFileTreeViewPane(BorderPane root) {
				// NOTHING
			}

		};

		context.checking(new Expectations() {
			{
				oneOf(mockBorderPane).setUserData(with(any(HostServices.class)));
			}
		});

		fixture.start(mockStage);
	}

}
