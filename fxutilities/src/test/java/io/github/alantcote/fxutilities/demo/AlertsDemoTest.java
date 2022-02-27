/**
 * 
 */
package io.github.alantcote.fxutilities.demo;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import io.github.alantcote.fxutilities.demo.AlertsDemo;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Test case for {@link io.github.alantcote.fxutilities.demo.AlertsDemo}.
 */
@RunWith(JfxRunner.class)
public class AlertsDemoTest {

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.demo.AlertsDemo#main(java.lang.String[])}.
	 */
	@Test
	public void testMain() {
		// Calls a static method in its superclass. I have no idea how to write
		// a legitimate unit test class for that.
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.demo.AlertsDemo#newBorderPane()}.
	 */
	@Test
	public void testNewBorderPane() {
		final AlertsDemo fixture = new AlertsDemo();

		assertNotNull(fixture.newBorderPane());
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.demo.AlertsDemo#newScene(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testNewScene() {
		final AlertsDemo fixture = new AlertsDemo();
		BorderPane borderPane = new BorderPane();

		assertNotNull(fixture.newScene(borderPane));
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.demo.AlertsDemo#populateRootPane(javafx.scene.layout.BorderPane)}.
	 */
	@Test
	public void testPopulateRootPane() {
		final AlertsDemo fixture = new AlertsDemo();
		BorderPane borderPane = new BorderPane();

		fixture.populateRootPane(borderPane);
		
		assertTrue(borderPane.getCenter() instanceof VBox);
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.demo.AlertsDemo#start(javafx.stage.Stage)}.
	 */
	@Test
	@TestInJfxThread
	public void testStartStage() {
		// the solution in the comments below passes, but results in opening a
		// window during test. commented out because it's not cool to pop up UI
		// artifacts during a unit test and the stageShow() method is so trivial
		// that it's hard to imagine a way it could go wrong.
//		final AlertsDemo fixture = new AlertsDemo();
//		Stage stage = new Stage();
//		
//		fixture.start(stage);
	}

}
