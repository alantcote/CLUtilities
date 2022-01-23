module clutilities {
	exports io.github.alantcote.clutilities.demo;
	exports io.github.alantcote.clutilities.javafx.scene.control;
	exports io.github.alantcote.clutilities.javafx.util.callback;
	exports io.github.alantcote.clutilities.javafx.windowprefs;

	requires transitive java.desktop;
	requires java.logging;
	requires transitive java.prefs;
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires javafx.swing;
}