package io.github.alantcote.clutilities.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem;
import io.github.alantcote.clutilities.javafx.scene.control.FileTreeView;
import io.github.alantcote.clutilities.jmock.TestCaseWithJMock;
import javafx.application.HostServices;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.event.WeakEventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Test case for {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo}.
 */
@RunWith(JfxRunner.class)
public class FileTreeViewDemoTest extends TestCaseWithJMock {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#createFileTreeView()}.
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
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		// Calls a static method in its superclass. I have no idea how to write
		// a legitimate unit test class for that.
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#newBorderPane()}.
	 */
	@Test
	public void testNewBorderPane() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();

		assertNotNull(fixture.newBorderPane());
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#newFileTreeItem()}.
	 */
	@Test
	public void testNewFileTreeItem() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();

		assertNotNull(fixture.newFileTreeItem());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#newFileTreeView(javafx.scene.control.TreeItem)}.
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
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#newScene(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testNewScene() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();
		final BorderPane mockBorderPane = new BorderPane();

		assertNotNull(fixture.newScene(mockBorderPane));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#populateFileTreeViewPane(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	@TestInJfxThread
	public void testPopulateFileTreeViewPane() {
		final BorderPane mockBorderPane = context.mock(BorderPane.class, "mockBorderPane");
		@SuppressWarnings("unchecked")
		final TreeView<File> mockTreeView = context.mock(TreeView.class, "mockTreeView");
		@SuppressWarnings("unchecked")
		final ObservableList<Node> mockObservableList = context.mock(ObservableList.class, "mockObservableList");
		final FileTreeViewDemo fixture = new FileTreeViewDemo() {

			@Override
			protected TreeView<File> createFileTreeView() {
				return mockTreeView;
			}

		};

		context.checking(new Expectations() {
			{
				oneOf(mockBorderPane).getChildren();
				will(returnValue(mockObservableList));

				oneOf(mockObservableList).addListener(with(any(ListChangeListener.class)));

				oneOf(mockBorderPane).getChildren();
				will(returnValue(mockObservableList));

				oneOf(mockObservableList).add(mockTreeView);
			}
		});

		fixture.populateFileTreeViewPane(mockBorderPane);
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#start(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStartStage() {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
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

					@Override
					protected void stageSetOnShown(Stage primaryStage) {
						// NOTHING
					}

					@Override
					protected void stageSetScene(Stage primaryStage, Scene scene) {
						// NOTHING
					}

					@Override
					protected void stageSetTitle(Stage primaryStage) {
						// NOTHING
					}

					@Override
					protected void stageShow(Stage primaryStage) {
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
			
		});
	}

}
