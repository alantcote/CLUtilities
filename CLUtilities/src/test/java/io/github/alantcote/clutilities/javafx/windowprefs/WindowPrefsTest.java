package io.github.alantcote.clutilities.javafx.windowprefs;

import static org.junit.Assert.*;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import de.saxsys.mvvmfx.testingutils.jfxrunner.TestInJfxThread;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.stage.Stage;

/**
 * Test case for {@link cotelab.dupfilefinder2.WindowPrefs#WindowPrefs}.
 */
@RunWith(JfxRunner.class)
public class WindowPrefsTest {
	/**
	 * Test method for
	 * {@link cotelab.dupfilefinder2.WindowPrefs#establishPreferencesNode()}.
	 * 
	 * @throws BackingStoreException if test throws one.
	 */
	@Test
	@TestInJfxThread
	public void testEstablishPreferencesNode() throws BackingStoreException {
		Class<?> clazz = getClass();
		Stage stage = new Stage();
		final SimpleIntegerProperty igpCount = new SimpleIntegerProperty(0);
		final SimpleIntegerProperty pnCount = new SimpleIntegerProperty(0);
		final SimpleIntegerProperty psCount = new SimpleIntegerProperty(0);
		final SimpleIntegerProperty urCount = new SimpleIntegerProperty(0);
		WindowPrefs fixture = new WindowPrefs(clazz, stage) {

			@Override
			protected void inizGeometryPrefs() {
				igpCount.set(1 + igpCount.get());
			}

			@Override
			protected Preferences prefsNode(String path, Preferences base) {
				pnCount.set(1 + pnCount.get());

				return null;
			}

			@Override
			protected void prefsSync() throws BackingStoreException {
				psCount.set(1 + psCount.get());
			}

			@Override
			protected Preferences userRoot() {
				urCount.set(1 + urCount.get());

				return null;
			}

		};

		fixture.establishPreferencesNode();

		assertEquals(1, igpCount.get());
		assertEquals(2, pnCount.get());
		assertEquals(2, psCount.get());
		assertEquals(2, urCount.get());
	}

	/**
	 * Test method for
	 * {@link cotelab.dupfilefinder2.WindowPrefs#inizGeometryPrefs()}.
	 */
	@Test
	public void testInizGeometryPrefs() {
		// can't mock Preferences, so I see know useful way to test this method.
		// the problem is related to the Java modules mechanism.
	}

	/**
	 * Test method for
	 * {@link cotelab.dupfilefinder2.WindowPrefs#newMetricListener(java.lang.String)}.
	 * 
	 * @throws BackingStoreException if the test code throws one.
	 */
	@Test
	@TestInJfxThread
	public void testNewMetricListener() throws BackingStoreException {
		Class<?> clazz = getClass();
		Stage stage = new Stage();
		final SimpleIntegerProperty epnCount = new SimpleIntegerProperty(0);
		final SimpleIntegerProperty igpCount = new SimpleIntegerProperty(0);
		WindowPrefs fixture = new WindowPrefs(clazz, stage) {

			@Override
			protected void establishPreferencesNode() throws BackingStoreException {
				epnCount.set(1 + epnCount.get());
			}

			@Override
			protected void inizGeometryPrefs() {
				igpCount.set(1 + igpCount.get());
			}

		};

		assertNotNull(fixture.newMetricListener("key"));

		assertEquals(1, epnCount.get());
		assertEquals(1, igpCount.get());
	}

	/**
	 * Test method for {@link cotelab.dupfilefinder2.WindowPrefs#userRoot()}.
	 * @throws BackingStoreException 
	 */
	@Test
	@TestInJfxThread
	public void testUserRoot() throws BackingStoreException {
		Class<?> clazz = getClass();
		Stage stage = new Stage();
		WindowPrefs fixture = new WindowPrefs(clazz, stage);
		
		assertEquals(Preferences.userRoot(), fixture.userRoot());
	}

	/**
	 * Test method for
	 * {@link cotelab.dupfilefinder2.WindowPrefs#WindowPrefs(java.lang.Class, javafx.stage.Stage)}.
	 * 
	 * @throws BackingStoreException if test throws one.
	 */
	@Test
	@TestInJfxThread
	public void testWindowPrefs() throws BackingStoreException {
		Class<?> clazz = getClass();
		Stage stage = new Stage();
		final SimpleIntegerProperty epnCount = new SimpleIntegerProperty(0);
		final SimpleIntegerProperty igpCount = new SimpleIntegerProperty(0);
		@SuppressWarnings("unused")
		WindowPrefs fixture = new WindowPrefs(clazz, stage) {

			@Override
			protected void establishPreferencesNode() throws BackingStoreException {
				epnCount.set(1 + epnCount.get());
			}

			@Override
			protected void inizGeometryPrefs() {
				igpCount.set(1 + igpCount.get());
			}

		};

		assertEquals(1, epnCount.get());
		assertEquals(1, igpCount.get());
	}

}
