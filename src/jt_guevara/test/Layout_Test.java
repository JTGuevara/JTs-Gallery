/*FILE: Layout_Test.java
 *DESCRIPTION: Test class of Main_Layout.java. 
 *
 *FUNCTIONS: 
 *   public static void launchFX();
 *      DESCRIPTION: Launches a JavaFX application(calls start() method)
 *      
 *   public void setLayoutTest();
 *      DESCRIPTION: Test of jt_guevara.Main_Layout.setLayout(). Verifies that the application layout is aligned to the center.
 *      
 *   public setMenuItemsTest();
 *      DESCRIPTION: Test of jt_guevara.Main_Layout.set_menu_items(). Verifies that the menu items have a font size of at least 12.4.
 *      
 *   public setMenuItemsTest_2();
 *      DESCRIPTION: Test of jt_guevara.Main_Layout.set_menu_items(). Verifies that the menu bar has at least 2 items.
 *      
 *   public setMenuItemsTest_3();
 *      DESCRIPTION: Test of jt_guevara.Main_Layout.set_menu_items(). Verifies that the menu items are separated by at least 10 pixels from
 *          one another.
 */

package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jt_guevara.Main_Layout;

public class Layout_Test extends Application{
	
	@Test
	public void setLayoutTest() {
		Main_Layout main = new Main_Layout();
		GridPane layout = main.layout;
		main.setLayout(); //test function
		assertEquals(Pos.TOP_CENTER, layout.getAlignment());
	}
	
	@Test
	public void setMenuItemsTest() {
		Main_Layout main = new Main_Layout();
		final double expectedFontSize = 12.399;
		Text gallery = main.getMenuItem1();
		Text settings = main.getMenuItem2();
		Text exit = main.getMenuItem3();
		main.set_menu_items(); //test function
		assertTrue(gallery.getFont().getSize() >= expectedFontSize);
		assertTrue(settings.getFont().getSize() >= expectedFontSize);
		assertTrue(exit.getFont().getSize() >= expectedFontSize);
	}
	
	@Test
	public void setMenuItemsTest_2() {
		Main_Layout main = new Main_Layout();
		HBox menuBar = main.getMenuBar();
		int expectedMenuBarSize = 2;
		main.set_menu_items(); // test function
		assertTrue(menuBar.getChildren().size() >= expectedMenuBarSize);
	}
	
	@Test
	public void setMenuItemsTest_3() {
		Main_Layout main = new Main_Layout();
		HBox menuBar = main.getMenuBar();
		int expectedSpacing = 10;
		main.set_menu_items(); // test function
		assertTrue(expectedSpacing >= menuBar.getSpacing());
	}
	
	@Override
	public void start(Stage window) throws Exception {
		Platform.exit();
	}
	
	@AfterAll
	public static void launchFX() { //launches JavaFX application (required method to test JavaFX objects)
		Application.launch();
	}
	
}
