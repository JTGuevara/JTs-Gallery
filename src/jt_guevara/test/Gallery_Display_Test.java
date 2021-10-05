/* FILE: Gallery_Display_Test.java
 * DESCRIPTION: Test class of Gallery_Display.java
 * 
 * FUNCTIONS:
 *   public static void launchFX();
 *      DESCRIPTION: Launches a JavaFX application(calls start() method)
 *      
 *   public void setupGalleryTest();
 *      DESCRIPTION: Test of Gallery_Display.setup_gallery().set_gallery_style(). Verifies that the gallery display is correctly aligned to the center.
 *      
 *   public void setupGalleryTest_2();
 *      DESCRIPTION: Test of Gallery_Display.setup_gallery().set_image_canvas(). Verifies that a canvas is assigned a minimum and maximum width and height.
 *      
 *   public void setupGalleryTest_3();
 *      DESCRIPTION: Test of Gallery_Display.setup_gallery().set_image_view(). Verifies that an image view is added to a canvas.
 *      
 *   public void setupGalelryTest_4();
 *      DESCRIPTION: Test of Gallery_Display.setup_gallery().set_image_view(). Verifies that an image view's fit width and fit height are set.
 *      
 *   public void setupGalelryTest_5();
 *      DESCRIPTION: Test of Gallery_Display.setup_gallery().add_image_canvases(). Verifies that the gallery display has its 3 canvases.
 * 
 */
package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jt_guevara.Gallery_Display;

public class Gallery_Display_Test extends Application{
	
	@Test
	public void setupGalleryTest() {
		Gallery_Display main = new Gallery_Display();
		GridPane display = main.getDisplay();
		main.setup_gallery();//test function
		assertEquals(Pos.CENTER, display.getAlignment());
	}
	
	@Test
	public void setupGalleryTest_2() {
		Gallery_Display main = new Gallery_Display();
		StackPane canvas = main.getLeftCanvas(); //test one of the canvases
		main.setup_gallery();//test function
		assertNotNull(canvas.getMinWidth());
		assertNotNull(canvas.getMinHeight());
		assertNotNull(canvas.getMaxWidth());
		assertNotNull(canvas.getMaxHeight());
	}
	
	@Test
	public void setupGalleryTest_3() {
		Gallery_Display main = new Gallery_Display();
		StackPane canvas = main.getLeftCanvas(); //test an image view by testing one of the canvases
		main.setup_gallery();//test function
		assertNotNull(canvas.getChildren().get(0));
	}
	
	@Test
	public void setupGalleryTest_4() {
		Gallery_Display main = new Gallery_Display();
		StackPane canvas = main.getLeftCanvas(); //test an image view by testing one of the canvases
		main.setup_gallery();//test function
		assertNotNull(((ImageView) canvas.getChildren().get(0)).getFitWidth());
		assertNotNull(((ImageView) canvas.getChildren().get(0)).getFitHeight());
	}
	
	@Test
	public void setupGalleryTest_5() {
		Gallery_Display main = new Gallery_Display();
		GridPane display = main.getDisplay();
		int expectedCanvases = 3;
		main.setup_gallery();//test function
		assertEquals(expectedCanvases, display.getChildren().size());
	}

	@Override
	public void start(Stage window) throws Exception {
		Platform.exit();
	}
	
	@AfterAll
	public static void launchFX() {
		Application.launch();
	}

}
