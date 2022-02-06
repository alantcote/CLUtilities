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
		StringWriter sw = newStringWriter();
		PrintWriter pw = newPrintWriter(sw);

		exception.printStackTrace(pw);
		pw.close();

		String stackTrace = newString(getBuffer(sw));

		return stackTrace;
	}

	/**
	 * Create a new {@link StringWriter}.
	 * @return the new object.
	 */
	protected StringWriter newStringWriter() {
		return new StringWriter();
	}

	/**
	 * Wrap a {@link PrintWriter} around a {@link StringWriter}.
	 * @param sw a {@link StringWriter}.
	 * @return the {@link PrintWriter}.
	 */
	protected PrintWriter newPrintWriter(StringWriter sw) {
		return new PrintWriter(sw);
	}

	/**
	 * Get the buffer from a {@link StringWriter}.
	 * @param sw a {@link StringWriter}.
	 * @return the buffer.
	 */
	protected StringBuffer getBuffer(StringWriter sw) {
		return sw.getBuffer();
	}
	
	/**
	 * Get the {@link String} value of a {@link StringBuffer}.
	 * @param sb a {@link StringBuffer}.
	 * @return the {@link String} value.
	 */
	protected String newString(StringBuffer sb) {
		return new String(sb);
	}
}
