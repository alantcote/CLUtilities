package io.github.alantcote.fxutilities.javafx.windowprefs;

import static org.junit.Assert.*;

import java.util.prefs.Preferences;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Test case for {@link MetricListener}.
 */
@RunWith(JfxRunner.class)
public class MetricListenerTest {
	public static final String KEY = "preference";
	public static final Preferences NODE = Preferences.userRoot();

	/**
	 * Test method for
	 * {@link MetricListener#changed(javafx.beans.value.ObservableValue, java.lang.Number, java.lang.Number)}.
	 */
	@Test
	@TestInJfxThread
	public void testChanged() {
		final SimpleIntegerProperty ppdCount = new SimpleIntegerProperty(0);
		final SimpleIntegerProperty psCount = new SimpleIntegerProperty(0);
		DelayedJobJar testDelayedJobJar = new DelayedJobJar();
		MetricListener fixture = new MetricListener(NODE, KEY, testDelayedJobJar) {
			@Override
			protected void prefsPutDouble(double newValue) {
				ppdCount.set(1 + ppdCount.get());
			}

			@Override
			protected void prefsSync() {
				psCount.set(1 + psCount.get());
			}
		};

		fixture.changed(null, 0, 1);

		assertEquals(1, fixture.valueToSet);
		assertEquals(0, ppdCount.get());
		assertEquals(0, psCount.get());
	}

	/**
	 * Test method for
	 * {@link MetricListener#MetricListener(java.util.prefs.Preferences, java.lang.String)}.
	 */
	@Test
	@TestInJfxThread
	public void testMetricListener() {
		DelayedJobJar testDelayedJobJar = new DelayedJobJar();
		MetricListener fixture = new MetricListener(NODE, KEY, testDelayedJobJar);

		assertEquals(NODE, fixture.prefs);
		assertEquals(KEY, fixture.key);
		assertEquals(testDelayedJobJar, fixture.delayedJobJar);
	}

	/**
	 * Test method for
	 * {@link MetricListener#prefsPutDouble(double)}.
	 */
	@Test
	public void testPrefsPutDouble() {
		// haven't managed to make a mock of Preferences, so punt.
	}

	/**
	 * Test method for
	 * {@link MetricListener#prefsSync()}.
	 */
	@Test
	public void testPrefsSync() {
		// haven't managed to make a mock of Preferences, so punt.
	}

}
