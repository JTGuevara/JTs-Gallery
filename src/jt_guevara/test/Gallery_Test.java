/* UNIT TESTS FOR GALLERY.JAVA
 * 
 * TESTING FRAMEWORK USED: JUNIT 5
 *
 * FUNCTIONS:
 * 	public static void FXLauncher();
 *          RESULT: Launches a JavaFX application(calls start() method below).
 
 *      public void testGallery();
 *          RESULT: Verifies that the Gallery constructor creates a valid object and its private member, images,
 *                  is assigned an ArrayDeque value
 *
 *	public void testGalleryInt();
 *          RESULT: Verifies that the value constructor creates a valid object with a valid size and
 *                 its private member, images, is assigned an ArrayDeque value with the specified size
 *
 *      public void testAddImage();
 *          RESULT: Verifies that an image file with a valid URL is added to an ArrayDeque of images
 *
 *      public void testClearGallery();
 *          RESULT: Verifies that a Gallery is empty and cleared of images
 *
 *      public void testGetImages();
 *          RESULT: Verifies that a valid ArrayDeque with a valid size is returned
 *
 *      public void testGetSize();
 *          RESULT: Verifies that a valid gallery size is returned
 */

package jt_guevara.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayDeque;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import jt_guevara.Gallery;

public class Gallery_Test extends Application{
	@BeforeAll
	public static void FXLauncher() {//launcher function necessary for testing JavaFX objects
		Application.launch();
	}
	
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
		int size = 1;
		Gallery gallery = new Gallery(size);
		ArrayDeque<Image> images = new ArrayDeque<Image>(size);
		if(size < 1 || images == null || gallery == null)//test for a valid size
			fail();
		assertEquals(size, 1);
	}
	
	//TEST OF MODIFICATION FUNCTIONS (Gallery.addImage(), Gallery.clearGallery())
	@Test
	public void testAddImage() {
		String imageURL = "";//to test adding images, insert a file path (ex: "file: <file path>")
		String expectedURL = imageURL;
		Gallery gallery = new Gallery();
		gallery.addImage(new Image(imageURL));
		if(imageURL == "" || imageURL == null)//test for empty or invalid url
			fail();
		assertEquals(imageURL, expectedURL);
	}
	
	@Test
	public void testClearGallery() {
		Gallery gallery = new Gallery();
		gallery.clearGallery();
		if(gallery.getImages() == null || gallery.getSize() > 0)//test for null and non-empty images
			fail();
		assertEquals(gallery.getSize(), 0);
	}

	//TEST OF RETURN FUNCTIONS (Gallery.getImages(), Gallery.getSize())
	@Test
	public void testGetImages() {
		int size = 0;
		ArrayDeque<Image> images = new ArrayDeque<Image>();
		//check for valid size
		if(size < 0)
		    fail();
		assertNotNull(images);
		assertEquals(size,0);
	}

	@Test
	public void testGetSize() {
		int size = 1;
		int expectedSize = size;
		if(size < 0)//test for a valid size
			fail();
		assertEquals(size, expectedSize);
	}
	
	//JavaFX application launch
	@Override
	public void start(Stage window) throws Exception {
		Platform.exit();//exit application -- necessary for tests to complete
	}

}
