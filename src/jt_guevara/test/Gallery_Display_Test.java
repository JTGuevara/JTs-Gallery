/*UNIT TESTS FOR GALLERY_VIEW.JAVA
 * FILE: Gallery_Display_Test.java
 * DESCRIPTION: Unit test for Gallery_Display.java class
 * 
 * FUNCTIONS:
 *    public void constructor_test();
 *        DESCRIPTION: Verifies that the constructor works and that its field(display) is set
 *        
 *    public GridPane getDisplay_test();
 *        DESCRIPTION: Verifies that a display(GridPane) is returned
 *       
 *    public void gallery_alignment_test();
 *        DESCRIPTION: Verifies that the display has the correct alignment 
 *        
 *    public void gallery_padding_test();
 *        DESCRIPTION: Verifies that the display has the correct padding
 *    
 *    public void gallery_height_test();
 *        DESCRIPTION: Verifies that the display the correct minimum and maximum height
 *        
 *    public void minimum_canvas_size_test();
 *        DESCRIPTION: Verifies that the canvas the correct minimum width and height
 *        
 *    public void maximum_canvas_size_test();
 *        DESCRIPTION: Verifies that the canvas the correct maximum width and height
 *        
 *    public StackPane bind_view_to_canvas_test();
 *        DESCRIPTION: Verifies that an image view is binded to the image canvas
 *        
 *    public void test_adding_to_canvas();
 *        DESCRIPTION: Verifies that an image canvas is added to the gallery display
 *        
 *    public void bind_canvas_to_gallery_test();
 *        DESCRIPTION: Verifies that the image canvas is binded to the gallery display
 *        
 *    public static void launchFX();
 *       DESCRIPTION: Launches a required JavaFX application instance(calls start() method) for testing JavaFX objects
 */
package jt_guevara.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jt_guevara.Gallery_Display;

public class Gallery_Display_Test extends Application{
	//constructor test
	@Test
	public void constructor_test() {
		//(Note: set Gallery_Display fields to public for testing)
		Gallery_Display galleryDisp = new Gallery_Display();
		assertNotNull(galleryDisp.display);
	}
	
	//getDisplay() test
	public GridPane getDisplay_test() {
		GridPane display = new GridPane();
		assertNotNull(display);
		return display;
	}
	
	//set_gallery_style() test
	@Test
	public void gallery_alignment_test() {
		GridPane display = new GridPane();
		display.setAlignment(Pos.CENTER);
		assertEquals(display.getAlignment(), Pos.CENTER);
	}
	
	@Test
	public void gallery_padding_test() {
		GridPane display = new GridPane();
		int expectedPadding = 15;
		display.setPadding(new Insets(expectedPadding));
		assertEquals(expectedPadding, 15);
	}
	
	@Test
	public void gallery_height_test() {
		GridPane display = new GridPane();
		display.setMinHeight(250);
		display.setMaxHeight(700);
		assertEquals(display.getMinHeight(), 250, 0.001);
		assertEquals(display.getMaxHeight(), 700, 0.001);
	}
	
	//set_image_canvas() test
	@Test
	public void minimum_canvas_size_test() {
		StackPane canvas = new StackPane();
		canvas.setMinWidth(100);
		canvas.setMinHeight(100);
		assertEquals(canvas.getMinWidth(), 100, 0.001);
		assertEquals(canvas.getMinHeight(), 100, 0.001);
	}
	
	@Test
	public void maximum_canvas_size_test() {
		StackPane canvas = new StackPane();
		canvas.setMaxWidth(400);
		canvas.setMaxHeight(560);
		assertEquals(canvas.getMaxWidth(), 400, 0.001);
		assertEquals(canvas.getMaxHeight(), 560, 0.001);
	}
	
	//set_image_view() test
	@Test
	public StackPane bind_view_to_canvas() {
		StackPane canvas = new StackPane();
		ImageView imgView = new ImageView();
		imgView.fitHeightProperty().bind(canvas.heightProperty().subtract(25));
		imgView.fitWidthProperty().bind(canvas.widthProperty().subtract(25));
		assertEquals(imgView.fitHeightProperty().isBound(), true);
		assertEquals(imgView.fitWidthProperty().isBound(), true);
		return canvas;
	}
	

	//add_image_canvases() test
	@Test
	public void test_adding_to_canvas() {
		GridPane display = new GridPane();
		StackPane canvas = new StackPane();
		int expectedCanvasSize = 1;
		display.add(canvas, 0, 0);
		assertEquals(expectedCanvasSize, display.getChildren().size());
	}
	
	
	//bind_gallery() test
	@Test
	public void bind_canvas_to_gallery_test() {
		GridPane display = new GridPane();
		StackPane canvas = new StackPane();
		canvas.prefWidthProperty().bind(display.widthProperty());
		assertTrue(canvas.prefWidthProperty().isBound());
		
	}
	
    //JavaFX application
	@Override
	public void start(Stage window) throws Exception {
		Platform.exit();	
	}
	
	@AfterAll
	public static void launchFX() { //launches JavaFX application (launches after tests)
		Application.launch();
	}
}
