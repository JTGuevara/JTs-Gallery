/* FILE: Automated_Test.java
 * CLASS DESCRIPTION: Automated test class. The automated test will use a robot to simulate a user clicking on the user interface and testing the functionality
 *     of each component of the image gallery(gallery upload, left-scroll, right-scroll, etc.). 
 *     
 * FUNCTIONS:
 *	public void initialize_test(Robot testBot);
 *      PARAMETERS: Robot testBot - robot class for automation
 *                  Stage window - window for obtaining mouse coordinates relative to the user's monitor
 *      DESCRIPTION: Starts the automated test. The function uses a robot to automate a user clicking a menu item to upload images and clicking
 *         the lower buttons to manipulate images. The test consists of a series of animations where each mouse movement and click is recorded 
 *         in a frame. The functionality of the menu items and gallery upload are tested and their results recorded. The function exits 
 *         when the button test begins.
 *         
 *         
 *  public void moveMousePointer(Robot testBot, double x1, double x2, double y1, double y2);
 *      PARAMETERS: Robot testBot - robot class for moving mouse pointer
 *                  double x1,y1 - previous mouse coordinates
 *                  double x2,y2 - destination mouse coordinates
 *      DESCRIPTION: Automates a movement of the mouse pointer from point(x1,y1) to point(x2,y2) by moving the mouse pointer n times
 *      
 *  
 *  private void button_test(Robot testBot, Stage window);
 *      PARAMETERS: Robot testBot - robot class for automating button tests
 *                  Stage window - window parameter for obtaining mouse coordinates relative to the user's monitor
 *                  
 *      DESCRIPTION: Starts automated button test. Uses a robot to simulate a user clicking on the button interface on the lower portion of 
 *         the screen. The test consists of a series of animations where each mouse movement and click is recorded in a frame. The button 
 *         test ends when the application is minimized from full-screen and exited.
 *         
 *         
 *  private void testGalleryMenuItem(HBox menuBar);
 *      PARAMETERS: HBox menuBar - application menu bar for testing menu item
 *                  String result - for recording test results
 *      DESCRIPTION: Tests menu item 'Gallery' and records the result
 *      
 *      
 *  private void testGalleryUpload(HBox menuBar);
 *      PARAMETERS: Gallery_Display display - gallery display for testing upload
 *                  String result - for recording test results
 *      DESCRIPTION: Tests gallery uploading of images and records the result
 *      
 *  private void testZoomButton(GridPane buttonBar);
 *      PARAMETER: GridPane buttonBar - button layout for accessing zoom button for test
 *      DESCRIPTION: Tests zoom button and records the result
 *      
 *  private void testLeftScroll(GridPane buttonBar);
 *      PARAMETER: GridPane buttonBar - button layout for accessing left-scroll button for test
 *      DESCRIPTION: Tests left-scroll button and records the result
 *      
 *  private void testRightScroll(GridPane buttonBar);
 *      PARAMETER: GridPane buttonBar - button layout for accessing right-scroll button for test
 *      DESCRIPTION: Tests right-scroll button and records the result
 *         
 *   ------------------     
 *        (NOTES):
 *   ------------------
 *      - The button test runs in full-screen mode, which may or may not work depending on your specific resolution. If that is the case, feel
 *        free to adjust the robot's mouse pointer coordinates at each animation frame sequence while keeping the order of the animation intact.
 *        
 *      - Make sure to call the Stage.getX() and Stage.getY() methods to get the window position of the application and the Robot.getMouseX() 
 *        and Robot.getMouseY() methods to get its current mouse coordinates. These will aid in getting the correct (x,y) coordinates for your specific
 *        machine so the robot can locate and activate the user interface components.
 */
package jt_guevara.test;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import javafx.util.Duration;
import jt_guevara.Gallery_Display;

public class Automated_Test {
	public Automated_Test() {}//constructor
	public StringBuilder result = new StringBuilder();//string to hold test results
	
