/*FILE: Main_Test.java
 *DESCRIPTION: Main class for testing application. The Main_Test class will run the application and initialize an automated test.
 */

package jt_guevara.test;

import javafx.scene.robot.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.util.Duration;
import jt_guevara.Button_Layout;
import jt_guevara.Event_Handler;
import jt_guevara.Gallery;
import jt_guevara.Gallery_Display;
import jt_guevara.Main_Layout;

public class Main_Test extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
		
	@Override
	public void start(Stage window) throws Exception {
	//START JAVAFX TEST PROGRAM	
		//declare application components
		final String APPLICATION_NAME = "JT's Gallery";//application name
		final double MIN_WINDOW_WIDTH = 800.0;//minimum window width and height
		final double MIN_WINDOW_HEIGHT = 600.0;
		Main_Layout mainLayout = new Main_Layout();//main user interface layout container for application
		Scene s = new Scene(mainLayout.getLayout(),800,600);//required JavaFX structure to hold layout components
		Gallery imageGallery = new Gallery();//collection class to hold images		
		Gallery_Display display = new Gallery_Display();//layout sub-component for displaying images 
		Button_Layout buttonLayout = new Button_Layout();//layout sub-component for manipulating images
		Event_Handler handler = new Event_Handler();//class to set functionality to user interface components
				
		//set up components
		mainLayout.setLayout();
		mainLayout.set_menu_items();
		display.setup_gallery();
		display.bind_gallery(window);
		buttonLayout.set_scroll_buttons();
		buttonLayout.set_zoom_button();
		buttonLayout.set_button_bar();
		buttonLayout.add_buttons();
		buttonLayout.bind_button_layout(window);
		mainLayout.getLayout().add(display.getDisplay(), 0, 1);
		mainLayout.getLayout().add(buttonLayout.getButtonBar(), 0, 2);
		handler.load_event_handlers(window, mainLayout.getLayout(), imageGallery);
		
				
		//set up JavaFX stage
		window.setTitle(APPLICATION_NAME);
		window.setMinWidth(MIN_WINDOW_WIDTH);
		window.setMinHeight(MIN_WINDOW_HEIGHT);
		window.setScene(s);
				
		//show stage
		window.show();
				
		
		//Set up and initialize automated test
		Robot testBot = new Robot();
		double initialX = testBot.getMouseX();//initial mouse coordinates
		double initialY = testBot.getMouseY();
		moveMousePointer(testBot,initialX, window.getX(),initialY, window.getY());//move mouse to top-left of application screen
		initialize_test(testBot, window);
	}
}
