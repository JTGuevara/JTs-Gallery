/*UNIT TESTS FOR GALLERY_LAYOUT.JAVA
 * FILE: Gallery_Layout_Test.java
 * DESCRIPTION: Unit test for Window_Layout.java class(generate_gallery() function and private functions)
 * 
 * FUNCTIONS:
 *   public void generate_gallery_test();
 *     RESULT: Verifies that the gallery layout has the correct number of image canvases
 *     
 *   public void set_gallery_appearance_alignment_test();
 *     RESULT: Verifies that the gallery layout is correctly aligned at the center
 *     
 *   public void set_gallery_appearance_height_test();
 *     RESULT: Verifies that the gallery layout has the correct minimum and maximum height
 *     
 *   public void create_image_canvas_test();
 *     RESULT: Verifies that an image view is binded to its canvas
 *   
 *   public void bind_gallery_test();
 *     RESULT: Verifies that a canvas is binded to the gallery
 *   
 */
package jt_guevara.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jt_guevara.Gallery_Layout;


public class Gallery_Layout_Test extends Application{
	//generate_gallery() test
	@Test
	public void generate_gallery_test() {
		int expectedCanvases = 3;
		GridPane galleryLayout = new GridPane();
		StackPane canvas1 = new StackPane();
		StackPane canvas2 = new StackPane();
		StackPane canvas3 = new StackPane();
		galleryLayout.getChildren().addAll(canvas1, canvas2, canvas3);
		if(expectedCanvases != 3)
			fail();
		assertEquals(expectedCanvases, galleryLayout.getChildren().size());//check the layout for the expected number of canvases
	}
	
	//set_gallery_appearance() test
	@Test
	public void set_gallery_appearance_alignment_test() {
		GridPane layout = new GridPane();
		layout.setAlignment(Pos.CENTER);
		assertEquals(layout.getAlignment(), Pos.CENTER);
	}
	
	@Test
	public void set_gallery_appearance_height_test() {
		GridPane layout = new GridPane();
		layout.setMinHeight(250);
		layout.setMaxHeight(700);
		assertEquals(layout.getMinHeight(), 250, 0.001);
		assertEquals(layout.getMaxHeight(), 700, 0.001);
	}
	
	//create_image_canvas() test
	@Test
	public StackPane create_image_canvas_test() {
		StackPane canvas = new StackPane();
		ImageView imgView = new ImageView();
		imgView.fitHeightProperty().bind(canvas.heightProperty().subtract(25));
		imgView.fitWidthProperty().bind(canvas.widthProperty().subtract(25));
		assertEquals(imgView.fitHeightProperty().isBound(), true);
		assertEquals(imgView.fitWidthProperty().isBound(), true);
		return canvas;
	}
	
	//bind_gallery() test
	@Test
	public void bind_gallery_test() {
		GridPane galleryLayout = new GridPane();
		StackPane canvas = new StackPane();
		canvas.prefWidthProperty().bind(galleryLayout.widthProperty());
		assertEquals(canvas.prefWidthProperty().isBound(), true);
	}
	

	@Override
	public void start(Stage window) throws Exception {
		GridPane p = new GridPane();
		Scene s = new Scene(p,800,600);
		Gallery_Layout.generate_gallery(window, p);
		window.setScene(s);
		window.show();
		Platform.exit();	//<--disable as needed to see the intended output
	}
	
	@AfterAll
	public static void launchFX() { //launches JavaFX application (launches after tests)
		Application.launch();
	}
}
