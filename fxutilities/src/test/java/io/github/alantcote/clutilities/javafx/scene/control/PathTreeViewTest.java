package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import org.junit.Test;

import io.github.alantcote.clutilities.javafx.util.callback.PathTreeCellFactory;

/**
 * Test case for {@link io.github.alantcote.clutilities.javafx.scene.control.PathTreeView}.
 */
public class PathTreeViewTest {

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.PathTreeView#PathTreeView(javafx.scene.control.TreeItem)}.
	 */
	@Test
	public void testPathTreeView() {
		PathTreeItem pathTreeItem = new PathTreeItem(null);
		PathTreeView fixture = new PathTreeView(pathTreeItem);
		
		assertNotNull(fixture);
		assertTrue(fixture.getCellFactory() instanceof PathTreeCellFactory);
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.PathTreeView#newPathIconFactory()}.
	 */
	@Test
	public void testNewPathIconFactory() {
		PathTreeItem pathTreeItem = new PathTreeItem(null);
		PathTreeView fixture = new PathTreeView(pathTreeItem);
		
		assertNotNull(fixture.newPathIconFactory());
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.PathTreeView#newPathTreeCellFactory(io.github.alantcote.clutilities.javafx.scene.control.PathIconFactory)}.
	 */
	@Test
	public void testNewPathTreeCellFactory() {
		PathTreeItem pathTreeItem = new PathTreeItem(null);
		PathTreeView fixture = new PathTreeView(pathTreeItem);
		
		assertNotNull(fixture.newPathTreeCellFactory(fixture.newPathIconFactory()));
	}

}
