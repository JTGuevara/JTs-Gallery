/*FILE: Application_Test.java
 *DESCRIPTION: Main class for testing application. The Application_Test class will use automated testing to run the application
 *     in a testing environment. The automated test will simulate a user clicking on the user interface and testing the functionality 
 *     of each component (gallery upload, left-scroll, right-scroll, etc.). The Application_Test class also serves as the application's
 *     second entry point.
 *
 */

package jt_guevara.test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jt_guevara.Button_Layout;
import jt_guevara.Event_Handler;
import jt_guevara.Gallery;
import jt_guevara.Gallery_Display;
import jt_guevara.Main_Layout;

public class Application_Test extends Application{

	public static void main(String[] args) {
		jt_guevara.Main.launch(args);
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
				
				//show time!
				window.show();
	}
}
