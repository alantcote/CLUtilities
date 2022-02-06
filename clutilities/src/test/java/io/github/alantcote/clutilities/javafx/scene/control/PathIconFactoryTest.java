package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

/**
 * Test method for
 * {@link io.github.alantcote.clutilities.javafx.scene.control.PathIconFactory}.
 */
public class PathIconFactoryTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.PathIconFactory#getIcon(java.nio.file.Path)}.
	 */
	@Test
	public void testGetIcon() {
		PathIconFactory fixture = new PathIconFactory();

		assertNotNull(fixture.getIcon(new File(".").toPath()));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.PathIconFactory#PathIconFactory()}.
	 */
	@Test
	public void testPathIconFactory() {
		PathIconFactory fixture = new PathIconFactory();

		assertNotNull(fixture);
		assertNotNull(fixture.fileIconFactory);
	}

}
