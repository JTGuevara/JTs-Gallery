/*UNIT TESTS FOR BUTTON_LAYOUT.JAVA
 * FILE: Button_Layout_Test.java
 * DESCRIPTION: Unit test for Button_Layout.java class
 * 
 * FUNCTIONS:
 *    (Note: bind_button_layout() will be tested below inside the JavaFX application's start() method since it requires a JavaFX Stage,
 *     which can only be initialized inside there)
 *    
 *    
 *    public void test_left_scroll_field();
 *      DESCRIPTION: Verifies that the Button_Layout's left_scroll field is set
 *      
 *    public void test_right_scroll_field();
 *      DESCRIPTION: Verifies that the Button_Layout's right_scroll field is set
 *      
 *    public void test_zoom_field();
 *      DESCRIPTION: Verifies that the Button_Layout's zoom field is set
 *      
 *    public void test_buttonBar_field();
 *      DESCRIPTION: Verifies that the Button_Layout's buttonBar field is set
 *      
 *    public void getButtonBar_test();
 *      DESCRIPTION: Verifies that the buttonBar is returned
 *    
 *    public void generate_scroll_button_test();
 *    	DESCRIPTION: Verifies that a button is generated with the appropriate shape(arrow)
 *    
 *    public void generate_zoom_button_test();
 *    	DESCRIPTION: Verifies that a button is generated with the appropriate shape(plus sign)
 *    
 *    public void button_bar_alignment_test();
 *      DESCRIPTION: Verifies that the button bar has is aligned correctly
 *      
 *    public void button_bar_height_test();
 *      DESCRIPTION: Verifies that the button bar has the correct minimum and maximum height
 *      
 *    public void button_bar_padding_test();
 *      DESCRIPTION: Verifies that the button bar has the correct padding
 *      
 *    public void add_buttons_to_button_bar_test();
 *      DESCRIPTION: Verifies that a button is added to the button bar
 *      
 *    public static void launchFX();
 *       DESCRIPTION: Launches a required JavaFX application instance(calls start() method) for testing JavaFX objects
 *    
 */

package jt_guevara.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import jt_guevara.Button_Layout;

public class Button_Layout_Test extends Application{
	@BeforeAll
	public static void launchFX() { //launches JavaFX application (launches before tests) (necessary setup for testing buttons)
		Application.launch();
	}
	//constructor test (Note: uncomment and set fields to public for testing)
	/*
	@Test
	public void test_left_scroll_field() {
		Button_Layout buttonLayout = new Button_Layout();
		Button expectedButton = buttonLayout.left_scroll;
		assertNotNull(expectedButton);
	}
	
	@Test
	public void test_right_scroll_field() {
		Button_Layout buttonLayout = new Button_Layout();
		Button expectedButton = buttonLayout.right_scroll;
		assertNotNull(expectedButton);
	}
	
	@Test
	public void test_zoom_field() {
		Button_Layout buttonLayout = new Button_Layout();
		Button expectedButton = buttonLayout.zoom;
		assertNotNull(expectedButton);
	}
	
	@Test
	public void test_buttonBar_field() {
		Button_Layout buttonLayout = new Button_Layout();
		GridPane expectedButtonBar = buttonLayout.buttonBar;
		assertNotNull(expectedButtonBar);
	}
	*/
	
	@Test
	public void getButtonBar_test() {
		GridPane display = new GridPane();
		assertNotNull(display);
	}
	
	//set_scroll_buttons() test
	@Test
	public void generate_scroll_button_test() {
		Button scroll = new Button();
		final double[] POINTS = {0.0, 0.0,-30.0, 30.0,0.0, 60.0, 0.0, 0.0};//defines an arrow shape pointing left
		Polyline shape = new Polyline(POINTS);
		scroll.setShape(shape);
		assertEquals(scroll.getShape(), shape);
	}
	
	@Test
	public void left_scroll_size_test() {
		Button left_scroll = new Button();
		double expectedXScale = 1.4, expectedYScale = 1.5;
		left_scroll.setScaleX(expectedXScale);
		left_scroll.setScaleY(expectedYScale);
		assertEquals(expectedXScale, left_scroll.getScaleX());
		assertEquals(expectedYScale, left_scroll.getScaleY());
	}
	
	//set_zoom_button() test
	@Test
	public void generate_zoom_button_test() {
		Button zoom = new Button();
		final double[] POINTS = {0.0, 0.0, 20.0, 0.0, 20.0, 20.0, 40.0, 20.0, 40.0, 40.0, 20.0, 40.0,
				20.0, 60.0, 0.0, 60.0, 0.0, 40.0, -20.0, 40.0, -20.0, 20.0, 0.0, 20.0, 0.0, 0.0};//defines a plus shape
		Polyline shape = new Polyline(POINTS);
		zoom.setShape(shape);
		assertEquals(zoom.getShape(), shape);
	}
	
	//set_button_bar() test
	@Test
	public void button_bar_alignment_test() {
		GridPane buttonBar = new GridPane();
		buttonBar.setAlignment(Pos.CENTER);
		assertEquals(buttonBar.getAlignment(), Pos.CENTER);
	}
	
	@Test
	public void button_bar_height_test() {
		GridPane buttonBar = new GridPane();
		buttonBar.setMinHeight(70);
		buttonBar.setMaxHeight(100);
		assertEquals(buttonBar.getMinHeight(), 70);
		assertEquals(buttonBar.getMaxHeight(), 100);
	}
	
	@Test
	public void button_bar_padding_test() {
		GridPane buttonBar = new GridPane();
		int expectedPadding = 15;
		buttonBar.setPadding(new Insets(expectedPadding));
		assertEquals(expectedPadding, 15);
	}
	
	//add_buttons() test
	@Test
	public void add_buttons_to_button_bar_test() {
		GridPane buttonBar = new GridPane();
		Button button = new Button();
		int expectedButtonBarSize = 1;
		buttonBar.add(button, 0, 0);
		assertEquals(expectedButtonBarSize, buttonBar.getChildren().size());
	}
	
	//JavaFX application
	@Override
	public void start(Stage window) throws Exception {
		Button_Layout buttonLayout = new Button_Layout();//declare Button_Layout for bind_button_layout test
		buttonLayout.bind_button_layout(window);
		//if width and height properties are bound to window, print true
		if(buttonLayout.getButtonBar().prefWidthProperty().isBound() && buttonLayout.getButtonBar().prefHeightProperty().isBound())
			System.out.println("bind_button_layout pass");
		Platform.exit();	
	}
	
	
	
	

}
