package io.github.alantcote.fxutilities.javafx.windowprefs;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.stage.Stage;

/**
 * Persistent window geometry tracker.
 */
public class WindowPrefs {
	/**
	 * Preference key for the full-screen preference.
	 */
	public static final String KEY_WINDOW_FULL_SCREEN = "WINDOW_FULL_SCREEN";

	/**
	 * Preference key for the window height preference.
	 */
	public static final String KEY_WINDOW_HEIGHT = "WINDOW_HEIGHT";

	/**
	 * Preference key for the iconified preference.
	 */
	public static final String KEY_WINDOW_ICONIFIED = "WINDOW_ICONIFIED";

	/**
	 * Preference key for the maximized preference.
	 */
	public static final String KEY_WINDOW_MAXIMIZED = "WINDOW_MAXIMIZED";

	/**
	 * Preference key for the window width preference.
	 */
	public static final String KEY_WINDOW_WIDTH = "WINDOW_WIDTH";

	/**
	 * Preference key for the window X-coordinate preference.
	 */
	public static final String KEY_WINDOW_X = "WINDOW_X";

	/**
	 * Preference key for the window Y-coordinate preference.
	 */
	public static final String KEY_WINDOW_Y = "WINDOW_Y";

	/**
	 * The class on behalf of which this object exists.
	 */
	protected Class<?> clazz = null;

	/**
	 * The {@link Preferences} node in which to store tracked preferences.
	 */
	protected Preferences prefs = null;

	/**
	 * The {@link Stage} whose geometry is tracked.
	 */
	protected Stage stage = null;

	/*
	 * Constructor.
	 * 
	 * @param aStage The app's @link(Stage).
	 * @throws BackingStoreException if thrown by the underlying code.
	 */
	/**
	 * Constructor.
	 * @param aClazz the app's {@link Class}.
	 * @param aStage the app's @link(Stage).
	 * @throws BackingStoreException if {@link Preferences} throws one.
	 */
	public WindowPrefs(Class<?> aClazz, Stage aStage) throws BackingStoreException {
		clazz = aClazz;
		stage = aStage;

		establishPreferencesNode();
		inizGeometryPrefs();
	}

	/**
	 * Get {@link #prefs}.
	 * @return {@link #prefs}.
	 */
	public Preferences getPrefs() {
		return prefs;
	}

	/**
	 * Set up the {@link Preferences} node, {@link #prefs}.
	 * 
	 * @throws BackingStoreException if thrown by the underlying code.
	 */
	protected void establishPreferencesNode() throws BackingStoreException {
		String path = "/" + clazz.getPackageName().replace('.', '/') + "/" + clazz.getSimpleName();
		Preferences base = userRoot();
		
		prefs = prefsNode(path, base);

		prefsSync();
	}

