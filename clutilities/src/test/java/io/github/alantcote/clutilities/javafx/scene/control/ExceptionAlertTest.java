package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import javafx.scene.control.Alert.AlertType;

/**
 * Test case for
 * {@link io.github.alantcote.clutilities.javafx.scene.control.ExceptionAlert}.
 */
@RunWith(JfxRunner.class)
public class ExceptionAlertTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.ExceptionAlert#ExceptionAlert(javafx.scene.control.Alert.AlertType, java.lang.Throwable, java.lang.String, javafx.scene.control.ButtonType[])}.
	 */
	@Test
	@TestInJfxThread
	public void testExceptionAlert() {
		Throwable throwable = new Throwable();

		throwable.fillInStackTrace();

		assertNotNull(new ExceptionAlert(AlertType.ERROR, throwable, "Test Alert"));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.ExceptionAlert#getBuffer(java.io.StringWriter)}.
	 */
	@Test
	@TestInJfxThread
	public void testGetBuffer() {
		Throwable throwable = new Throwable();

		throwable.fillInStackTrace();

		ExceptionAlert fixture = new ExceptionAlert(AlertType.ERROR, throwable, "Test Alert");
		StringWriter stringWriter = new StringWriter();

		assertNotNull(fixture.getBuffer(stringWriter));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.ExceptionAlert#newPrintWriter(java.io.StringWriter)}.
	 */
	@Test
	@TestInJfxThread
	public void testNewPrintWriter() {
		Throwable throwable = new Throwable();

		throwable.fillInStackTrace();

		ExceptionAlert fixture = new ExceptionAlert(AlertType.ERROR, throwable, "Test Alert");
		StringWriter stringWriter = new StringWriter();

		assertNotNull(fixture.newPrintWriter(stringWriter));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.ExceptionAlert#newString(java.lang.StringBuffer)}.
	 */
	@Test
	@TestInJfxThread
	public void testNewString() {
		Throwable throwable = new Throwable();

		throwable.fillInStackTrace();

		ExceptionAlert fixture = new ExceptionAlert(AlertType.ERROR, throwable, "Test Alert");
		StringBuffer stringBuffer = new StringBuffer();

		assertNotNull(fixture.newString(stringBuffer));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.ExceptionAlert#newStringWriter()}.
	 */
	@Test
	@TestInJfxThread
	public void testNewStringWriter() {
		Throwable throwable = new Throwable();

		throwable.fillInStackTrace();

		ExceptionAlert fixture = new ExceptionAlert(AlertType.ERROR, throwable, "Test Alert");

		assertNotNull(fixture.newStringWriter());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.ExceptionAlert#printStackTrace(java.lang.Throwable)}.
	 */
	@Test
	@TestInJfxThread
	public void testPrintStackTrace() {
		Throwable throwable = new Throwable();
		StringWriter stringWriter = new StringWriter();

		throwable.fillInStackTrace();

		ExceptionAlert fixture = new ExceptionAlert(AlertType.ERROR, throwable, "Test Alert") {

			@Override
			protected StringBuffer getBuffer(StringWriter sw) {
				assertTrue(stringWriter == sw);

				return super.getBuffer(sw);
			}

			@Override
			protected PrintWriter newPrintWriter(StringWriter sw) {
				assertTrue(stringWriter == sw);

				return super.newPrintWriter(sw);
			}

			@Override
			protected String newString(StringBuffer sb) {
				assertTrue(stringWriter.getBuffer() == sb);

				return super.newString(sb);
			}

			@Override
			protected StringWriter newStringWriter() {
				return stringWriter;
			}

		};

		fixture.printStackTrace(throwable);
	}

}
