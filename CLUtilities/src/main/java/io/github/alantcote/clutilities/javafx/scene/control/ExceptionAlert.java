package io.github.alantcote.clutilities.javafx.scene.control;

import java.io.PrintWriter;
import java.io.StringWriter;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;

public class ExceptionAlert extends Alert {
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

	protected String printStackTrace(Throwable exception) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		exception.printStackTrace(pw);
		pw.close();

		String stackTrace = new String(sw.getBuffer());

		return stackTrace;
	}
}
