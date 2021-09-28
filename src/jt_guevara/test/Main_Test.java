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
import javafx.application.Platform;
import javafx.stage.Stage;
import jt_guevara.Main;

public class Main_Test extends Application{
	
	@Test
	public void testLaunch() {
		Main app = new jt_guevara.Main();//declare application instance
		Application.launch(app.getClass());//test launch
		assertTrue(Application.class.isInstance(app));
	}
	
	@Override
	public void start(Stage window) throws Exception {
		//empty start() method included for extending Application class 
	}

	
}
