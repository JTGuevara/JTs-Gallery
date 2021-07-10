/* FILE: Window_Layout.java
 * DESCRIPTION: Class used to set the style and layout of the application window and menu items	
 * 
 * FUNCTIONS: 
 *   public class void setWindow(Stage,GridPane);
 *      PARAMETERS: Stage window - window parameter for setting window properties
 *                  GridPane p - main layout container used to insert menu items, set menu item properties and set layout properties(style, padding)
 * 
 *      RESULT: The main application window's properties are set. Two menu items are created, their properties set and layed out on the window's 
 *              top-left corner.
 * 				
 */
package jt_guevara;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Window_Layout {
	public static void setWindow(Stage window, GridPane p)
	{
		//Declare menu items to be used as clickable text for the user
		Text load_gallery = new Text("Load Gallery    ");
		Text exit = new Text("Exit");
		//Set menu item and layout appearance and properties
		p.setStyle("-fx-background-color: black;-fx-border-color: blue");
		p.setPadding(new Insets(10,10,10,10));
		p.setGridLinesVisible(true);
		window.setTitle("JT's Gallery");
		window.setMinHeight(600);
		window.setMinWidth(800);
		load_gallery.setFill(Color.WHITE);
		exit.setFill(Color.WHITE);
		//Add menu items to window via main layout(GridPane p)
		//horizontal box used to store and group menu items
		HBox menuBar = new HBox();
		menuBar.getChildren().add(load_gallery);
		menuBar.getChildren().add(exit);
		p.add(menuBar, 0, 0);
		
	}
}
