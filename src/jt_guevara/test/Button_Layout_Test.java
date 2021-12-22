/* FILE: Button_Layout_Test.java
 * DESCRIPTION: Test class of Button_Layout.java
 * 
 *   (Note: For testing JavaFX buttons, the JavaFX application must be launched before the tests with the @BeforeAll annotation)
 */
package jt_guevara.test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import jt_guevara.Button_Layout;

public class Button_Layout_Test extends Application{
/*
public static void launchFX();
    DESCRIPTION: Launches a JavaFX application(calls start() method)
*/
	@BeforeAll
	public static void launchFX() { //launches JavaFX application (required method to test JavaFX objects)
		Application.launch();
	}
	
/*
public void setScrollButtonsTest();
    DESCRIPTION: Tests Button_Layout.set_scroll_buttons() function. Verifies that the left-scroll and right-scroll buttons exist.
*/
	@Test
	public void setScrollButtonsTest() {
		Button_Layout main = new Button_Layout();
		Button left_scroll = main.getLeftScroll();
		Button right_scroll = main.getRightScroll();
		main.set_scroll_buttons();//test function
		assertNotNull(left_scroll);
		assertNotNull(right_scroll);
	}
	
/*
public void setScrollButtonsTest_2();
    DESCRIPTION: Tests Button_Layout.set_scroll_buttons() function. Verifies that the left-scroll button has the specific scale properties set. 
*/
	@Test
	public void setScrollButtonsTest_2() {
		Button_Layout main = new Button_Layout();
		Button left_scroll = main.getLeftScroll();
		main.set_scroll_buttons();//test function
		assertTrue(left_scroll.getScaleX() >= 1.4);
		assertTrue(left_scroll.getScaleY() >= 1.5);
	}
/*
public void setScrollButtonsTest_3();
    DESCRIPTION: Tests Button_Layout.set_scroll_buttons() function. Verifies that the right-scroll button has the specific scale properties set.
*/
	@Test
	public void setScrollButtonsTest_3() {
		Button_Layout main = new Button_Layout();
		Button right_scroll = main.getRightScroll();
		main.set_scroll_buttons();//test function
		assertTrue(right_scroll.getScaleX() >= 1.4);
		assertTrue(right_scroll.getScaleY() >= 1.5);
	}
/*
public void setZoomButtonTest();
    DESCRIPTION: Tests Button_Layout.set_zoom_button() function. Verifies that the zoom button exists. 
*/
	@Test
	public void setZoomButtonTest() {
		Button_Layout main = new Button_Layout();
		Button zoom = main.getZoom();
		main.set_zoom_button();//test function
		assertNotNull(zoom);
	}
/*
public void setZoomButtonTest_2();
    DESCRIPTION: Tests Button_Layout.set_zoom_button() function. Verifies that the zoom button is scaled to at least double its initial size.	
*/
	@Test
	public void setZoomButtonTest_2() {
		Button_Layout main = new Button_Layout();
		Button zoom = main.getZoom();
		main.set_zoom_button();//test function
		assertTrue(zoom.getScaleX() >= 2);
		assertTrue(zoom.getScaleY() >= 2);
	}
/*
public void setButtonBarTest();
    DESCRIPTION: Tests Button_Layout.set_button_bar() function. Verifies that the button layout is aligned to the center of the application.  
*/
	@Test
	public void setButtonBarTest() {
		Button_Layout main = new Button_Layout();
		GridPane buttonBar = main.getButtonBar();
		main.set_button_bar();//test function
		assertEquals(Pos.CENTER, buttonBar.getAlignment());
	}
/*
public void setButtonBarTest_2();
    DESCRIPTION: Tests Button_Layout.set_button_bar() function. Verifies that the button layout has a base minimum and maximum height. 
*/
	@Test
	public void setButtonBarTest_2() {
		Button_Layout main = new Button_Layout();
		GridPane buttonBar = main.getButtonBar();
		main.set_button_bar();//test function
		assertTrue(buttonBar.getMinHeight() >= 80);
		assertTrue(buttonBar.getMaxHeight() >= 100);
	}
/*
public void addButtonsTest();
    DESCRIPTION: Tests Button_Layout.add_buttons() functions. Verifies that the button bar contains the 3 buttons(left-scroll,right-scroll,zoom). 	
*/
	@Test
	public void addButtonsTest() {
		Button_Layout main = new Button_Layout();
		GridPane buttonBar = main.getButtonBar();
		int expectedAmountOfButtons = 3;
		main.add_buttons();//test function
		assertEquals(expectedAmountOfButtons, buttonBar.getChildren().size());
	}
	
/*
public void start(Stage window);
    DESCRIPTION: Test of Button_Layout class in a program. Generates and displays a JavaFX window with a button layout containing a left-scroll, right-scroll
                 and zoom buttons. Also tests Button_Layout.bind_button_layout(). 
*/
	@Override
	public void start(Stage window) throws Exception {
		GridPane p = new GridPane();
		Scene s = new Scene(p, 800,600);
		Button_Layout main = new Button_Layout();
		main.set_scroll_buttons();
		main.set_zoom_button();
		main.set_button_bar();
		main.add_buttons();
		
		// Button_Layout.bind_button_layout() test (must be tested on FX thread since it requires a JavaFX stage)
		main.bind_button_layout(window); 
		//if button bar is bound to application, pass
		if(main.getButtonBar().prefWidthProperty().isBound() && main.getButtonBar().prefHeightProperty().isBound())
			System.out.println("PASS");
		else
			System.out.println("FAIL");
		
		p.add(main.getButtonBar(), 0, 0);
		window.setScene(s);
		window.show();
	}
}
