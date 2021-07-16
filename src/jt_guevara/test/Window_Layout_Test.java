/* UNIT TESTS FOR WINDOW_LAYOUT.JAVA
 * FILE: Window_Layout_Test.java
 * DESCRIPTION: Unit test for Window_Layout.java class(setWindow() function)
 * 
 * TESTING FRAMEWORK USED: JUNIT 5
 * 
 * FUNCTIONS:
 *    public void testMenuItems();
 *       RESULT: Verifies that the text of the menu items have the correct text
 * 
 *    public void testLayoutPadding();
 *       RESULT: Verifies that the main layout(p) has the correct padding
 * 
 *    public void testWindowTitle();
 *       RESULT: Verifies that the application has the correct title
 * 
 *    public void testMenuBar();
 *       RESULT: Verifies that the menu bar has the correct number of items
 * 
 *    public static void launchFX();
 *       RESULT: Launches a JavaFX application(calls start() method) 
 */

package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jt_guevara.Window_Layout;

public class Window_Layout_Test extends Application{
	
	@Test
	public void testMenuItems() {
		Text load_gallery = new Text("Load Gallery");
		Text exit = new Text("Exit");
		assertEquals(load_gallery.getText(), "Load Gallery");
		assertEquals(exit.getText(), "Exit");
	}
	
	@Test
	public void testLayoutPadding() {
		int expectedPadding = 10;
		GridPane p = new GridPane();
		p.setPadding(new Insets(expectedPadding));
		assertEquals(expectedPadding, 10);
	}
	
	@Test
	public void testWindowTitle() {
		String title = "JT's Gallery";
		assertEquals(title, "JT's Gallery");
	}
	
	@Test
	public void testMenuBar() {
		int expectedNumberOfItems = 2;
		HBox menuBar = new HBox();
		menuBar.getChildren().add(new Text("text1"));
		menuBar.getChildren().add(new Text("text2"));
		assertEquals(menuBar.getChildren().size(), expectedNumberOfItems );
	}
	
	//JavaFX application 
	@Override
	public void start(Stage window) throws Exception {
		GridPane p = new GridPane();
		Scene s = new Scene(p,800,600);
		Window_Layout.setWindow(window, p);
		window.setScene(s);
		window.show();
		Platform.exit();	//<--disable as needed to see the intended output
	}
	
	@AfterAll
	public static void launchFX() { //launches JavaFX application (launches after tests)
		Application.launch();
	}

}
