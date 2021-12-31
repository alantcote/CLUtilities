module clutilities {
	exports net.sf.cotelab.util;
	exports net.sf.cotelab.util.collections;
	exports net.sf.cotelab.util.io;
	exports net.sf.cotelab.util.javafx.tree;
	exports net.sf.cotelab.util.math;
	exports net.sf.cotelab.util.swing.tree;
	
	requires transitive java.desktop;
	requires java.logging;
	requires transitive javafx.graphics;
	requires javafx.controls;
	requires javafx.swing;
}