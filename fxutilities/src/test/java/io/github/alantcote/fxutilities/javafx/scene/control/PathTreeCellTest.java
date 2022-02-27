package io.github.alantcote.fxutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;

import org.junit.Test;

import io.github.alantcote.fxutilities.javafx.scene.control.PathIconFactory;
import io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell;

/**
 * Test case for {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell}.
 */
public class PathTreeCellTest {

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell#PathTreeCell(io.github.alantcote.fxutilities.javafx.scene.control.PathIconFactory)}.
	 */
	@Test
	public void testPathTreeCell() {
		PathIconFactory pathIconFactory = new PathIconFactory();
		PathTreeCell fixture = new PathTreeCell(pathIconFactory);
		
		assertNotNull(fixture);
		assertTrue(pathIconFactory == fixture.pathIconFactory);
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell#displayName(java.nio.file.Path)}.
	 */
	@Test
	public void testDisplayName() {
		PathIconFactory pathIconFactory = new PathIconFactory();
		PathTreeCell fixture = new PathTreeCell(pathIconFactory);
		String expected = "readme.txt";
		String actual = fixture.displayName(new File(expected).toPath());
		
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell#getIconImage(java.nio.file.Path)}.
	 */
	@Test
	public void testGetIconImage() {
		PathIconFactory pathIconFactory = new PathIconFactory();
		PathTreeCell fixture = new PathTreeCell(pathIconFactory);
		Path path = new File(".").toPath();
		
		assertNotNull(fixture.getIconImage(path));
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell#newTooltip(java.lang.String)}.
	 */
	@Test
	public void testNewTooltip() {
		PathIconFactory pathIconFactory = new PathIconFactory();
		PathTreeCell fixture = new PathTreeCell(pathIconFactory);
		
		assertNotNull(fixture.newTooltip("text"));
	}

	/**
	 * Test method for {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell#updateItem(java.nio.file.Path, boolean)}.
	 */
	@Test
	public void testUpdateItemPathBoolean() {
		PathIconFactory pathIconFactory = new PathIconFactory();
		PathTreeCell fixture = new PathTreeCell(pathIconFactory);
		Path path = new File(".").toPath();
		
		fixture.updateItem(path, true);
		
		assertNull(fixture.getText());
		assertNull(fixture.getGraphic());
		
		fixture.updateItem(path, false);
		
		assertEquals(".", fixture.getText());
		assertNotNull(fixture.getGraphic());
	}

}
