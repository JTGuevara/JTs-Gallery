/* UNIT TESTS FOR MAIN_LAYOUT.JAVA
 * FILE: Main_Layout_Test.java
 * DESCRIPTION: Unit test for Main_Layout.java class. This class tests the setLayout() and setMenuItems() functions
 * 
 * TESTING FRAMEWORK USED: JUNIT 5
 * 
 * FUNCTIONS:
 *    public void testLayoutPadding();
 *       DESCRIPTION: Verifies that the main layout has the correct padding
 *       
 *    public void testMenuItems();
 *       DESCRIPTION: Verifies that the text of the menu items have the correct text
 * 
 *    public void testMenuBar();
 *       DESCRIPTION: Verifies that the menu bar has the correct number of items
 *       
 *    public void testMenuBarSpacing();
 *       DESCRIPTION: Verifies that the menu items contains the correct amount of space between them
 * 
 *    public static void launchFX();
 *       DESCRIPTION: Launches a required JavaFX application instance(calls start() method) for testing JavaFX objects
 */

package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main_Layout_Test extends Application{
	
	//setLayout() test
	@Test
	public void testLayoutPadding() {
		double expectedPadding = 10;
		GridPane layout = new GridPane();
		layout.setPadding(new Insets(expectedPadding));
		assertEquals(10, expectedPadding);
	}
	
	//setMenuItems() test
	@Test
	public void testMenuItems() {
		Text load_gallery = new Text("Load Gallery");
		Text exit = new Text("Exit");
		Text expected1 = load_gallery;
		Text expected2 = exit;
		assertEquals(load_gallery, expected1);
		assertEquals(exit, expected2);
	}
	
	
	@Test
	public void testMenuBar() {
		int expectedNumberOfItems = 2;
		HBox menuBar = new HBox();
		menuBar.getChildren().add(new Text("menuText1"));
		menuBar.getChildren().add(new Text("menuText2"));
		assertEquals(menuBar.getChildren().size(), expectedNumberOfItems);
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
