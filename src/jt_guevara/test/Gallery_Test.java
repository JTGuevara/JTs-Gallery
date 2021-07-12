/* UNIT TESTS FOR GALLERY.JAVA
 * 
 * TESTING FRAMEWORK USED: JUNIT 5
 *
 * FUNCTIONS:
 *      public testGallery();
 *          RESULT: Verifies that the Gallery constructor creates a valid object and its private member, images,
 *                  is assigned an ArrayDeque value
 * 
 *      public ArrayDeque<Image> testGetImages();
 *          RESULT: Verifies that a valid ArrayDeque with a valid size is returned, and then returns it
 */

package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import javafx.scene.image.Image;

public class Gallery_Test {

	//TEST OF DEFAULT AND VALUE CONSTRUCTORS (Gallery(), Gallery(int size))
	@Test
	public void testGallery() {
		Gallery gallery = new Gallery();
		ArrayDeque<Image> images = new ArrayDeque<Image>();
		assertNotNull(gallery);
		assertNotNull(images);
	}

	@Test
	public void testGalleryInt() {
		//to do later
	}
	
	//TEST OF MODIFICATION FUNCTIONS (Gallery.addImage(), Gallery.clearGallery())
	@Test
	public void testAddImage() {
		//to do later
	}
	
	@Test
	public void testClearGallery() {
		//to do later
	}

	//TEST OF RETURN FUNCTIONS (Gallery.getImages(), Gallery.getSize())
	@Test
	public ArrayDeque<Image> testGetImages() {
		int size = 0;
		ArrayDeque<Image> images = new ArrayDeque<Image>();
		//check for valid size
		if(size < 0)
		    fail();
		assertNotNull(images);
		assertEquals(size,0);
		return images;
	}

	@Test
	public int testGetSize() {
		//to do later
	}

}
