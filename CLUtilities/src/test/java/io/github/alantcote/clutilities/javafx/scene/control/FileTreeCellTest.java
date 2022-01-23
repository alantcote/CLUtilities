package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;

import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import io.github.alantcote.clutilities.demo.TestCaseWithJMockAndByteBuddy;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;

/**
 * Test case for {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell}.
 */
@RunWith(JfxRunner.class)
public class FileTreeCellTest extends TestCaseWithJMockAndByteBuddy {

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#displayName(java.io.File)}.
	 */
	@Test
	public void testDisplayName() {
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		FileTreeCell fixture = new FileTreeCell(mockFileIconFactory);
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
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		FileTreeCell fixture = new FileTreeCell(mockFileIconFactory);

		assertNotNull(fixture);
		assertEquals(mockFileIconFactory, fixture.fileIconFactory);
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#getIconImage(java.io.File)}.
	 */
	@Test
	public void testGetIconImage() {
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		FileTreeCell fixture = new FileTreeCell(mockFileIconFactory);
		final String displayName = "mock.txt";
		final File realFile = new File(displayName);
		final ImageView mockImageView = context.mock(ImageView.class, "mockImageView");

		context.checking(new Expectations() {
			{
				oneOf(mockFileIconFactory).getIcon(realFile);
				will(returnValue(mockImageView));
			}
		});

		assertNotNull(fixture.getIconImage(realFile));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#newTooltip(java.lang.String)}.
	 */
	@Test
	public void testNewTooltip() {
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		FileTreeCell fixture = new FileTreeCell(mockFileIconFactory);
		final String displayName = "mock.txt";

		assertNotNull(fixture.newTooltip(displayName));
	}

	/**
	 * Test method for
	 * {@link io.github.alantcote.clutilities.javafx.scene.control.FileTreeCell#updateItem(java.io.File, boolean)}.
	 */
	@Test
	public void testUpdateItemFileBoolean() {
		final FileIconFactory mockFileIconFactory = context.mock(FileIconFactory.class, "mockFileIconFactory");
		final String displayName = "mock.txt";
		final File realFile = new File(displayName);
		final ImageView mockImageView = context.mock(ImageView.class, "mockImageView");
		final Tooltip mockTooltip = context.mock(Tooltip.class, "mockTooltip");
		FileTreeCell fixture = new FileTreeCell(mockFileIconFactory) {

			@Override
			protected String displayName(File item) {
				return displayName;
			}

			@Override
			protected ImageView getIconImage(File item) {
				return mockImageView;
			}

			@Override
			protected Tooltip newTooltip(String presText) {
				return mockTooltip;
			}

		};

		fixture.updateItem(realFile, false);

		assertEquals(displayName, fixture.getText());
		assertEquals(mockImageView, fixture.getGraphic());
		assertEquals(mockTooltip, fixture.getTooltip());
	}

}
