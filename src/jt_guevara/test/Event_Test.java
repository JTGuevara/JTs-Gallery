/* FILE: Event_Test.java
 * DESCRIPTION: Test of Event_Handler.java class. Checks to make sure each user-interface component has an attached functionality
 * 
 * FUNCTIONS:
 * 		public static void testUIComponents(GridPane layout, GridPane buttonLayout);
 * 			DESCRIPTION: Prints string representation of event handlers associated with user-interface components. 
 * 			THROWS: NullPointerException if UI components do not exist or are null
 * 
 */
package jt_guevara.test;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class Event_Test{
	public static void testUIComponents(GridPane layout, GridPane buttonLayout) throws NullPointerException{
		//get user-interface components
		HBox menuBar = (HBox) layout.getChildren().get(0);
		Button left = (Button) buttonLayout.getChildren().get(0);
		Button right = (Button) buttonLayout.getChildren().get(2);
		Button zoom = (Button) buttonLayout.getChildren().get(1);
		
		//print event handlers associated with user-interface components
		System.out.println("MENU BAR (CLICK)\n");
		System.out.println("GALLERY: " + menuBar.getChildren().get(0).getOnMouseClicked());
		System.out.println("EXIT: " + menuBar.getChildren().get(1).getOnMouseClicked());
		System.out.println("\n");
		System.out.println("MENU BAR (HOVER)\n");
		System.out.println("GALLERY: " + menuBar.getChildren().get(0).getOnMouseEntered());
		System.out.println("\t" + menuBar.getChildren().get(0).getOnMouseExited());
		System.out.println("EXIT: " + menuBar.getChildren().get(1).getOnMouseEntered());
		System.out.println("\t" + menuBar.getChildren().get(1).getOnMouseExited());
		System.out.println("\n");
		
		
		System.out.println("BUTTON LAYOUT (CLICK) \n");
		System.out.println("LEFT-SCROLL BUTTON: " + left.getOnAction());
		System.out.println("ZOOM BUTTON: " + zoom.getOnAction());
		System.out.println("RIGHT-SCROLL BUTTON: " + right.getOnAction());
		System.out.println("\n");
		System.out.println("BUTTON LAYOUT (HOVER) \n");
		System.out.println("LEFT-SCROLL BUTTON: " + left.getOnMouseEntered() + "\n\t\t" + left.getOnMouseExited());
		System.out.println("ZOOM BUTTON: " + zoom.getOnMouseEntered() + "\n\t\t" + zoom.getOnMouseExited());
		System.out.println("RIGHT-SCROLL BUTTON: " + right.getOnMouseEntered() + "\n\t\t" + right.getOnMouseExited());
	}
	
}
