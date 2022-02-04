package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

/**
 * Test case for {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell}.
 */
public class FileTreeCellTest {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#displayName(java.io.File)}.
	 */
	@Test
	public void testDisplayName() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		FileTreeCell fixture = new FileTreeCell(fileIconFactory);
		final String displayName = "mock.txt";
		final File realFile = new File(displayName);

		assertEquals(displayName, fixture.displayName(realFile));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#FileTreeCell(io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory)}.
	 */
	@Test
	public void testFileTreeCell() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		FileTreeCell fixture = new FileTreeCell(fileIconFactory);

		assertNotNull(fixture);
		assertEquals(fileIconFactory, fixture.fileIconFactory);
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#getIconImage(java.io.File)}.
	 */
	@Test
	public void testGetIconImage() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		FileTreeCell fixture = new FileTreeCell(fileIconFactory);
		final String displayName = ".";
		final File realFile = new File(displayName);

		assertNotNull(fixture.getIconImage(realFile));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#newTooltip(java.lang.String)}.
	 */
	@Test
	public void testNewTooltip() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		FileTreeCell fixture = new FileTreeCell(fileIconFactory);
		final String displayName = "mock.txt";

		assertNotNull(fixture.newTooltip(displayName));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#updateItem(java.io.File, boolean)}.
	 */
	@Test
	public void testUpdateItemFileBoolean() {
		final FileIconFactory fileIconFactory = new FileIconFactory();
		final String displayName = "mock.txt";
		final File realFile = new File(displayName);
		final ImageView imageView = new ImageView();
		final Tooltip tooltip = new Tooltip();
		FileTreeCell fixture = new FileTreeCell(fileIconFactory) {

			@Override
			protected String displayName(File item) {
				return displayName;
			}

			@Override
			protected ImageView getIconImage(File item) {
				return imageView;
			}

			@Override
			protected Tooltip newTooltip(String presText) {
				return tooltip;
			}

		};

		fixture.updateItem(realFile, false);

		assertEquals(displayName, fixture.getText());
		assertEquals(imageView, fixture.getGraphic());
		assertEquals(tooltip, fixture.getTooltip());
	}

}
