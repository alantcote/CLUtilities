package io.github.alantcote.clutilities.demo;

import static org.junit.Assert.*;

import java.nio.file.Path;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import io.github.alantcote.clutilities.javafx.scene.control.PathTreeItem;
import io.github.alantcote.clutilities.javafx.scene.control.PathTreeView;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Test case for {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo}.
 */
@RunWith(JfxRunner.class)
public class PathTreeViewDemoTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#createPathTreeView()}.
	 */
	@Test
	public void testCreatePathTreeView() {
		final PathTreeItem pathTreeItem = new PathTreeItem(null);
		final PathTreeView pathTreeView = new PathTreeView(pathTreeItem);
		PathTreeViewDemo fixture = new PathTreeViewDemo() {

			@Override
			protected PathTreeItem newPathTreeItem() {
				return pathTreeItem;
			}

			@Override
			protected PathTreeView newPathTreeView(TreeItem<Path> rootPathTreeItem) {
				assertTrue(pathTreeItem == rootPathTreeItem);

				return pathTreeView;
			}

		};

		TreeView<Path> result = fixture.createPathTreeView();

		assertEquals(pathTreeView, result);
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		// Calls a static method in its superclass. I have no idea how to write
		// a legitimate unit test class for that.
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#newBorderPane()}.
	 */
	@Test
	public void testNewBorderPane() {
		final PathTreeViewDemo fixture = new PathTreeViewDemo();

		assertNotNull(fixture.newBorderPane());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#newPathTreeItem()}.
	 */
	@Test
	public void testNewPathTreeItem() {
		final PathTreeViewDemo fixture = new PathTreeViewDemo();

		assertNotNull(fixture.newPathTreeItem());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#newPathTreeView(javafx.scene.control.TreeItem)}.
	 */
	@Test
	public void testNewPathTreeView() {
		final PathTreeViewDemo fixture = new PathTreeViewDemo();
		final TreeItem<Path> pathTreeItem = new PathTreeItem(null);

		assertNotNull(fixture.newPathTreeView(pathTreeItem));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#newScene(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testNewScene() {
		final PathTreeViewDemo fixture = new PathTreeViewDemo();
		final BorderPane borderPane = new BorderPane();

		assertNotNull(fixture.newScene(borderPane));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#populatePathTreeViewPane(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testPopulatePathTreeViewPane() {
		final PathTreeItem pathTreeItem = new PathTreeItem(null);
		final TreeView<Path> treeView = new PathTreeView(pathTreeItem);
		final BorderPane borderPane = new BorderPane();
		final PathTreeViewDemo fixture = new PathTreeViewDemo() {

			@Override
			protected TreeView<Path> createPathTreeView() {
				return treeView;
			}

		};

		fixture.populatePathTreeViewPane(borderPane);

		assertTrue(treeView == borderPane.getCenter());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#stageSetOnShown(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStageSetOnShown() {
		final PathTreeViewDemo fixture = new PathTreeViewDemo();
		Stage stage = new Stage();

		fixture.stageSetOnShown(stage);

		assertNotNull(stage.getOnShown());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#stageSetScene(javafx.stage.Stage, javafx.scene.Scene)}.
	 */
	@Test
	@TestInJfxThread
	public void testStageSetScene() {
		final PathTreeViewDemo fixture = new PathTreeViewDemo();
		Stage stage = new Stage();
		BorderPane borderPane = new BorderPane();
		Scene scene = new Scene(borderPane);

		fixture.stageSetScene(stage, scene);

		assertTrue(scene == stage.getScene());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#stageSetTitle(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStageSetTitle() {
		final PathTreeViewDemo fixture = new PathTreeViewDemo();
		Stage stage = new Stage();

		fixture.stageSetTitle(stage);

		assertEquals("Path TreeView Demo", stage.getTitle());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#stageShow(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStageShow() {
		// the solution in the comments below passes, but results in opening a
		// window during test. commented out because it's not cool to pop up UI
		// artifacts during a unit test and the stageShow() method is so trivial
		// that it's hard to imagine a way it could go wrong.
//		final PathTreeViewDemo fixture = new PathTreeViewDemo();
//		Stage stage = new Stage();
//		
//		fixture.stageShow(stage);
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.demo.PathTreeViewDemo#start(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStartStage() {
		final BorderPane borderPane = new BorderPane();
		final Scene scene = new Scene(borderPane);
		final Stage stage = new Stage();
		final PathTreeViewDemo fixture = new PathTreeViewDemo() {

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
			protected void populatePathTreeViewPane(BorderPane root) {
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
