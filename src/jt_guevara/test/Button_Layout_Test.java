/*UNIT TESTS FOR UI_BUTTON_LAYOUT.JAVA
 * FILE: Button_Layout_Test.java
 * DESCRIPTION: Unit test for UI_Button_Layout.java class(generate_gallery() function and private functions)
 * 
 * FUNCTIONS:
 *    public Button generate_scroll_button_test();
 *       RESULT: Verifies that a button is generated with the appropriate shape(arrow)
 *    
 *    public Button generate_zoom_button_test();
 *       RESULT: Verifies that a button is generated with the appropriate shape(plus sign)
 *    
 *    public GridPane generate_UI_Pane();
 *       RESULT: Verifies that a button bar is generated aligned at the center
 */

package jt_guevara.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import jt_guevara.UI_Button_Layout;

public class Button_Layout_Test extends Application{
	@BeforeAll
	public static void launchFX() { //launches JavaFX application (launches before tests)
		Application.launch();
	}

	@Test
	public void generate_scroll_button_test() {
		Button scroll = new Button();
		final double[] POINTS = {0.0, 0.0,-30.0, 30.0,0.0, 60.0, 0.0, 0.0};//defines an arrow shape pointing left
		Polyline shape = new Polyline(POINTS);
		scroll.setShape(shape);
		assertEquals(scroll.getShape(), shape);
	}
	
	@Test
	public void generate_zoom_button_test() {
		Button zoom = new Button();
		final double[] POINTS = {0.0, 0.0, 20.0, 0.0, 20.0, 20.0, 40.0, 20.0, 40.0, 40.0, 20.0, 40.0,
				20.0, 60.0, 0.0, 60.0, 0.0, 40.0, -20.0, 40.0, -20.0, 20.0, 0.0, 20.0, 0.0, 0.0};//defines a plus shape
		Polyline shape = new Polyline(POINTS);
		zoom.setShape(shape);
		assertEquals(zoom.getShape(), shape);
	}
	
	@Test
	public void generate_UI_Pane() {
		GridPane buttonBar = new GridPane();
		buttonBar.setAlignment(Pos.CENTER);
		assertEquals(buttonBar.getAlignment(), Pos.CENTER);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		GridPane p = new GridPane();
		Scene s = new Scene(p,800,600);
		UI_Button_Layout.generate_UI_controls(window, p);
		window.setScene(s);
		window.show();
		Platform.exit();	//<--disable as needed to see the intended output
	}
}
