module clutilities {
	exports cotelab.util.demo;
	exports cotelab.util.javafx.scene.control;
	exports cotelab.util.javafx.util.callback;
	
	requires transitive java.desktop;
	requires java.logging;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.swing;
	requires javafx.base;
}