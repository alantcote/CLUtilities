module clutilities {
	exports io.github.alantcote.clutilities.demo;
	exports io.github.alantcote.clutilities.javafx.scene.control;
	exports io.github.alantcote.clutilities.javafx.util.callback;
	exports io.github.alantcote.clutilities.javafx.windowprefs;
	exports io.github.alantcote.clutilities.jmock;

	requires transitive java.desktop;
	requires transitive java.logging;
	requires transitive java.prefs;
	requires transitive javafx.base;
	requires transitive javafx.controls;
	requires transitive javafx.graphics;
	requires transitive javafx.swing;
	requires transitive jmock;
	requires transitive jmock.imposters;
	requires transitive junit;
	requires hamcrest.all ;
}