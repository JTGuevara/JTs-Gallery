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
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;

public class Main extends Application{
	//launch JavaFX application (start() method)
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage window) throws Exception {
		//START PROGRAM	
		
		//declare application components
		final String APPLICATION_NAME = "JT's Gallery";//application name
	    final double MIN_WINDOW_WIDTH = 950.0;//minimum window width and height
	    final double MIN_WINDOW_HEIGHT = 700.0;
		Main_Layout mainLayout = new Main_Layout();//main user interface layout container for application
		Scene s = new Scene(mainLayout.layout,MIN_WINDOW_WIDTH,MIN_WINDOW_HEIGHT);//required JavaFX structure to hold layout components
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
		mainLayout.layout.add(display.getDisplay(), 0, 1);
		mainLayout.layout.add(buttonLayout.getButtonBar(), 0, 2);
		handler.load_event_handlers(window, mainLayout.layout, imageGallery);
		
		//set up JavaFX stage
		window.setTitle(APPLICATION_NAME);
		window.setMinWidth(MIN_WINDOW_WIDTH);
		window.setMinHeight(MIN_WINDOW_HEIGHT);
		window.setWidth(MIN_WINDOW_WIDTH);
		window.setHeight(MIN_WINDOW_HEIGHT);
		window.setScene(s);
		
		System.out.println("width: " + window.getMinWidth());
		System.out.println("height" + window.getMinHeight());
		
		//show time!
		window.show();
	}
}
