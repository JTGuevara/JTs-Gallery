/* FILE: Gallery_Test.java
 * DESCRIPTION: Test class of Gallery.java
 * 
 * FUNCTIONS:
 *    public void testConstructor();
 *       DESCRIPTION: Tests Gallery class default constructor. Verifies that its member field 'images' is set.
 *       
 *    public void testValueConstructor();
 *       DESCRIPTION: Tests Gallery class value constructor. Verifies that its member field 'images' is set with the expected size.
 * 
 */

package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayDeque;

import org.junit.jupiter.api.Test;
import javafx.scene.image.Image;
import jt_guevara.Gallery;

public class Gallery_Test{

	@Test
	void testConstructor() {
		Gallery imageGallery = new Gallery();
		ArrayDeque<Image> images = imageGallery.getImages();
		assertNotNull(images);
	}
	
	@Test
	void testValueConstructor() {
		int expectedSize = 10;
		Gallery imageGallery = new Gallery(expectedSize);
		ArrayDeque<Image> images = imageGallery.getImages();
		assertNotNull(images);
		assertEquals(expectedSize,imageGallery.getImages().size());
	}

}
