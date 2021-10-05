/* FILE: Button_Layout_Test.java
 * DESCRIPTION: Test class of Button_Layout.java
 * 
 * FUNCTIONS:
 *   public static void launchFX();
 *      DESCRIPTION: Launches a JavaFX application(calls start() method)
 *      
 *   public void setScrollButtonsTest();
 *      DESCRIPTION: Tests Button_Layout.set_scroll_buttons() function. Verifies that the left-scroll and right-scroll buttons exist.
 *      
 *   public void setScrollButtonsTest_2();
 *      DESCRIPTION: Tests Button_Layout.set_scroll_buttons() function. Verifies that the left-scroll button has the specific scale properties set.
 *      
 *   public void setScrollButtonsTest_3();
 *      DESCRIPTION: Tests Button_Layout.set_scroll_buttons() function. Verifies that the right-scroll button has the specific scale properties set.
 *      
 *   public void setZoomButtonTest();
 *      DESCRIPTION: Tests Button_Layout.set_zoom_button() function. Verifies that the zoom button exists.
 *      
 *   public void setZoomButtonTest();
 *      DESCRIPTION: Tests Button_Layout.set_zoom_button() function. Verifies that the zoom button has the specific scale properties set.
 *      
 *   public void setButtonBarTest();
 *      DESCRIPTION: Tests Button_Layout.set_button_bar() function. Verifies that the button layout is aligned to the center.
 *   
 *   public void setButtonBarTest_2();
 *      DESCRIPTION: Tests Button_Layout.set_button_bar() function. Verifies that the button layout has a base minimum and maximum height.
 *      
 *   public void addButtonsTest();
 *      DESCRIPTION: Tests Button_Layout.add_buttons() functions. Verifies that the button bar contains the 3 buttons(left-scroll,right-scroll,zoom).
 *      
 *   
 * 
 *   (Note: For testing JavaFX buttons, the JavaFX application must be launched before the tests with the @BeforeAll annotation)
 */
package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jt_guevara.Button_Layout;

public class Button_Layout_Test extends Application{
	@BeforeAll
	public static void launchFX() { //launches JavaFX application (required method to test JavaFX objects)
		Application.launch();
	}
	
	@Test
	public void setScrollButtonsTest() {
		Button_Layout main = new Button_Layout();
		Button left_scroll = main.getLeftScroll();
		Button right_scroll = main.getRightScroll();
		main.set_scroll_buttons();//test function
		assertNotNull(left_scroll);
		assertNotNull(right_scroll);
	}
	
	@Test
	public void setScrollButtonsTest_2() {
		Button_Layout main = new Button_Layout();
		Button left_scroll = main.getLeftScroll();
		main.set_scroll_buttons();//test function
		assertTrue(left_scroll.getScaleX() >= 1.4);
		assertTrue(left_scroll.getScaleY() >= 1.5);
	}
	
	@Test
	public void setScrollButtonsTest_3() {
		Button_Layout main = new Button_Layout();
		Button right_scroll = main.getRightScroll();
		main.set_scroll_buttons();//test function
		assertTrue(right_scroll.getScaleX() >= 1.4);
		assertTrue(right_scroll.getScaleY() >= 1.5);
	}
	
	@Test
	public void setZoomButtonTest() {
		Button_Layout main = new Button_Layout();
		Button zoom = main.getZoom();
		main.set_zoom_button();//test function
		assertNotNull(zoom);
	}
	
	@Test
	public void setZoomButtonTest_2() {
		Button_Layout main = new Button_Layout();
		Button zoom = main.getZoom();
		main.set_zoom_button();//test function
		assertTrue(zoom.getScaleX() >= 2);
		assertTrue(zoom.getScaleY() >= 2);
	}
	
	@Test
	public void setButtonBarTest() {
		Button_Layout main = new Button_Layout();
		GridPane buttonBar = main.getButtonBar();
		main.set_button_bar();//test function
		assertEquals(Pos.CENTER, buttonBar.getAlignment());
	}
	
	@Test
	public void setButtonBarTest_2() {
		Button_Layout main = new Button_Layout();
		GridPane buttonBar = main.getButtonBar();
		main.set_button_bar();//test function
		assertTrue(buttonBar.getMinHeight() >= 80);
		assertTrue(buttonBar.getMaxHeight() >= 100);
	}
	
	@Test
	public void addButtonsTest() {
		Button_Layout main = new Button_Layout();
		GridPane buttonBar = main.getButtonBar();
		int expectedAmountOfButtons = 3;
		main.add_buttons();//test function
		assertEquals(expectedAmountOfButtons, buttonBar.getChildren().size());
	}
	
	
	@Override
	public void start(Stage window) throws Exception {
		Button_Layout main = new Button_Layout();
		main.bind_button_layout(window); // Button_Layout.bind_button_layout() test (must be tested on FX thread)
		
		//if button bar is bound to application, pass
		if(main.getButtonBar().prefWidthProperty().isBound() && main.getButtonBar().prefHeightProperty().isBound())
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		Platform.exit();
	}
}
