package io.github.alantcote.fxutilities.javafx.scene.control;

import java.nio.file.Path;

import javafx.scene.image.ImageView;

/**
 * A caching provider of system-authentic icons for paths.
 */
public class PathIconFactory {
	/**
	 * A source for platform-authentic file icons.
	 */
	protected final FileIconFactory fileIconFactory;

	/**
	 * Construct a new object.
	 */
	public PathIconFactory() {
		fileIconFactory = new FileIconFactory();
	}

	/**
	 * Get the system-authentic icon image appropriate for a given path.
	 * 
	 * @param aPath the given path.
	 * @return the icon image.
	 */
	public ImageView getIcon(Path aPath) {
		return fileIconFactory.getIcon(aPath.toFile());
	}

}
