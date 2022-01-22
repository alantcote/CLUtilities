package cotelab.util.demo;

import java.io.File;

import cotelab.util.javafx.scene.control.FileTreeItem;
import cotelab.util.javafx.scene.control.FileTreeView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
	 * {@inheritDoc}
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = newBorderPane();
			// Scene scene = new Scene(root,1000,900);
			Scene scene = newScene(root);

			root.setUserData(getHostServices()); // covert communication to controller

			populateFileTreeViewPane(root);

			primaryStage.setScene(scene);
			primaryStage.setTitle("File TreeView Demo");

			primaryStage.show();
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
}
