package io.github.alantcote.clutilities.demo;

import java.io.File;
import java.util.prefs.BackingStoreException;

import io.github.alantcote.clutilities.javafx.scene.control.FileTreeItem;
import io.github.alantcote.clutilities.javafx.scene.control.FileTreeView;
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
 * An application to demo {@link FileTreeView}.
 */
public class FileTreeViewDemo extends Application {
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

			populateFileTreeViewPane(root);

			stageSetScene(primaryStage, scene);
			stageSetTitle(primaryStage);

			stageSetOnShown(primaryStage);

			stageShow(primaryStage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the {@link FileTreeView} to be displayed by this demo.
	 * 
	 * @return the new view.
	 */
	protected TreeView<File> createFileTreeView() {
		TreeItem<File> rootFileTreeItem = newFileTreeItem();
		TreeView<File> fileTreeView = newFileTreeView(rootFileTreeItem);

		return fileTreeView;
	}

	/**
	 * @return a new {@link BorderPane}.
	 */
	protected BorderPane newBorderPane() {
		return new BorderPane();
	}

	/**
	 * @return a new {@link FileTreeItem} to wrap a synthetic root, which acts as a
	 *         parent for the known file systems.
	 */
	protected FileTreeItem newFileTreeItem() {
		return new FileTreeItem(null);
	}

	/**
	 * Factory for instances of {@link FileTreeView}.
	 * 
	 * @param rootFileTreeItem the root item for the tree.
	 * @return a new instance.
	 */
	protected FileTreeView newFileTreeView(TreeItem<File> rootFileTreeItem) {
		return new FileTreeView(rootFileTreeItem);
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
	protected void populateFileTreeViewPane(BorderPane root) {
		TreeView<File> fileTreeView = createFileTreeView();

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
					windowPrefs = new WindowPrefs(FileTreeViewDemo.class, primaryStage);
				} catch (BackingStoreException e) {
					System.err.println("FileTreeViewDemo.start(): caught: " + e.getMessage());
					e.printStackTrace();
					System.err.println("FileTreeViewDemo.start(): continuing . . .");
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
		primaryStage.setTitle("File TreeView Demo");
	}

	/**
	 * Show a {@link Stage}.
	 * @param primaryStage the {@link Stage}.
	 */
	protected void stageShow(Stage primaryStage) {
		primaryStage.show();
	}
}
