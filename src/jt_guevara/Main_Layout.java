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
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main_Layout {
	private GridPane layout;//main layout used for application
	private final double MENU_FONT_SIZE = 12.4;//font size for menu items
	public Main_Layout() {layout = new GridPane();}
	public GridPane getLayout() {return layout;}
	
	public void setLayout(){
		layout.setStyle("-fx-background-color: black");
		layout.setPadding(new Insets(10,10,10,10));
		layout.setAlignment(Pos.TOP_CENTER);
		layout.setVgap(10);
	}
	
	public void set_menu_items(){
		//Declare menu items to be used as clickable text for the user
		Text load_gallery = new Text("Gallery");
		Text exit = new Text("Exit");
		load_gallery.setFill(Color.WHITE);
		load_gallery.setFont(Font.font(MENU_FONT_SIZE));
		exit.setFill(Color.WHITE);
		exit.setFont(Font.font(MENU_FONT_SIZE));
		//Menu bar to store menu items
		HBox menuBar = new HBox();
		menuBar.setSpacing(10.0);
		menuBar.getChildren().add(load_gallery);
		menuBar.getChildren().add(exit);
		layout.add(menuBar, 0, 0);
	}
}
