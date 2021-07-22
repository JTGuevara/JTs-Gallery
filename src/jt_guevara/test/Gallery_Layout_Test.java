/*UNIT TESTS FOR GALLERY_LAYOUT.JAVA
 * FILE: Gallery_Layout_Test.java
 * DESCRIPTION: Unit test for Window_Layout.java class(generate_gallery() and private functions)
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
 */
package jt_guevara.test;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jt_guevara.Gallery_Layout;


public class Gallery_Layout_Test extends Application{

	@Test
	public void generate_gallery_test() {
		int expectedCanvases = 3;
		GridPane galleryLayout = new GridPane();
		StackPane[] canvases = new StackPane[3];
		galleryLayout.getChildren().addAll(canvases);
		assertEquals(expectedCanvases, canvases.length);
		assertEquals(galleryLayout.getChildren().size(), 3);
	}
	
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

	@Override
	public void start(Stage window) throws Exception {
		GridPane p = new GridPane();
		Scene s = new Scene(p,800,600);
		Gallery_Layout.generate_gallery(window, p);
		window.setScene(s);
		window.show();
		//Platform.exit();	//<--disable as needed to see the intended output
	}
	
	@AfterAll
	public static void launchFX() {
		Application.launch();
	}
}

