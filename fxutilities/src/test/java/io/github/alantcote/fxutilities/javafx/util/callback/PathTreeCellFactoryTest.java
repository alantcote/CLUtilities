package io.github.alantcote.fxutilities.javafx.util.callback;

import static org.junit.Assert.*;

import java.nio.file.Path;

import org.junit.Test;

import io.github.alantcote.fxutilities.javafx.scene.control.PathIconFactory;
import io.github.alantcote.fxutilities.javafx.scene.control.PathTreeCell;
import io.github.alantcote.fxutilities.javafx.util.callback.PathTreeCellFactory;
import javafx.scene.control.TreeView;

/**
 * Test case for
 * {@link io.github.alantcote.fxutilities.javafx.util.callback.PathTreeCellFactory}.
 */
public class PathTreeCellFactoryTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.util.callback.PathTreeCellFactory#call(javafx.scene.control.TreeView)}.
	 */
	@Test
	public void testCall() {
		final PathIconFactory pathIconFactory = new PathIconFactory();
		final TreeView<Path> treeView = new TreeView<Path>();
		final PathTreeCell pathTreeCell = new PathTreeCell(pathIconFactory);
		PathTreeCellFactory fixture = new PathTreeCellFactory(pathIconFactory) {

			@Override
			protected PathTreeCell newPathTreeCell() {
				return pathTreeCell;
			}

		};

		assertEquals(pathTreeCell, fixture.call(treeView));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.util.callback.PathTreeCellFactory#newPathTreeCell()}.
	 */
	@Test
	public void testNewPathTreeCell() {
		final PathIconFactory pathIconFactory = new PathIconFactory();
		PathTreeCellFactory fixture = new PathTreeCellFactory(pathIconFactory);

		assertNotNull(fixture.newPathTreeCell());
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.fxutilities.javafx.util.callback.PathTreeCellFactory#PathTreeCellFactory(io.github.alantcote.fxutilities.javafx.scene.control.PathIconFactory)}.
	 */
	@Test
	public void testPathTreeCellFactory() {
		final PathIconFactory pathIconFactory = new PathIconFactory();
		PathTreeCellFactory fixture = new PathTreeCellFactory(pathIconFactory);

		assertNotNull(fixture);

		assertEquals(pathIconFactory, fixture.pathIconFactory);
	}

}
