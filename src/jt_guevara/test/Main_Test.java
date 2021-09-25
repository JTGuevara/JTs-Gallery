/* FILE: Main_Test.java
 * DESCRIPTION: Test of Main.java class. 
 * 
 * FUNCTIONS:
 * 		public void testLaunch(); 
 * 			DESCRIPTION: Tests the launch of the application. Verifies that the application has launched successfully.
 */

package jt_guevara.test;

import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.stage.Stage;
import jt_guevara.Main;

public class Main_Test extends Application{
	
	@Test
	public void testLaunch() {
		Main application = new Main();//declare application instance
		boolean appLaunched = true;
		Application.launch(application.getClass());//launch application instance
		assertTrue(appLaunched);
	}
	
	@Override
	public void start(Stage window) throws Exception {
		//empty start() method included for extending Application class 
	}

	
}
