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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

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
	
	private static Stage generateSettingsWindow(Stage window) {
		//DECLARE WINDOW AND SETTING COMPONENTS 
		Stage settings = new Stage();
		Pane p = new Pane();
		Scene s = new Scene(p,500,280);
		Button OK = new Button();//setting window buttons
		Button cancel = new Button();
		GridPane layout = (GridPane) window.getScene().getRoot();//retrieve layout components for applying background settings
		GridPane display = (GridPane) layout.getChildren().get(1);
		GridPane buttonLayout = (GridPane) layout.getChildren().get(2);
		GridPane bgSettingsTable = new GridPane();//container for background settings
		Text bgDescription = new Text("Change Background:");//text descriptions for background settings
		Text bgSetting = new Text("Main: ");
		Text bgSetting2 = new Text("Gallery Interface: ");
		Text bgSetting3 = new Text("Button Interface: ");
		ColorPicker colorPicker = new ColorPicker();//color picker objects for applying background settings to layout components
		ColorPicker colorPicker2 = new ColorPicker();
		ColorPicker colorPicker3 = new ColorPicker();
		//APPLY SETTING COMPONENTS TO WINDOW
		//(set buttons)
		OK.setLayoutX(180);
		OK.setLayoutY(200);
		OK.setStyle("-fx-background-color: black;-fx-border-color: white;-fx-border-width: 1px");
		OK.setText("OK");
		OK.setTextFill(Color.WHITE);
		cancel.setLayoutX(240);
		cancel.setLayoutY(200);
		cancel.setStyle("-fx-background-color: black;-fx-border-color: white;-fx-border-width: 1px");
		cancel.setText("Cancel");
		cancel.setTextFill(Color.WHITE);
		setWindowButtons(settings, OK, cancel, layout, display, buttonLayout);
		//(set text descriptions)
		bgDescription.setFont(Font.font(20));
		bgDescription.setFill(Color.WHITE);
		bgDescription.setLayoutX(20);
		bgDescription.setLayoutY(50);
		bgSettingsTable.setVgap(10);
		bgSettingsTable.setHgap(50);
		bgSettingsTable.setLayoutX(50);
		bgSettingsTable.setLayoutY(75);
		bgSetting.setFont(Font.font(17));
		bgSetting.setFill(Color.WHITE);
		bgSetting2.setFont(Font.font(17));
		bgSetting2.setFill(Color.WHITE);
		bgSetting3.setFont(Font.font(17));
		bgSetting3.setFill(Color.WHITE);
		colorPicker.setLayoutX(300);
		colorPicker.setLayoutY(70);
		/*apply background settings using color pickers to change background color of 
		layout components*/
		colorPicker.setOnAction(event->{
			//apply background settings to main layout
			String color = colorPicker.getValue().toString();
			layout.setStyle("-fx-background-color: #" + color.substring(2,8) + ";");
			});
		colorPicker2.setOnAction(event->{
			//apply background settings to display
			String color = colorPicker2.getValue().toString();
			display.setStyle("-fx-background-color: #" + color.substring(2,8) + ";-fx-border-radius: 10px;-fx-background-radius: 10px");
			});
		colorPicker3.setOnAction(event->{
			//apply background settings to button layout
			String color = colorPicker3.getValue().toString();
			buttonLayout.setStyle("-fx-background-color: #" + color.substring(2,8) + ";-fx-border-radius: 10px;-fx-background-radius: 10px");
			});
		//SET UP WINDOW 
		settings.setTitle("Settings");
		settings.setWidth(500);
		settings.setHeight(280);
		settings.setScene(s);
		p.setPadding(new Insets(10,10,10,10));
		p.setStyle("-fx-background-color: black");
		bgSettingsTable.add(bgSetting, 0, 0);
		bgSettingsTable.add(bgSetting2, 0, 1);
		bgSettingsTable.add(bgSetting3, 0, 2);
		bgSettingsTable.add(colorPicker, 1, 0);
		bgSettingsTable.add(colorPicker2, 1, 1);
		bgSettingsTable.add(colorPicker3, 1, 2);
		p.getChildren().addAll(bgDescription, bgSettingsTable, OK, cancel);
		return settings;
	}
	
	/*
	 private static void applySettingsButtons(Stage settings, Button OK, Button cancel, GridPane layout, GridPane display, GridPane buttonLayout);
        PARAMETERS: Stage settings - settings window for setting 'OK' and 'Cancel' buttons
                    Button OK - OK button for confirming new application settings
                    Button cancel - Cancel button for modifying application settings to default 
                    GridPane layout - layout component for modifying settings to default after cancellation
                    GridPane display - gallery display component for modifying settings to default after cancellation
                    GridPane buttonLayout - button layout component for modifying settings to default after cancellation
                    
        DESCRIPTION: Sets the actions of the application setting window's 'OK' and 'Cancel' buttons. The OK button is set to close the settings window
                     and confirm any application settings that are made. The 'Cancel' button resets any application settings to default and then closes
                     the window.
	 */
	
	private static void applySettingsButtons(Stage settings, Button OK, Button cancel, GridPane layout, GridPane display, GridPane buttonLayout) {
		//OK button - confirm any new application settings and close window
		//Cancel button - set application settings to default and close window
		OK.setOnMouseClicked(event->{
			settings.close();
		});
		cancel.setOnMouseClicked(event->{
			//reset background settings to default
			layout.setStyle("-fx-background-color: black");
			display.setStyle("-fx-border-color: blue;-fx-border-width: 5px;-fx-border-color: royalblue;-fx-border-radius: 10px;"
					+ "-fx-background-color: darkblue;-fx-background-radius: 10px");
			buttonLayout.setStyle("-fx-border-color: royalblue;-fx-border-radius: 10px;-fx-background-radius: 10px;"
					+ "-fx-border-width: 5px;-fx-background-color: darkblue;");
			settings.close();
		});
	}
}
