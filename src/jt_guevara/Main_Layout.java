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
 *   public HBox getMenuBar();
 *      DESCRIPTION: Returns menu bar
 *      
 *   public Text getMenuItem1();
 *      DESCRIPTION: Returns the menu item 'Gallery'
 *      
 *   public Text getMenuItem2();
 *      DESCRIPTION: Returns the menu item 'Settings'
 *      
 *   public Text getMenuItem3();
 *      DESCRIPTION: Returns the menu item 'Exit'
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
	public Main_Layout() {layout = new GridPane();}//constructor
	public GridPane layout;//main layout used for application
	final private Text gallery = new Text("Gallery");//menu items
	final private Text settings = new Text("Settings");
	final private Text exit = new Text("Exit");
	private HBox menuBar = new HBox();//menu bar to store menu items
	public final double MENU_FONT_SIZE = 12.399;//font size for menu items
	
	public HBox getMenuBar() {return menuBar;}
	public Text getMenuItem1() {return gallery;}
	public Text getMenuItem2() {return settings;}
	public Text getMenuItem3() {return exit;}
	
	public void setLayout(){
		layout.setStyle("-fx-background-color: black");
		layout.setPadding(new Insets(10,10,10,10));
		layout.setAlignment(Pos.TOP_CENTER);
		layout.setVgap(10);
	}
	
	public void set_menu_items(){
		//set menu items to be used as clickable text for the user
		gallery.setFill(Color.WHITE);
		gallery.setFont(Font.font(MENU_FONT_SIZE));
		settings.setFill(Color.WHITE);
		settings.setFont(Font.font(MENU_FONT_SIZE));
		exit.setFill(Color.WHITE);
		exit.setFont(Font.font(MENU_FONT_SIZE));
		//set menu bar properties
		menuBar.setSpacing(10.0);
		menuBar.getChildren().add(gallery);
		menuBar.getChildren().add(settings);
		menuBar.getChildren().add(exit);
		layout.add(menuBar, 0, 0);
	}
}