	public void initialize_test(Robot testBot, Stage window, HBox menuBar, Gallery_Display display, GridPane buttonBar) throws InterruptedException {
		double x = testBot.getMouseX();//get current mouse coordinates
		double y = testBot.getMouseY();
		Timeline t = new Timeline( //define animation 
			new KeyFrame(Duration.ZERO, event -> {moveMousePointer(testBot,x,x,y,y);}),
			new KeyFrame(Duration.seconds(0.5), event -> {moveMousePointer(testBot,x,x + 30,y,y + 50);}), //upload gallery 
			new KeyFrame(Duration.seconds(1), event -> {testBot.mouseClick(MouseButton.PRIMARY);testGalleryMenuItem(menuBar);}),//gallery menu item test
			new KeyFrame(Duration.seconds(1.5), event -> {moveMousePointer(testBot,x + 20,x + 150,y + 50,y + 250);}),
			new KeyFrame(Duration.seconds(2), event -> {testBot.keyPress(KeyCode.CONTROL);}),
			new KeyFrame(Duration.seconds(2), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(2.3), event -> {moveMousePointer(testBot,x + 150, x + 300,y + 250, y + 250);}),
			new KeyFrame(Duration.seconds(2.6), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(2.9), event -> {moveMousePointer(testBot,x + 300, x + 450,y + 250, y + 250);}),
			new KeyFrame(Duration.seconds(3.3), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(3.5), event -> {testBot.keyRelease(KeyCode.CONTROL);}),
			new KeyFrame(Duration.seconds(3.9), event -> {moveMousePointer(testBot,x + 450, x + 800,y + 250, y + 580);}),//click open to close file dialog
			new KeyFrame(Duration.seconds(4), event -> {testBot.mouseClick(MouseButton.PRIMARY);testGalleryUpload(display);}),//gallery upload test
			new KeyFrame(Duration.seconds(4.5), event -> {button_test(testBot, buttonBar, window);}) //button test
			);
		t.setCycleCount(1);
		t.play();
	}
	
	public void moveMousePointer(Robot testBot, double x1, double x2, double y1, double y2) {
		int n = 1000;//amount of times mouse pointer is moved from point(x1,y1) to point(x2,y2) (increase n to simulate smoother mouse movements)
		double dx = (x2 - x1) / n;//change in the mouse x-coordinate
		double dy = (y2 - y1) / n;//change in the mouse y-coordinate
		
		for(int i = 1;i <= n;++i) 
			testBot.mouseMove(x1 + dx * i, y1 + dy * i);
	}
	
	private void button_test(Robot testBot, GridPane buttonBar, Stage window) {
		double x = testBot.getMouseX();//get current mouse coordinates
		double y = testBot.getMouseY();
		
		Timeline t = new Timeline( //define animation 
			new KeyFrame(Duration.ZERO, event -> {moveMousePointer(testBot,x,x,y,y);}),	
			new KeyFrame(Duration.seconds(0.7), event -> {moveMousePointer(testBot,x,x - 50,y,y - 570);}),//navigate to maximize icon for full-screen
			new KeyFrame(Duration.seconds(1.1), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(1.7), event -> {moveMousePointer(testBot,x - 50,window.getWidth() / 2,y - 570,window.getHeight() / 1.2);}),//navigate to zoom button
			new KeyFrame(Duration.seconds(2.3), event -> {testBot.mouseClick(MouseButton.PRIMARY);testZoomButton(buttonBar);}),
			new KeyFrame(Duration.seconds(2.9), event -> {testBot.mouseClick(MouseButton.PRIMARY);testZoomButton(buttonBar);}),
			new KeyFrame(Duration.seconds(3.5), event -> {testBot.mouseClick(MouseButton.PRIMARY);testZoomButton(buttonBar);}),
			new KeyFrame(Duration.seconds(4.1), event -> {testBot.mouseClick(MouseButton.PRIMARY);testZoomButton(buttonBar);}),
			new KeyFrame(Duration.seconds(4.7), event -> {moveMousePointer(testBot,testBot.getMouseX(),testBot.getMouseX() + 100,y + 160,y + 160);}),//move to right-scroll
			new KeyFrame(Duration.seconds(5.6), event -> {testBot.mouseClick(MouseButton.PRIMARY);testRightScroll(buttonBar);}),
			new KeyFrame(Duration.seconds(6.2), event -> {testBot.mouseClick(MouseButton.PRIMARY);testRightScroll(buttonBar);}),
			new KeyFrame(Duration.seconds(6.9), event -> {testBot.mouseClick(MouseButton.PRIMARY);testRightScroll(buttonBar);}),
			new KeyFrame(Duration.seconds(7.5), event -> {moveMousePointer(testBot,testBot.getMouseX(),testBot.getMouseX() - 230,y + 160,y + 160);}),//move to left-scroll
			new KeyFrame(Duration.seconds(8.1), event -> {testBot.mouseClick(MouseButton.PRIMARY);testLeftScroll(buttonBar);}),
			new KeyFrame(Duration.seconds(8.7), event -> {testBot.mouseClick(MouseButton.PRIMARY);testLeftScroll(buttonBar);}),
			new KeyFrame(Duration.seconds(9.3), event -> {testBot.mouseClick(MouseButton.PRIMARY);testLeftScroll(buttonBar);}),
			new KeyFrame(Duration.seconds(9.7), event -> {moveMousePointer(testBot,testBot.getMouseX() - 230,window.getWidth() - 100,y + 160,10);}),//navigate to minimize screen
			new KeyFrame(Duration.seconds(9.9), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(10.4), event -> {moveMousePointer(testBot,testBot.getMouseX() - 100,window.getX() + 70, window.getY(),window.getY() + 50);}),//navigate to exit
			new KeyFrame(Duration.seconds(10.8), event -> {System.out.println("RESULTS:\n" + "---------\n\n" + result);}),//print test result and close program
			new KeyFrame(Duration.seconds(11), event -> {testBot.mouseClick(MouseButton.PRIMARY);})
			
			);
		t.setCycleCount(1);
		t.play();
	}
	
