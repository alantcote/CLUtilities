package io.github.alantcote.fxutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Path;

import org.junit.Test;

import io.github.alantcote.fxutilities.javafx.scene.control.PathTreeItem;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

/**
 * Test case for
 * {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeItem}.
 */
public class PathTreeItemTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeItem#getChildren()}.
	 */
	@Test
	public void testGetChildren() {
		Path path = new File("about.txt").toPath();
		PathTreeItem fixture = new PathTreeItem(path);
		ObservableList<TreeItem<Path>> kids = fixture.getChildren();

		assertNotNull(kids);
		assertTrue(0 == kids.size());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeItem#isLeaf()}.
	 */
	@Test
	public void testIsLeaf() {
		Path path = new File("about.txt").toPath();
		PathTreeItem fixture = new PathTreeItem(path) {

			@Override
			public ObservableList<TreeItem<Path>> getChildren() {
				return childItems;
			}

		};

		assertTrue(fixture.isLeaf());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeItem#newPathTreeItem(java.nio.file.Path)}.
	 */
	@Test
	public void testNewPathTreeItem() {
		Path path = new File("about.txt").toPath();
		PathTreeItem fixture = new PathTreeItem(path);
		PathTreeItem result = fixture.newPathTreeItem(path);

		assertNotNull(result);
		assertEquals(path, result.getValue());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.scene.control.PathTreeItem#PathTreeItem(java.nio.file.Path)}.
	 */
	@Test
	public void testPathTreeItem() {
		Path path = new File("about.txt").toPath();
		PathTreeItem fixture = new PathTreeItem(path);

		assertNotNull(fixture);
		assertNotNull(fixture.childItems);
	}

}
