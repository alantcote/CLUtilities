package io.github.alantcote.fxutilities.demo;

import java.util.Optional;
import java.util.prefs.BackingStoreException;

import io.github.alantcote.fxutilities.javafx.scene.control.ExceptionAlert;
import io.github.alantcote.fxutilities.javafx.windowprefs.WindowPrefs;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * An application to demo {@link ExceptionAlert}.
 */
public class AlertsDemo extends Application {
	/**
	 * Default title for the application window.
	 */
	public static final String STAGE_TITLE = "Alerts Demo";

	/**
	 * The entry point for the application.
	 * 
	 * @param args command-line arguments.
	 */
	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * Window geometry management.
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

			root.setUserData(getHostServices()); // covert communication to whomever

			populateRootPane(root);

			primaryStage.setScene(scene);
			primaryStage.setTitle(STAGE_TITLE);
			primaryStage.setMinWidth(300);
			primaryStage.setMinHeight(250);

			primaryStage.setOnShown(new EventHandler<WindowEvent>() {

				@Override
				public void handle(WindowEvent event) {
					try {
						windowPrefs = new WindowPrefs(AlertsDemo.class, primaryStage);
					} catch (BackingStoreException e) {
						System.err.println("AlertsDemo.populateRootPane(): caught: " + e.getMessage());
						e.printStackTrace();
						System.err.println("AlertsDemo.populateRootPane(): continuing . . .");
					}
				}

			});

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Manufacture a new {@link BorderPane}.
	 * 
	 * @return a new {@link BorderPane}.
	 */
	protected BorderPane newBorderPane() {
		return new BorderPane();
	}

	/**
	 * Manufacture a new {@link Scene}.
	 * 
	 * @param root the root pane to wrap.
	 * @return a new {@link Scene}.
	 */
	protected Scene newScene(BorderPane root) {
		return new Scene(root);
	}

	/**
	 * Load up the root pane of the window with the demo GUI.
	 * 
	 * @param root the root pane.
	 */
	protected void populateRootPane(BorderPane root) {
		Button confirmationButton = new Button("Confirmation Alert");
		Button errorButton = new Button("Error Alert");
		Button informationButton = new Button("Information Alert");
		Button warningButton = new Button("Warning Alert");
		Button exceptionButton = new Button("Exception Alert");
		VBox buttonVBox = new VBox();

		buttonVBox.setSpacing(10);
		buttonVBox.setFillWidth(false);
		buttonVBox.setAlignment(Pos.CENTER);
		buttonVBox.getChildren().addAll(informationButton, confirmationButton, warningButton, errorButton,
				exceptionButton);

		root.setCenter(buttonVBox);

		informationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert theAlert = new Alert(AlertType.INFORMATION, "Content text.");
				Optional<ButtonType> result;

				theAlert.setHeaderText("Information"); // upper panel text
				theAlert.setTitle("Information Alert"); // window title

				result = theAlert.showAndWait();

				System.out.println("result = " + result);
			}
		});

		confirmationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert theAlert = new Alert(AlertType.CONFIRMATION, "Content text.");
				Optional<ButtonType> result;

				theAlert.setHeaderText("Confirm"); // upper panel text
				theAlert.setTitle("Confirmation Alert"); // window title

				result = theAlert.showAndWait();

				System.out.println("result = " + result);
			}
		});

		warningButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert theAlert = new Alert(AlertType.WARNING, "Content text.");
				Optional<ButtonType> result;

				theAlert.setHeaderText("Warning"); // upper panel text
				theAlert.setTitle("Warning Alert"); // window title

				result = theAlert.showAndWait();

				System.out.println("result = " + result);
			}
		});

		errorButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Alert theAlert = new Alert(AlertType.ERROR, "Content text.");
				Optional<ButtonType> result;

				theAlert.setHeaderText("Error"); // upper panel text
				theAlert.setTitle("Error Alert"); // window title

				result = theAlert.showAndWait();

				System.out.println("result = " + result);
			}
		});

		exceptionButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int num = 1;
				int denom = 0;

				try {
					int frac = num / denom;
				} catch (Throwable e) {
					Alert theAlert = new ExceptionAlert(AlertType.ERROR, e, "Exception Alert");
					Optional<ButtonType> result;

					result = theAlert.showAndWait();

					System.out.println("result = " + result);
				}
			}
		});
	}
}
