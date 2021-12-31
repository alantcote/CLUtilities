package net.sf.cotelab.util.javafx.tree;

import java.io.File;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class FileTreeViewDemo extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
	//		Scene scene = new Scene(root,1000,900);
			Scene scene = new Scene(root);
			
			root.setUserData(getHostServices()); // covert communication to controller
			
			populateFileTreeViewPane(root);
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("File TreeView Experiment");
			
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	protected void populateFileTreeViewPane(BorderPane root) {
		TreeView<File> fileTreeView = createFileTreeView();
		
		root.setCenter(fileTreeView);
	}

	protected TreeView<File> createFileTreeView() {
		TreeItem<File> rootFileTreeItem = new FileTreeItem(null);
		TreeView<File> fileTreeView = new TreeView<File>(rootFileTreeItem);
		FileIconFactory fileIconFactory = new FileIconFactory();
		
		fileTreeView.setCellFactory(new FileTreeCellFactory(fileIconFactory));
		
		return fileTreeView;
	}
}
