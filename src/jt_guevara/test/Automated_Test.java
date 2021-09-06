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
 *         in a frame. The images used are sample images located in the project's directory. The initial test ends when the application is 
 *         maximized to full-screen mode and the button test executes. 
 *         
 *         
 *  public void moveMousePointer(Robot testBot, double x1, double x2, double y1, double y2);
 *      PARAMETERS: Robot testBot - robot class for moving mouse pointer
 *                  double x1,y1 - previous mouse coordinates
 *                  double x2,y2 - destination mouse coordinates
 *      DESCRIPTION: Automates a movement of the mouse pointer from point(x1,y1) to point(x2,y2) by moving the mouse pointer n times
 *      
 *  
 *  public void button_test(Robot testBot, Stage window);
 *      PARAMETERS: Robot testBot - robot class for automating button tests
 *                  Stage window - window parameter for obtaining mouse coordinates relative to the user's monitor
 *                  
 *      DESCRIPTION: Starts automated button test. Uses a robot to simulate a user clicking on the button interface on the lower portion of 
 *         the screen. The test consists of a series of animations where each mouse movement and click is recorded in a frame. The button 
 *         test ends when the application is minimized and exited.
 */
package jt_guevara.test;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.robot.Robot;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Automated_Test {
	public void initialize_test(Robot testBot, Stage window) throws InterruptedException {
		double x = testBot.getMouseX();//get current mouse coordinates
		double y = testBot.getMouseY();
		Timeline t = new Timeline( //execute animation (
			new KeyFrame(Duration.ZERO, event -> {moveMousePointer(testBot,x,x,y,y);}),
			new KeyFrame(Duration.seconds(0.5), event -> {moveMousePointer(testBot,x,x + 30,y,y + 50);}), //upload gallery 
			new KeyFrame(Duration.seconds(1), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(1.5), event -> {moveMousePointer(testBot,x + 20,x + 150,y + 50,y + 250);}),//click on images in file-chooser
			new KeyFrame(Duration.seconds(2), event -> {testBot.keyPress(KeyCode.CONTROL);}),
			new KeyFrame(Duration.seconds(2), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(2.3), event -> {moveMousePointer(testBot,x + 150, x + 300,y + 250, y + 250);}),
			new KeyFrame(Duration.seconds(2.6), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(2.9), event -> {moveMousePointer(testBot,x + 300, x + 450,y + 250, y + 250);}),
			new KeyFrame(Duration.seconds(3.3), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(3.5), event -> {testBot.keyRelease(KeyCode.CONTROL);}),
			new KeyFrame(Duration.seconds(3.9), event -> {moveMousePointer(testBot,x + 450, x + 800,y + 250, y + 580);}),//click open to close file
			new KeyFrame(Duration.seconds(4), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(4.5), event -> {button_test(testBot, window);}) //starts button test
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
	
	public void button_test(Robot testBot, Stage window) {
		double x = testBot.getMouseX();//get current mouse coordinates
		double y = testBot.getMouseY();
		
		Timeline t = new Timeline( //execute animation 
			new KeyFrame(Duration.ZERO, event -> {moveMousePointer(testBot,x,x,y,y);}),	
			new KeyFrame(Duration.seconds(0.5), event -> {moveMousePointer(testBot,x,x - 50,y,y - 570);}),//navigate to maximize to full-screen
			new KeyFrame(Duration.seconds(0.9), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(1.7), event -> {moveMousePointer(testBot,x - 50,window.getWidth() / 2,y - 570,window.getHeight() / 1.2);}),//navigate to buttons
			new KeyFrame(Duration.seconds(2.3), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(2.9), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(3.5), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(4.1), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(4.7), event -> {moveMousePointer(testBot,testBot.getMouseX(),testBot.getMouseX() + 100,y + 160,y + 160);}),//move to right-scroll
			new KeyFrame(Duration.seconds(5.6), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(6.2), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(6.9), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(7.5), event -> {moveMousePointer(testBot,testBot.getMouseX(),testBot.getMouseX() - 230,y + 160,y + 160);}),//move to left-scroll
			new KeyFrame(Duration.seconds(8.1), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(8.7), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(9.3), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(9.7), event -> {moveMousePointer(testBot,testBot.getMouseX() - 230,window.getWidth() - 100,y + 160,10);}),//navigate to minimize screen
			new KeyFrame(Duration.seconds(9.9), event -> {testBot.mouseClick(MouseButton.PRIMARY);}),
			new KeyFrame(Duration.seconds(10.4), event -> {moveMousePointer(testBot,testBot.getMouseX() - 100,window.getX() + 70, window.getY(),window.getY() + 50);}),//navigate to exit
			new KeyFrame(Duration.seconds(10.8), event -> {testBot.mouseClick(MouseButton.PRIMARY);})
			);
		t.setCycleCount(1);
		t.play();
	}
}
