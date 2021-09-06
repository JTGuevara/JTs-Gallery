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

public class Automated_Test {

}
