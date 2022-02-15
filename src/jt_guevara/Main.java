/* PROGRAM: IMAGE GALLERY
 * ----------------------
 * CREATED: May 17, 2021
 * COMPLETED: June 7, 2021
 *  
 * AUTHOR: Joan Torres
 * 
 * FILE: Main.java
 * DESCRIPTION:
 *    Entry of application
 */

package jt_guevara;
import java.util.ArrayDeque;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.Image;

public class Main extends Application{
	//launch JavaFX application (start() method)
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage window) throws Exception {
		//IMAGE GALLERY PROGRAM:
		//1.) declare application components
		//2.) set up components
		//		- set up main layout
		//		- set up gallery display
		//		- set up button interface
		//		- add gallery display and button interface to the layout 
		//		- set functionality to application components
		//3.) set up JavaFX components
		//		- set JavaFX window properties(Stage)
		//4.) show window to user
		
		final String APPLICATION_NAME = "JT's Gallery";								//application name to be displayed at the top of the window
	    final double MIN_WINDOW_WIDTH = 950.0;										//minimum window width and height (declared with desktop systems in mind)
	    final double MIN_WINDOW_HEIGHT = 700.0;
		Main_Layout mainLayout = new Main_Layout();									//main user-interface layout component for application and required JavaFX node
		Scene s = new Scene(mainLayout.layout,MIN_WINDOW_WIDTH,MIN_WINDOW_HEIGHT);	//required JavaFX structure to hold layout components and nodes
		ArrayDeque<Image> imageGallery = new ArrayDeque<Image>();					//collection for containing images
																					//(Note: the ArrayDeque structure is used to implement the gallery's scrolling 
																					//mechanism via the left-scroll and right-scroll buttons)
		Gallery_Display display = new Gallery_Display();							//layout sub-component containing three canvases for displaying images 
		Button_Layout buttonLayout = new Button_Layout();							//layout sub-component for manipulating images
		Event_Handler handler = new Event_Handler();								//class to set functionality to user interface components
		
		mainLayout.setLayout();
		mainLayout.setMenuComponents();
		display.setUpDisplay();
		display.synchronizeDisplay(window);
		buttonLayout.set_scroll_buttons();
		buttonLayout.set_zoom_button();
		buttonLayout.set_button_bar();
		buttonLayout.add_buttons();
		buttonLayout.bind_button_layout(window);
		mainLayout.layout.add(display.getDisplay(), 0, 1);
		mainLayout.layout.add(buttonLayout.getButtonBar(), 0, 2);
		handler.setComponents(window, mainLayout, display, buttonLayout, imageGallery);
		
		window.setTitle(APPLICATION_NAME);
		window.setMinWidth(MIN_WINDOW_WIDTH);
		window.setMinHeight(MIN_WINDOW_HEIGHT);
		window.setWidth(MIN_WINDOW_WIDTH);
		window.setHeight(MIN_WINDOW_HEIGHT);
		window.setScene(s);
		
		//necessary statement, otherwise the application merely runs in the background
		window.show();
	}
}
