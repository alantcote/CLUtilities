package io.github.alantcote.clutilities.javafx.scene.control;

import static org.junit.Assert.*;

import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import org.junit.Test;

import javafx.scene.image.ImageView;

/**
 * Test case for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory}.
 */
public class FileIconFactoryTest {

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#getIcon(java.io.File)}.
	 */
	@Test
	public void testGetIcon() {
		final ImageView imageView = new ImageView();
		final Icon icon = new ImageIcon();
		final File file = new File(".");
		final FileIconFactory fixture = new FileIconFactory() {

			@Override
			protected ImageView getImageView(Icon swingIcon) {
				assertTrue(icon == swingIcon);
				
				return imageView;
			}

			@Override
			protected Icon getSystemIcon(File aFile) {
				assertTrue(file == aFile);
				
				return icon;
			}
			
		};
		
		assertEquals(imageView, fixture.getIcon(file));
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#getIconImage(javax.swing.Icon)}.
	 */
	@Test
	public void testGetIconImage() {
		final FileIconFactory fixture = new FileIconFactory();

		final Icon icon = fixture.getSystemIcon(new File("."));
		assertNotNull(fixture.getIconImage(icon));
	}

	/**
	 * Test method for {@link io.github.alantcote.clutilities.javafx.scene.control.FileIconFactory#getImageView(javax.swing.Icon)}.
	 */
	@Test
	public void testGetImageView() {
		final ImageView imageView = new ImageView();
		final Icon icon = new ImageIcon();
		final FileIconFactory fixture = new FileIconFactory() {

			@Override
			protected ImageView getIconImage(Icon swingIcon) {
				assertTrue(icon == swingIcon);
				
				return imageView;
			}
			
		};
		
		assertTrue(imageView == fixture.getImageView(icon));
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
		final java.awt.Image image = new java.awt.image.BufferedImage(10, 20, java.awt.image.BufferedImage.TYPE_INT_RGB);
		
		assertNotNull(fixture.newBufferedImage(image));
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
