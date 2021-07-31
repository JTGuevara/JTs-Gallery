/* FILE: Main_Layout.java
 * DESCRIPTION: The Main_Layout class is used to set the style and layout of the application and menu items	
 * 
 * FUNCTIONS: 
 *   public Main_Layout();
 *      DESCRIPTION: Declares a Main_Layout by initializing a new layout(GridPane)
 *      
 *   public void setLayout();
 *      DESCRIPTION: The application layout's style and general properties are set. 
 *   
 *   public GridPane getLayout();
 *      DESCRIPTION: Returns layout
 *                  
 *   public void setMenuItems();
 *      DESCRIPTION: Two text menu items are created, their style properties set and added to a menu bar. The menu bar is then added to
 *              the main application layout
 * 				
 */
package jt_guevara;

import javafx.geometry.Insets;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main_Layout {
	private GridPane layout;//main layout used for application
	private final double MENU_FONT_SIZE = 12.4;//font size for menu items
	public Main_Layout() {layout = new GridPane();}
	public GridPane getLayout() {return layout;}
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
