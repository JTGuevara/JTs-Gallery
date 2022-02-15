/* FILE: SettingsWindow.java
   DESCRIPTION: The SettingsWindow class represents the application's 'Settings' window and its sub-components used for modifying different parts
                of the application. The class handles the creation of the window and its sub-components, the application of their style properties
                as well as setting functionality to each of the setting sub-components for modifying other parts of the application.
*/
package jt_guevara;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SettingsWindow{
	private Stage settingsWin;//settings window 
	private GridPane bgSettingsTable;//table structure for background settings
	private Text bgDescription;//text descriptions for background settings
	private Text layoutSettingText;
	private Text displaySettingText;
	private Text buttonLayoutSettingText;
	private Button OK;//setting window buttons
	private Button cancel;
	private ColorPicker bgLayoutSetting;//components for adjusting background settings
	private ColorPicker bgDisplaySetting;
	private ColorPicker bgButtonLayoutSetting;
	
/*
public SettingsWindow();
    DESCRIPTION: Initializes and allocates setting window and its components to memory	 
*/
	public SettingsWindow() {//constructor
		settingsWin = new Stage();
		bgSettingsTable = new GridPane();
		bgDescription = new Text("Change Background:");
		layoutSettingText = new Text("Main: ");
		displaySettingText = new Text("Gallery Interface: ");
		buttonLayoutSettingText = new Text("Button Interface: ");
		bgLayoutSetting = new ColorPicker();
		bgDisplaySetting = new ColorPicker();
		bgButtonLayoutSetting = new ColorPicker();
		OK = new Button();
		cancel = new Button();
	}
	
	public Stage getWindow() {return settingsWin;}//get functions for setting window and its components
	public GridPane getbgSettingsTable() {return bgSettingsTable;}
	public Text getBGDescription() {return bgDescription;}
	public Text getLayoutSettingText() {return layoutSettingText;}
	public Text getDisplaySettingText() {return displaySettingText;}
	public Text getButtonLayoutSettingText() {return buttonLayoutSettingText;}
	public ColorPicker getBGLayoutSetting() {return bgLayoutSetting;}
	public ColorPicker getDisplaySetting() {return bgDisplaySetting;}
	public ColorPicker getBGButtonLayoutSetting() {return bgButtonLayoutSetting;}
	public Button getOKButton() {return OK;}
	public Button getCancelButton() {return cancel;}
	
	
/*
private static Stage generateSettingsWindow(Stage window);
	PARAMETERS: Stage window - Parent window required for creating a child window of application settings and retrieving layout components
	DESCRIPTION: An application settings window is generated, along with settings sub-components for adjusting other parts of the application
	             (ex. layout components). The window is then returned. 
*/
	
	public Stage generateSettingsWindow(Stage window) {
		//DECLARE JAVAFX STRUCTURE FOR SETTINGS WINDOW
		Pane p = new Pane();
		Scene s = new Scene(p,500,300);
		GridPane layout = (GridPane) window.getScene().getRoot();//retrieve layout components for applying background settings
		GridPane display = (GridPane) layout.getChildren().get(1);
		GridPane buttonLayout = (GridPane) layout.getChildren().get(2);
		//STYLE SETTINGS WINDOW COMPONENTS
		styleSettingWindowText(bgSettingsTable,bgDescription,layoutSettingText,displaySettingText,buttonLayoutSettingText);
		styleSettingsButtons(OK, cancel);
		//APPLY SETTINGS 
		applySettings(bgLayoutSetting, bgDisplaySetting, bgButtonLayoutSetting, layout, display, buttonLayout);
		applySettingsButtons(settingsWin, OK, cancel, layout, display, buttonLayout, bgLayoutSetting, bgDisplaySetting, bgButtonLayoutSetting);
		//ADD SETTINGS COMPONENTS TO WINDOW
		p.setPadding(new Insets(10,10,10,10));
		p.setStyle("-fx-background-color: black");
		bgSettingsTable.add(layoutSettingText, 0, 0);
		bgSettingsTable.add(displaySettingText, 0, 1);
		bgSettingsTable.add(buttonLayoutSettingText, 0, 2);
		bgSettingsTable.add(bgLayoutSetting, 1, 0);
		bgSettingsTable.add(bgDisplaySetting, 1, 1);
		bgSettingsTable.add(bgButtonLayoutSetting, 1, 2);
		p.getChildren().addAll(bgDescription, bgSettingsTable, OK, cancel);
		//SET WINDOW PARAMETERS 
		settingsWin.setTitle("Settings");
		settingsWin.setWidth(500);
		settingsWin.setHeight(280);
		settingsWin.setScene(s);
		return settingsWin;
	}
	
/*
private static void styleSettingsButtons(Button OK, Button cancel);
	PARAMETERS: Button OK, cancel - buttons for applying style properties
	DESCRIPTION: The OK and Cancel of the 'Settings' window have their style properties set
*/
	
	private static void styleSettingsButtons(Button OK, Button cancel) {
		OK.setLayoutX(185);
		OK.setLayoutY(200);
		OK.setStyle("-fx-background-color: black;-fx-border-color: white;-fx-border-width: 1px");
		OK.setText("OK");
		OK.setTextFill(Color.WHITE);
		cancel.setLayoutX(245);
		cancel.setLayoutY(200);
		cancel.setStyle("-fx-background-color: black;-fx-border-color: white;-fx-border-width: 1px");
		cancel.setText("Cancel");
		cancel.setTextFill(Color.WHITE);
	}
	
/*
private static void styleSettingWindowText(GridPane bgSettingsTable, Text bgDescription, Text bgSetting, Text bgSetting2, Text bgSetting3);
	PARAMETERS: GridPane bgSettingsTable - table structure for background settings used to format its text
	            Text bgDescription, bgSetting, - text descriptions for background settings
	                     bgSetting2, bgSetting3 
	DESCRIPTION: Each text component in the 'Settings' window has its style properties set
*/
	
	private static void styleSettingWindowText(GridPane bgSettingsTable, Text bgDescription, Text bgSetting, Text bgSetting2, Text bgSetting3) {
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
	}	
	
/*
private static void applySettings(ColorPicker color1, ColorPicker color2, ColorPicker color3, GridPane layout, GridPane display,GridPane buttonLayout);
     PARAMETERS: ColorPicker color1, color2, color3 - setting components for applying background settings to layout components
	             GridPane layout - main layout for modifying background settings
	             GridPane display - gallery display for modifying background settings
	             GridPane buttonLayout - button interface for modifying background settings
	 DESCRIPTION: Functionality is added to setting components for modifying application background colors.
*/
	private static void applySettings(ColorPicker color1, ColorPicker color2, ColorPicker color3, GridPane layout, GridPane display,GridPane buttonLayout)
	{
		/*apply background settings using color pickers to change background color of 
		layout components*/
		color1.setOnAction(event->{
			//apply background settings to main layout
			String color = color1.getValue().toString();
			layout.setStyle("-fx-background-color: #" + color.substring(2,8) + ";");
			});
		color2.setOnAction(event->{
			//apply background settings to gallery display and canvases
			String color = color2.getValue().darker().toString();
			String borderColor = color2.getValue().brighter().toString();
			display.setStyle("-fx-background-color: #" + color.substring(2,8) + ";-fx-border-width: 5px;-fx-border-radius: 10px;"
					+ "-fx-background-radius: 10px;-fx-border-color: #" + borderColor.substring(2,8));
			
			});
		color3.setOnAction(event->{
			//apply background settings to button layout
			String color = color3.getValue().darker().toString();
			String borderColor = color3.getValue().brighter().toString();
			buttonLayout.setStyle("-fx-background-color: #" + color.substring(2,8) + ";-fx-border-width: 5px;-fx-border-radius: 10px;"
					+ "-fx-background-radius: 10px;-fx-border-color: #" + borderColor.substring(2,8));
			});
	}
	
/*
private static void applySettingsButtons(Stage settings, Button OK, Button cancel, GridPane layout, GridPane display, GridPane buttonLayout);
    PARAMETERS: Stage settings - settings window for setting 'OK' and 'Cancel' buttons
                Button OK - OK button for confirming new application settings
                Button cancel - Cancel button for modifying application settings to default 
                GridPane layout - layout component for resetting background settings to default after pressing cancel button
                GridPane display - gallery display component for resetting background settings to default after pressing cancel button
                GridPane buttonLayout - button layout component for resetting background settings to default after pressing cancel button
                ColorPicker color1, color2, color3 - color pickers used for resetting background settings to default 
                   
    DESCRIPTION: Sets functions to the setting window's 'OK' and 'Cancel' buttons. 
*/
	
	private static void applySettingsButtons(Stage settings, Button OK, Button cancel, GridPane layout, GridPane display, GridPane buttonLayout,
			                                 ColorPicker color1, ColorPicker color2, ColorPicker color3) {
		//default styles for reverting to previous background settings
		String defaultLayoutStyle = layout.getStyle();
		String defaultDisplayStyle= display.getStyle();
		String defaultButtonLayoutStyle = buttonLayout.getStyle();
		//OK button - confirm any new application settings and close window 
		//Cancel button - set any application settings to default and close window
		OK.setOnMouseClicked(event->{
			settings.close();
		});
		cancel.setOnMouseClicked(event->{
			//reset background settings to default colors
			layout.setStyle(defaultLayoutStyle);
			display.setStyle(defaultDisplayStyle);
			buttonLayout.setStyle(defaultButtonLayoutStyle);
			settings.close();
		});
		
		//change button colors when hovered over and away
		OK.setOnMouseEntered(event->{OK.setStyle("-fx-background-color: gray;-fx-border-color: white;-fx-border-width: 1px");});
		OK.setOnMouseExited(event->{OK.setStyle("-fx-background-color: black;-fx-border-color: white;-fx-border-width: 1px");});
		cancel.setOnMouseEntered(event->{cancel.setStyle("-fx-background-color: gray;-fx-border-color: white;-fx-border-width: 1px");});
		cancel.setOnMouseExited(event->{cancel.setStyle("-fx-background-color: black;-fx-border-color: white;-fx-border-width: 1px");});
	}
	
}
