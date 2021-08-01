/* FILE: UI_Button_Layout.java
 * CLASS DESCRIPTION: Class for generating a button layout. A Button_Layout consists of a button bar and buttons.
 * 
 * FUNCTIONS:  
 *    public Button_Layout(){}
 *       DESCRIPTION: Creates a Button_Layout
 *    
 *    public GridPane getButtonBar();
 *       DESCRIPTION: Returns the button bar
 *       	
 *    public void set_scroll_buttons();
 *       DESCRIPTION: Sets the shape of the left-scroll(<|) and right-scroll(|>) buttons along with their 
 *                    layout and style properties. 
 * 
 * 
 *    public void set_zoom_button();
 *       DESCRIPTION: Sets the shape of the zoom button(+) along with its layout and style properties. 
 *       
 *       
 *    public void set_button_bar();
 *       DESCRIPTION: Sets the button bar's layout and style properties. 
 *    
 *    
 *    public void add_buttons();
 *       DESCRIPTION: Adds the left-scroll, right-scroll and zoom buttons to the button bar
 *       
 *       
 *    public void bind_button_layout(Stage window);
 *       PARAMETER: Stage window - application window used to apply property binding 
 *       DESCRIPTION: This function binds the width and height properties of the button bar to the width and height properties   
 *                    of the application window so that the button bar is automatically resized along with the window when the 
 *                    window changes.
 */
package jt_guevara;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;


public class Button_Layout {
	public Button_Layout() {}//constructor
	private Button left_scroll = new Button();//left-scroll, right-scroll and zoom buttons
	private Button right_scroll = new Button();
	private Button zoom = new Button();
	private GridPane buttonBar = new GridPane();//button bar that contains the above buttons
	
	public GridPane getButtonBar() {return buttonBar;}
	
	public void set_scroll_buttons()
	{
		//local array of doubles used to define a button shape using points(in the form(x,y))(in this case, a triangle (<|))
		final double[] POINTS = {					
				0.0, 0.0,
				-30.0, 30.0,
				0.0, 60.0,
				0.0, 0.0
			    };
		//Polyline object used to set the shape of the zoom button using the points
		Polyline shape = new Polyline(POINTS);
		left_scroll.setShape(shape);
		left_scroll.setScaleX(1.4);
		left_scroll.setScaleY(1.5);
		//do the same for the right-scroll button
		right_scroll.setShape(shape);
		right_scroll.setScaleX(1.4);
		right_scroll.setScaleY(1.5);
		right_scroll.setRotate(180);//rotate button so it points right
	}
	
	public void set_zoom_button()
	{	
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
		Polyline shape = new Polyline(POINTS);	
		zoom.setShape(shape);
		zoom.setScaleX(2);
		zoom.setScaleY(2);
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