	private void testGalleryMenuItem(HBox menuBar) {
		//if menu bar is null, not pressed, disabled, not visible or does not have focus, fail	
	    if(menuBar == null)
	    	result.append("MENU ITEM TEST(GALLERY UPLOAD): FAIL\n");
	    else if(menuBar.getChildren().get(0).isDisabled())  
	    	result.append("MENU ITEM TEST(GALLERY UPLOAD): FAIL\n");
		else if(!(menuBar.getChildren().get(0).isFocused()))
			result.append("MENU ITEM TEST(GALLERY UPLOAD): FAIL\n");
		else if(!menuBar.getChildren().get(0).isVisible())
			result.append("MENU ITEM TEST(GALLERY UPLOAD): FAIL\n");
		else
			result.append("MENU ITEM TEST(GALLERY UPLOAD): PASS\n");
	}
	
	
	private void testGalleryUpload(Gallery_Display display) {
		//if any canvas is null, disabled or not visible, fail
		if(display.getLeftCanvas() == null || display.getMidCanvas() == null || display.getRightCanvas() == null)
			result.append("GALLERY UPLOAD: FAIL\n");
		else if(display.getLeftCanvas().isDisabled() || display.getMidCanvas().isDisabled() || display.getRightCanvas().isDisabled()) //test gallery upload
			result.append("GALLERY UPLOAD: FAIL\n");
		else if(!(display.getLeftCanvas().isVisible()) || !(display.getMidCanvas().isVisible()) || !(display.getRightCanvas().isVisible()))
			result.append("GALLERY UPLOAD: FAIL\n");
		else 
			result.append("GALLERY UPLOAD: PASS\n");
	}
	
	private void testZoomButton(GridPane buttonBar) {
		//if zoom button is null, disable, not visible or not pressed, fail
		if(buttonBar == null)
			result.append("ZOOM BUTTON TEST: FAIL\n");
		else if(buttonBar.getChildren().get(1).isDisabled())
			result.append("ZOOM BUTTON TEST: FAIL\n");
		else if(!(buttonBar.getChildren().get(1).isVisible()))
			result.append("ZOOM BUTTON TEST: FAIL\n");
		else if(!(buttonBar.getChildren().get(1).isPressed()))
			result.append("ZOOM BUTTON TEST: FAIL\n");
		else
			result.append("ZOOM BUTTON TEST: PASS\n");
	}
	
	private void testLeftScroll(GridPane buttonBar) {
		//if left-scroll button is null, disable, not visible or not pressed, fail
		if(buttonBar == null)
			result.append("LEFT-SCROLL BUTTON TEST: FAIL\n");
		else if(buttonBar.getChildren().get(0).isDisabled())
			result.append("LEFT-SCROLL BUTTON TEST: FAIL\n");
		else if(!(buttonBar.getChildren().get(0).isVisible()))
			result.append("LEFT-SCROLL BUTTON TEST: FAIL\n");
		else if(!(buttonBar.getChildren().get(0).isPressed()))
			result.append("LEFT-SCROLL BUTTON TEST: FAIL\n");
		else
			result.append("LEFT-SCROLL BUTTON TEST: PASS\n");
	}
	
	private void testRightScroll(GridPane buttonBar) {
		//if right-scroll button is null, disable, not visible or not pressed, fail
		if(buttonBar == null)
			result.append("RIGHT-SCROLL BUTTON TEST: FAIL\n");
		else if(buttonBar.getChildren().get(2).isDisabled())
			result.append("RIGHT-SCROLL BUTTON TEST: FAIL\n");
		else if(!(buttonBar.getChildren().get(2).isVisible()))
			result.append("RIGHT-SCROLL BUTTON TEST: FAIL\n");
		else if(!(buttonBar.getChildren().get(2).isPressed()))
			result.append("RIGHT-SCROLL BUTTON TEST: FAIL\n");
		else
			result.append("RIGHT-SCROLL BUTTON TEST: PASS\n");
	}
}
