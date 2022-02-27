/**
 * This module provides what (hopefully) are widely-useful utility classes.
 */
module fxutilities {
	exports io.github.alantcote.fxutilities.demo;
	exports io.github.alantcote.fxutilities.javafx.scene.control;
	exports io.github.alantcote.fxutilities.javafx.util.callback;
	exports io.github.alantcote.fxutilities.javafx.windowprefs;

	requires transitive java.desktop;
	requires transitive java.prefs;
	requires transitive javafx.controls;
	requires transitive javafx.swing;
	requires javafx.base;
	requires javafx.graphics;
}