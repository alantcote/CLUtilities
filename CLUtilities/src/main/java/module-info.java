module clutilities {
	exports cotelab.util.demo;
	exports cotelab.util.javafx.scene.control;
	exports cotelab.util.javafx.util.callback;
	exports cotelab.util.javafx.windowprefs;
	
	requires transitive java.desktop;
	requires java.logging;
	requires transitive java.prefs;
	requires javafx.base;
	requires javafx.controls;
	requires transitive javafx.graphics;
	requires javafx.swing;
}