	/**
	 * Initialize the window geometry preferences.
	 * 
	 * Apply the height, width, x and y preferences to the window. If the
	 * preferences don't already exist in the persistent storage, the ones from the
	 * window are stored there.
	 * 
	 * Listeners are established to sense changes to the window geometry and reflect
	 * those changes into the persistent storage.
	 */
	protected void inizGeometryPrefs() {
		if (prefs.getDouble(KEY_WINDOW_HEIGHT, 0) == 0) {
			prefs.putDouble(KEY_WINDOW_HEIGHT, stage.getHeight());
		} else {
			stage.setHeight(prefs.getDouble(KEY_WINDOW_HEIGHT, 0));
		}

		stage.heightProperty().addListener(newMetricListener(KEY_WINDOW_HEIGHT));

		if (prefs.getDouble(KEY_WINDOW_WIDTH, 0) == 0) {
			prefs.putDouble(KEY_WINDOW_WIDTH, stage.getWidth());
		} else {
			stage.setWidth(prefs.getDouble(KEY_WINDOW_WIDTH, 0));
		}

		stage.widthProperty().addListener(newMetricListener(KEY_WINDOW_WIDTH));

		if (prefs.getDouble(KEY_WINDOW_X, 0) == 0) {
			prefs.putDouble(KEY_WINDOW_X, stage.getX());
		} else {
			stage.setX(prefs.getDouble(KEY_WINDOW_X, 0));
		}

		stage.xProperty().addListener(newMetricListener(KEY_WINDOW_X));

		if (prefs.getDouble(KEY_WINDOW_Y, 0) == 0) {
			prefs.putDouble(KEY_WINDOW_Y, stage.getY());
		} else {
			stage.setY(prefs.getDouble(KEY_WINDOW_Y, 0));
		}

		stage.yProperty().addListener(newMetricListener(KEY_WINDOW_Y));

		if (prefs.get(KEY_WINDOW_FULL_SCREEN, "XXX").equals("XXX")) {
			prefs.putBoolean(KEY_WINDOW_FULL_SCREEN, stage.isFullScreen());
		} else {
			stage.setFullScreen(prefs.getBoolean(KEY_WINDOW_FULL_SCREEN, false));
		}

		stage.fullScreenProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				prefs.putBoolean(KEY_WINDOW_FULL_SCREEN, newValue);

				try {
					prefsSync();
				} catch (BackingStoreException e) {
					System.err.println("AppPrefs.inizGeometryPrefs(): full screen listener caught . . .");
					e.printStackTrace();
					System.err.println("AppPrefs.inizGeometryPrefs(): proceeding.");
				}
			}
			
		});

		if (prefs.get(KEY_WINDOW_ICONIFIED, "XXX").equals("XXX")) {
			prefs.putBoolean(KEY_WINDOW_ICONIFIED, stage.isIconified());
		} else {
			stage.setIconified(prefs.getBoolean(KEY_WINDOW_ICONIFIED, false));
		}

		stage.iconifiedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				prefs.putBoolean(KEY_WINDOW_ICONIFIED, newValue);

				try {
					prefsSync();
				} catch (BackingStoreException e) {
					System.err.println("AppPrefs.inizGeometryPrefs(): iconified listener caught . . .");
					e.printStackTrace();
					System.err.println("AppPrefs.inizGeometryPrefs(): proceeding.");
				}
			}
			
		});

		if (prefs.get(KEY_WINDOW_MAXIMIZED, "XXX").equals("XXX")) {
			prefs.putBoolean(KEY_WINDOW_MAXIMIZED, stage.isMaximized());
		} else {
			stage.setMaximized(prefs.getBoolean(KEY_WINDOW_MAXIMIZED, false));
		}

		stage.maximizedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				prefs.putBoolean(KEY_WINDOW_MAXIMIZED, newValue);

				try {
					prefsSync();
				} catch (BackingStoreException e) {
					System.err.println("AppPrefs.inizGeometryPrefs(): maximized listener caught . . .");
					e.printStackTrace();
					System.err.println("AppPrefs.inizGeometryPrefs(): proceeding.");
				}
			}
			
		});

		try {
			prefsSync();
		} catch (BackingStoreException e) {
			System.err.println("AppPrefs.inizGeometryPrefs(): caught . . .");
			e.printStackTrace();
			System.err.println("AppPrefs.inizGeometryPrefs(): proceeding.");
		}
	}

	/**
	 * Create a {@link MetricListener} to maintain preference info with a given key.
	 * 
	 * @param aKey the key under which to record changes.
	 * @return a new object.
	 */
	protected MetricListener newMetricListener(String aKey) {
		return new MetricListener(prefs, aKey);
	}

	/**
	 * Call <code>base.node(path)</code>.
	 * @param path the desired node's path.
	 * @param base the base node to be asked for the desired node.
	 * @return the desired node.
	 */
	protected Preferences prefsNode(String path, Preferences base) {
		return base.node(path);
	}

	/**
	 * Call {@link #prefs}<code>.sync()</code>.
	 * @throws BackingStoreException if the sync method throws one.
	 */
	protected void prefsSync() throws BackingStoreException {
		prefs.sync();
	}

	/**
	 * Get the user root {@link Preferences} node.
	 * @return the user root {@link Preferences} node.
	 */
	protected Preferences userRoot() {
		return Preferences.userRoot();
	}
}
