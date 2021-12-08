/* FILE: Settings.java
   DESCRIPTION: The settings class is used to handle application settings as well as creating the 'Settings' window and applying its style properties.
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

public class Settings {
	/*
	 private static Stage generateSettingsWindow(Stage window);
	   PARAMETERS: Stage window - Parent window required for creating a child window of application settings
	   DESCRIPTION: An application settings window is created, along with settings sub-components for adjusting application settings, and returned. 
	 */
	
	private static Stage generateSettingsWindow(Stage window) {
		//DECLARE SETTINGS WINDOW AND ITS COMPONENTS 
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
		//STYLE SETTINGS WINDOW COMPONENTS
		styleSettingWindowText(bgSettingsTable,bgDescription,bgSetting,bgSetting2,bgSetting3);
		styleSettingsButtons(OK, cancel);
		styleColorPickers(colorPicker);
		applySettingsButtons(settings, OK, cancel, layout, display, buttonLayout);
		//APPLY SETTINGS 
		applySettings(colorPicker, colorPicker2, colorPicker3, layout, display, buttonLayout);
		//ADD SETTINGS COMPONENTS TO WINDOW
		p.setPadding(new Insets(10,10,10,10));
		p.setStyle("-fx-background-color: black");
		bgSettingsTable.add(bgSetting, 0, 0);
		bgSettingsTable.add(bgSetting2, 0, 1);
		bgSettingsTable.add(bgSetting3, 0, 2);
		bgSettingsTable.add(colorPicker, 1, 0);
		bgSettingsTable.add(colorPicker2, 1, 1);
		bgSettingsTable.add(colorPicker3, 1, 2);
		p.getChildren().addAll(bgDescription, bgSettingsTable, OK, cancel);
		//SET UP WINDOW
		settings.setTitle("Settings");
		settings.setWidth(500);
		settings.setHeight(280);
		settings.setScene(s);
		return settings;
	}
	
	/*
	 private static void styleSettingsButtons(Button OK, Button cancel);
	    PARAMETERS: Button OK, cancel - buttons for applying style properties
	    DESCRIPTION: The OK and Cancel of the 'Settings' window have their style properties set
	*/
	
	private static void styleSettingsButtons(Button OK, Button cancel) {
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
	}
	
	/*
	 private static void styleSettingWindowText(GridPane bgSettingsTable, Text bgDescription, Text bgSetting, Text bgSetting2, Text bgSetting3);
	    PARAMETERS: GridPane bgSettingsTable - 
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
	  private static void styleColorPickers();
	    PARAMETERS:
	    DESCRIPTION:
	*/
	private static void styleColorPickers(ColorPicker picker) {
		picker.setLayoutX(300);
		picker.setLayoutY(70);
	}
	/*
	 private static void applySettings(ColorPicker color1, ColorPicker color2, ColorPicker color3, GridPane layout, GridPane display,GridPane buttonLayout);
	    PARAMETERS: ColorPicker color1, color2, color3 - components for applying background settings to layout components
	               GridPane layout - main layout for applying background settings
	               GridPane display - gallery display for applying background settings
	               GridPane buttonLayout - button interface for applying background settings
	   DESCRIPTION: Background color settings are applied to application components.
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
			//apply background settings to display
			String color = color2.getValue().toString();
			display.setStyle("-fx-background-color: #" + color.substring(2,8) + ";-fx-border-radius: 10px;-fx-background-radius: 10px");
			});
		color3.setOnAction(event->{
			//apply background settings to button layout
			String color = color3.getValue().toString();
			buttonLayout.setStyle("-fx-background-color: #" + color.substring(2,8) + ";-fx-border-radius: 10px;-fx-background-radius: 10px");
			});
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
