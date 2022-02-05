module clutilities {
	exports io.github.alantcote.clutilities.demo;
	exports io.github.alantcote.clutilities.javafx.scene.control;
	exports io.github.alantcote.clutilities.javafx.util.callback;
	exports io.github.alantcote.clutilities.javafx.windowprefs;

	requires transitive java.desktop;
	requires transitive java.prefs;
	requires transitive javafx.controls;
	requires transitive javafx.swing;
	requires javafx.base;
	requires javafx.graphics;
//	requires junit;
//	requires mvvmfx.testing.utils;
}