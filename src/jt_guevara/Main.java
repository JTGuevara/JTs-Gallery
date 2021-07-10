/* PROGRAM: IMAGE GALLERY
 * ----------------------
 * CREATED: May 17, 2021
 * COMPLETED: June 7, 2021
 *  
 * AUTHOR: Joan Torres
 * 
 * FILE: Main.java
 * DESCRIPTION:
 * 		Entry of application
 */

package jt_guevara;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.GridPane;

public class Main extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(Stage window) throws Exception {
		//START PROGRAM
		GridPane p = new GridPane();//main layout container of application		
		Scene s = new Scene(p,800,600);//required JavaFX structure to hold layout components						
		Gallery imageGallery = new Gallery();//collection class to hold images						
		Window_Layout.setWindow(window,p);
		Gallery_Layout.generate_gallery(window,p);
		UI_Button_Layout.generate_UI_controls(window,p);
		Event_Handler.load_event_handlers(window, p, imageGallery);
		window.setScene(s);
		window.show();
	}
}
