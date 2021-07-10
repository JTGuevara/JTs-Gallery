/* FILE: UI_Button_Layout.java
 * DESCRIPTION: Class for generating image gallery UI control buttons and setting their style, appearance and layout 
 * 
 * FUNCTIONS:
 * 		public static void generate_UI_controls(Stage window, GridPane p);
 * 			PARAMETERS: Stage window		- Window parameter used to generate a UI pane to contain buttons
 * 						GridPane p			- main layout container used to add the UI pane and buttons 
 * 			PREREQUISITE: The private helper functions: generate_scroll_button() and generate_zoom_button() are called first. The generate_scroll_button() is called twice
 * 			RESULT: A user interface bar containing a left-scroll, right-scroll and zoom buttons is added to the main layout(p) and placed on the main window with the left-scroll, 
 * 					zoom and right-scroll button placed in that order
 * 
 * 		
 * 		private static Button generate_scroll_button();
 * 			RESULT: A triangle-shaped Button is returned with its properties set and, by default, pointing to the left
 * 
 * 
 * 		private static Button generate_zoom_button();
 * 			RESULT: A Button in the shape of a plus sign(+) is returned with its properties set
 * 
 * 
 * 		private static GridPane generate_UI_Pane(Stage window);
 * 			PARAMETERS: Stage window		- Window parameter used to bind the UI GridPane
 * 			RESULT: A GridPane container is returned with its properties set. The GridPane's width and height properties are binded to the window.
 * 			
 */
package jt_guevara;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;


public class UI_Button_Layout {
	public static void generate_UI_controls(Stage window, GridPane p) {
		Button left_scroll = generate_scroll_button();
		Button right_scroll = generate_scroll_button();
		Button zoom = generate_zoom_button();
		GridPane UI_Pane = generate_UI_Pane(window);
		right_scroll.setRotate(180);
		UI_Pane.add(left_scroll, 0, 0);
		UI_Pane.add(zoom, 1, 0);
		UI_Pane.add(right_scroll, 2, 0);
		p.add(UI_Pane, 0, 2);
	}
	
	private static Button generate_scroll_button()
	{
		Button scroll = new Button();	
		//local array of doubles used to define a shape using points(in the form(x,y))(in this case, a triangle (<|))
		final double[] POINTS = {					
				0.0, 0.0,
				-30.0, 30.0,
				0.0, 60.0,
				0.0, 0.0
			    };
		//Polyline object used to set the shape of the zoom button using the points
		Polyline icon = new Polyline(POINTS);
		scroll.setShape(icon);
		scroll.setScaleX(1.4);
		scroll.setScaleY(1.5);
		return scroll;
	}
	
	private static Button generate_zoom_button()
	{
		
		Button zoom = new Button();	
		//local array of doubles used to define a shape using points(in the form (x,y))(in this case a (+) sign)	
		final double[] POINTS = {			
			0.0, 0.0,
			20.0, 0.0,
			20.0, 20.0,
			40.0, 20.0,
			40.0, 40.0,
			20.0, 40.0,
			20.0, 60.0,
			0.0, 60.0,
			0.0, 40.0,
			-20.0, 40.0,
			-20.0, 20.0, 
			0.0, 20.0,
			0.0, 0.0
		};
		//Polyline object used to set the shape of the zoom button using the points
		Polyline icon = new Polyline(POINTS);	
		zoom.setShape(icon);
		zoom.setScaleX(2);
		zoom.setScaleY(2);
		return zoom;
	}
	
	private static GridPane generate_UI_Pane(Stage window)
	{
		GridPane UI_Pane = new GridPane();
		UI_Pane.setAlignment(Pos.CENTER);
		UI_Pane.setHgap(20);
		UI_Pane.setStyle("-fx-border-color: lightblue");
		UI_Pane.setMinHeight(50);
		UI_Pane.setMaxHeight(100);
		UI_Pane.setLayoutX(10);
		UI_Pane.setLayoutY(500);
		UI_Pane.setHgap(100);
		UI_Pane.setPadding(new Insets(15,15,15,15));
		UI_Pane.prefWidthProperty().bind(window.widthProperty());
		UI_Pane.prefHeightProperty().bind(window.heightProperty());
		return UI_Pane;
	}
}
