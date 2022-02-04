package io.github.alantcote.clutilities.demo;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem;
import io.github.alantcote.clutilities.javafx.scene.control.FileTreeView;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Test case for {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo}.
 */
@RunWith(JfxRunner.class)
public class FileTreeViewDemoTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#createFileTreeView()}.
	 */
	@Test
	public void testCreateFileTreeView() {
		final FileTreeItem fileTreeItem = new FileTreeItem(null);
		final FileTreeView fileTreeView = new FileTreeView(fileTreeItem);
		FileTreeViewDemo fixture = new FileTreeViewDemo() {

			@Override
			protected FileTreeItem newFileTreeItem() {
				return fileTreeItem;
			}

			@Override
			protected FileTreeView newFileTreeView(TreeItem<File> rootFileTreeItem) {
				assertTrue(fileTreeItem == rootFileTreeItem);
				
				return fileTreeView;
			}

		};

		TreeView<File> result = fixture.createFileTreeView();

		assertEquals(fileTreeView, result);
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
	@Test
	public void testNewFileTreeView() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();
		final TreeItem<File> fileTreeItem = new FileTreeItem(null);

		assertNotNull(fixture.newFileTreeView(fileTreeItem));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#newScene(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testNewScene() {
		final FileTreeViewDemo fixture = new FileTreeViewDemo();
		final BorderPane borderPane = new BorderPane();

		assertNotNull(fixture.newScene(borderPane));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#populateFileTreeViewPane(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testPopulateFileTreeViewPane() {
		final FileTreeItem fileTreeItem = new FileTreeItem(null);
		final TreeView<File> treeView = new FileTreeView(fileTreeItem);
		final BorderPane borderPane = new BorderPane();
		final FileTreeViewDemo fixture = new FileTreeViewDemo() {

			@Override
			protected TreeView<File> createFileTreeView() {
				return treeView;
			}

		};

		fixture.populateFileTreeViewPane(borderPane);
		
		assertTrue(treeView == borderPane.getCenter());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.FileTreeViewDemo#start(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStartStage() {
		final BorderPane borderPane = new BorderPane();
		final Scene scene = new Scene(borderPane);
		final Stage stage = new Stage();
		final FileTreeViewDemo fixture = new FileTreeViewDemo() {

			@Override
			protected BorderPane newBorderPane() {
				return borderPane;
			}

			@Override
			protected Scene newScene(BorderPane root) {
				assertTrue(borderPane == root);
				
				return scene;
			}

			@Override
			protected void populateFileTreeViewPane(BorderPane root) {
				assertTrue(borderPane == root);
			}

			@Override
			protected void stageSetOnShown(Stage primaryStage) {
				assertTrue(stage == primaryStage);
			}

			@Override
			protected void stageSetScene(Stage primaryStage, Scene aScene) {
				assertTrue(stage == primaryStage);
				assertTrue(scene == aScene);
			}

			@Override
			protected void stageSetTitle(Stage primaryStage) {
				assertTrue(stage == primaryStage);
			}

			@Override
			protected void stageShow(Stage primaryStage) {
				assertTrue(stage == primaryStage);
			}

		};

		fixture.start(stage);
	}

}
