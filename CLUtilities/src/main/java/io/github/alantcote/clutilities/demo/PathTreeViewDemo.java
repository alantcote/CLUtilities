package io.github.alantcote.clutilities.demo;

import java.nio.file.Path;
import java.util.prefs.BackingStoreException;

import io.github.alantcote.clutilities.javafx.scene.control.PathTreeItem;
import io.github.alantcote.clutilities.javafx.scene.control.PathTreeView;
import io.github.alantcote.clutilities.javafx.windowprefs.WindowPrefs;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * An application to demo {@link PathTreeView}.
 */
public class PathTreeViewDemo extends Application {
	/**
	 * The entry point for the application.
	 * 
	 * @param args command-line arguments.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Persistent window geometry support.
	 */
	protected WindowPrefs windowPrefs = null;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = newBorderPane();
			Scene scene = newScene(root);

			root.setUserData(getHostServices()); // covert communication to controller

			populatePathTreeViewPane(root);

			stageSetScene(primaryStage, scene);
			stageSetTitle(primaryStage);

			stageSetOnShown(primaryStage);

			stageShow(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the {@link PathTreeView} to be displayed by this demo.
	 * 
	 * @return the new view.
	 */
	protected TreeView<Path> createPathTreeView() {
		TreeItem<Path> rootPathTreeItem = newPathTreeItem();
		TreeView<Path> fileTreeView = newPathTreeView(rootPathTreeItem);

		return fileTreeView;
	}

	/**
	 * @return a new {@link BorderPane}.
	 */
	protected BorderPane newBorderPane() {
		return new BorderPane();
	}

	/**
	 * @return a new {@link PathTreeItem} to wrap a synthetic root, which acts as a
	 *         parent for the known file systems.
	 */
	protected PathTreeItem newPathTreeItem() {
		return new PathTreeItem(null);
	}

	/**
	 * Factory for instances of {@link PathTreeView}.
	 * 
	 * @param rootPathTreeItem the root item for the tree.
	 * @return a new instance.
	 */
	protected PathTreeView newPathTreeView(TreeItem<Path> rootPathTreeItem) {
		return new PathTreeView(rootPathTreeItem);
	}

	/**
	 * Manufacture a new {@link Scene}.
	 * 
	 * @param root the root pane to wrap.
	 * @return the new object.
	 */
	protected Scene newScene(BorderPane root) {
		return new Scene(root);
	}

	/**
	 * Load up the root pane of the window with a tree view.
	 * 
	 * @param root the root pane.
	 */
	protected void populatePathTreeViewPane(BorderPane root) {
		TreeView<Path> fileTreeView = createPathTreeView();

		root.setCenter(fileTreeView);
	}

	/**
	 * Establish {@link #windowPrefs} when the stage is shown.
	 * @param primaryStage the {@link Stage}.
	 */
	protected void stageSetOnShown(Stage primaryStage) {
		primaryStage.setOnShown(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				try {
					windowPrefs = new WindowPrefs(PathTreeViewDemo.class, primaryStage);
				} catch (BackingStoreException e) {
					System.err.println("PathTreeViewDemo.start(): caught: " + e.getMessage());
					e.printStackTrace();
					System.err.println("PathTreeViewDemo.start(): continuing . . .");
				}
			}

		});
	}

	/**
	 * Set the {@link Scene} for a {@link Stage}.
	 * @param primaryStage the {@link Stage}.
	 * @param scene the {@link Scene}.
	 */
	protected void stageSetScene(Stage primaryStage, Scene scene) {
		primaryStage.setScene(scene);
	}

	/**
	 * Set the title for the {@link Stage}.
	 * @param primaryStage the {@link Stage}.
	 */
	protected void stageSetTitle(Stage primaryStage) {
		primaryStage.setTitle("Path TreeView Demo");
	}

	/**
	 * Show a {@link Stage}.
	 * @param primaryStage the {@link Stage}.
	 */
	protected void stageShow(Stage primaryStage) {
		primaryStage.show();
	}
}
