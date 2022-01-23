package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.jmock.Expectations;
import org.junit.Test;
import org.junit.runner.RunWith;

import de.saxsys.mvvmfx.testingutils.jfxrunner.JfxRunner;
import io.github.alantcote.clutilities.jmock.TestCaseWithJMock;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

/**
 * Test case for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory}.
 */
@RunWith(JfxRunner.class)
public class FileIconFactoryTest extends TestCaseWithJMock {

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#getIcon(java.io.File)}.
	 */
	@Test
	public void testGetIcon() {
		final ImageView mockImageView = context.mock(ImageView.class, "mockImageView");
		final Icon mockIcon = context.mock(Icon.class, "mockIcon");
		final File realFile = new File(".");
		final FileIconFactory fixture = new FileIconFactory() {

			@Override
			protected ImageView getImageView(Icon swingIcon) {
				return mockImageView;
			}

			@Override
			protected Icon getSystemIcon(File aFile) {
				return mockIcon;
			}
			
		};
		
		assertEquals(mockImageView, fixture.getIcon(realFile));
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#getIconImage(javax.swing.Icon)}.
	 */
	@Test
	public void testGetIconImage() {
		final ImageIcon mockImageIcon = context.mock(ImageIcon.class, "mockImageIcon");
		final BufferedImage mockBufferedImage = context.mock(BufferedImage.class, "mockBufferedImage");
		final Image mockImage = context.mock(Image.class, "mockImage");
		final ImageView mockImageView = context.mock(ImageView.class, "mockImageView");
		final FileIconFactory fixture = new FileIconFactory() {

			@Override
			protected ImageView newImageView(Image fxImage) {
				return mockImageView;
			}

			@Override
			protected Image swingFXUtilsToFXImage(BufferedImage bImg, WritableImage wimg) {
				return mockImage;
			}
			
		};

		context.checking(new Expectations() {
			{
				oneOf(mockImageIcon).getImage();
				will(returnValue(mockBufferedImage));
			}
		});

		assertEquals(mockImageView, fixture.getIconImage(mockImageIcon));
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#getImageView(javax.swing.Icon)}.
	 */
	@Test
	public void testGetImageView() {
		final ImageView mockImageView = context.mock(ImageView.class, "mockImageView");
		final Icon mockIcon = context.mock(Icon.class, "mockIcon");
		final FileIconFactory fixture = new FileIconFactory() {

			@Override
			protected ImageView getIconImage(Icon swingIcon) {
				return mockImageView;
			}
			
		};
		
		assertEquals(mockImageView, fixture.getImageView(mockIcon));
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#getSystemIcon(java.io.File)}.
	 */
	@Test
	public void testGetSystemIcon() {
		final FileIconFactory fixture = new FileIconFactory();
		final File realFile = new File(".");
		
		assertNotNull(fixture.getSystemIcon(realFile));
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#newBufferedImage(java.awt.Image)}.
	 */
	@Test
	public void testNewBufferedImage() {
		final FileIconFactory fixture = new FileIconFactory();
		final BufferedImage mockBufferedImage = context.mock(BufferedImage.class, "mockBufferedImage");

		context.checking(new Expectations() {
			{
				oneOf(mockBufferedImage).getWidth(null);
				will(returnValue(15));

				oneOf(mockBufferedImage).getHeight(null);
				will(returnValue(15));
			}
		});
		
		assertNotNull(fixture.newBufferedImage(mockBufferedImage));
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#newHashtable()}.
	 */
	@Test
	public void testNewHashtable() {
		final FileIconFactory fixture = new FileIconFactory();
		
		assertNotNull(fixture.newHashtable());
	}

}
