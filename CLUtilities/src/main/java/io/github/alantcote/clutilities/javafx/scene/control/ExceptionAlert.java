package io.github.alantcote.clutilities.javafx.scene.control;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

/**
 * An {@link Alert} specialized to display exception stack traces.
 */
public class ExceptionAlert extends Alert {
	/**
	 * Construct a new object.
	 * @param alertType the {@link AlertType} to be used.
	 * @param exception the {@link Throwable} containing the stack trace.
	 * @param windowTitle a title for the alert window.
	 * @param buttons buttons to be used.
	 */
	public ExceptionAlert(AlertType alertType, Throwable exception, String windowTitle, ButtonType... buttons) {
		super(alertType, "Exception", buttons);

		setHeaderText("Caught: " + exception.getMessage());

		String traceText = printStackTrace(exception);
		TextArea textArea = new TextArea(traceText);
		ScrollPane scrollPane = new ScrollPane(textArea);
		DialogPane dialogPane = getDialogPane();

		textArea.setPrefWidth(1000);

		dialogPane.setContent(scrollPane);
	}

	/**
	 * Print a stack trace into a string.
	 * @param exception the {@link Throwable} containing the stack trace.
	 * @return the string containing the stack trace.
	 */
	protected String printStackTrace(Throwable exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		exception.printStackTrace(pw);
		pw.close();

		String stackTrace = new String(sw.getBuffer());

		return stackTrace;
	}
}
