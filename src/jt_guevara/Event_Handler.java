/* FILE: Event_Handler.java
 * DESCRIPTION: The Event_Handler class handles the overall functionality and behavior of the application. The class sets event handlers(functions) to 
 *              user interface components(gallery display, menu components, buttons) that are called in response to the user's actions.  			                         					 
 */

package jt_guevara;
import javafx.application.Platform;
import java.io.File;
import java.util.ArrayDeque;
import java.util.Iterator;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Event_Handler {
	public Event_Handler() {}//constructor
	
/*
public static void setComponents(Stage window, Main_Layout mainLayout, Gallery_Display display, Button_Layout buttonLayout, ArrayDeque<Image> imageGallery);
	PARAMETERS: Stage window - application window for implementing menu item and zoom button functions
	            Main_Layout mainLayout - layout for implementing menu item and zoom button functions
	            Gallery_Display display - gallery display for retrieving canvas nodes and implementing left-scroll and 
	                                      right-scroll buttons
	            Button_Layout buttonLayout - button layout for retrieving left-scroll, right-scroll and zoom buttons
	            ArrayDeque<Image> imageGallery - image gallery used to implement menu item, left-scroll, right-scroll and zoom buttons
	            
	                                           
	DESCRIPTION: Functionality is set to all application components(menu items, gallery display, buttons, settings) so they perform
	             actions in response to the user.
*/
	public void setComponents(Stage window, Main_Layout mainLayout, Gallery_Display display, Button_Layout buttonLayout, ArrayDeque<Image> imageGallery)
	{
		//SETTING APPLICATION COMPONENTS:
		//1.) retrieve components by declaring local objects
		//2.) set functions to components
		StackPane midCanvas = display.getMidCanvas();
		ImageView leftNode = display.getLeftNode();
		ImageView midNode = display.getMidNode();
		ImageView rightNode = display.getRightNode();
		Button leftScroll = buttonLayout.getLeftScroll();
		Button rightScroll = buttonLayout.getRightScroll();
		Button zoom = buttonLayout.getZoom();
		
		setMenuItems(mainLayout,window, imageGallery, leftNode, midNode, rightNode);
		setLeftScroll(leftScroll, imageGallery, leftNode, midNode, rightNode);
		setLeftScrollHover(leftScroll);
		setRightScroll(rightScroll, imageGallery, leftNode, midNode, rightNode);
		setRightScrollHover(rightScroll);
		setZoomButton(window,zoom, midCanvas, midNode);
		setZoomHover(zoom);
	}
	
/*
private static void setMenuItems(HBox menuBar, Stage window, ArrayDeque<Image> imageGallery, ImageView leftNode, ImageView midNode, ImageView rightNode);
	PARAMETERS: Main_Layout mainLayout - layout used to retrieve menu items 
	            Stage window, Gallery imageGallery, - application components used for setting menu items 
	            ImageView leftNode, midNode, rightNode - canvas nodes for implementing a gallery upload function for a menu item
	                           
	                    
	DESCRIPTION: Functionality is set to all menu items. Each menu item is set to execute its appropriate function when the item is clicked. Also 
	             each menu item changes color when the mouse is hovered over it and away.
*/
	
	private static void setMenuItems(Main_Layout mainLayout, Stage window, ArrayDeque<Image> imageGallery, ImageView leftNode, 
			ImageView midNode, ImageView rightNode) {
		//SET MENU ITEMS:
		//1.) retrieve menu items using the main layout by declaring local variables
		//2.) set functions to menu items
		//		a.) set mouse functions (on-click)
		//		b.) set mouse functions (on-hover)
		Text gallery = mainLayout.getMenuItem1();
		Text settings = mainLayout.getMenuItem2();
		Text exit = mainLayout.getMenuItem3();
		
		//(on click)
		gallery.setOnMouseClicked(event->uploadGallery(window, imageGallery, leftNode, midNode, rightNode));
		settings.setOnMouseClicked(event->{
			SettingsWindow win = new SettingsWindow();
			win.generateSettingsWindow(window);
			win.getWindow().show();});
		exit.setOnMouseClicked(event->Platform.exit());
		//(on hover)
		gallery.setOnMouseEntered(event->{gallery.setFill(Color.BLUE);gallery.requestFocus();});
		gallery.setOnMouseExited(event->{gallery.setFill(Color.WHITE);});
		settings.setOnMouseEntered(event->{settings.setFill(Color.BLUE);settings.requestFocus();});
		settings.setOnMouseExited(event->{settings.setFill(Color.WHITE);});
		exit.setOnMouseEntered(event->{exit.setFill(Color.BLUE);});
		exit.setOnMouseExited(event->{exit.setFill(Color.WHITE);});
		}
	
/*
private static void uploadGallery(Stage window, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
	PARAMETERS: Stage window - owner window needed to open a file explorer window through the user's operating system
	            ArrayDeque<Image> imageGallery - image gallery for adding and displaying images
	            ImageView leftNode, midNode, rightNode - canvas nodes used to upload and render images 
	                            
	DESCRIPTION: Opens a file explorer window for the user to upload images to a gallery. If user chooses images and presses 'OK', each image will
	             will be added to the gallery and each canvas will upload and display the first three images. 
	             (NOTE: Each canvas will always point to the first three gallery images aka imageGallery[0], imageGallery[1], imageGallery[2])
*/
	private static void uploadGallery(Stage window, ArrayDeque<Image> imageGallery, ImageView leftNode, ImageView midNode, ImageView rightNode)
	{
		//UPLOADING IMAGE GALLERY:
		//1.) declare a file explorer window and file list
		//2.) set file explorer window properties
		//3.) if a previous gallery was uploaded
		//		a.) clear gallery
		//		b.) set each canvas node to null
		//4.) open file explorer window, wait for user actions and store files in the list
		//5.) if user did not choose any files, return
		//6.) add files to the image gallery by going through the list
		//		a.) for every file in the list
		//			i. add file to the gallery by retrieving the URL from the user's computer
		//			ii. if file is the first, second or third in the list
		//				- set the left, mid or right canvas to display the image respectively
		
		FileChooser fc = new FileChooser();		//file explorer window to be shown
		java.util.List<File> files;				//file list to store files chosen by the user
		fc.setTitle("Select Image(s)");
		fc.getExtensionFilters().add(new ExtensionFilter("Image Files","*.jpg","*.png","*.jpeg","*bmp"));
		
		//for previously uploaded galleries, this is necessary so new images are not mixed up with previously uploaded images
		if(imageGallery.size() > 0) {
				imageGallery.clear();
				leftNode.setImage(null);
				midNode.setImage(null);
				rightNode.setImage(null);
			}
		files = fc.showOpenMultipleDialog(window);
		
		//necessary to prevent a crash
		if(files == null)
			return;
		
		//to add images, the "file:" protocol must be included in the URL
		for(int i = 0;i < files.size();++i) {
			imageGallery.add(new Image("file:" + files.get(i).getAbsolutePath()));
			if(i == 0)
				leftNode.setImage(imageGallery.getLast());
			if(i == 1)
				midNode.setImage(imageGallery.getLast());
			if(i == 2)
				rightNode.setImage(imageGallery.getLast());
		}
	}
	
/*
private static void setLeftScroll(Button leftScroll, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
    PARAMETERS: Button leftScroll - left scroll button for setting functions
                ArrayDeque<Image> imageGallery - image gallery used to implement left-scroll button 
                ImageView leftNode, midNode, rightNode - canvas node for rendering new images on each canvas when button is clicked
                             
                              
    DESCRIPTION: Functionality is set to the left-scroll button. When the user clicks the button, each canvas will display the previous image in the 
                 gallery with the right-most image being hidden from view. The last image in the gallery is moved to the front.
                 
                 (NOTE: The imageGallery will be modified with each click of the button such that the image at location imageGallery[n - 1]
                 will always be transferred to location imageGallery[0])
*/
	
	private void setLeftScroll(Button leftScroll, ArrayDeque<Image> imageGallery, ImageView leftNode, ImageView midNode, ImageView rightNode) {
		//IMPLEMENTING LEFT-SCROLL BUTTON:
		//1.)set mouse function
		//	a.) if gallery contains three images or less, disable scrolling and return
		//	b.) move last gallery image to the front
		//	c.) declare an iterator(pointer) to the front of the gallery
		//	d.) update each canvas with new images
		//  		i. set each canvas to point to and display the gallery image before it
		//				- set left canvas node to the image the iterator is currently pointing to
		//				- move iterator to the next image in the gallery
		//				- repeat for mid and right canvas
		leftScroll.setOnAction(event->{
			if(imageGallery.size() <= 3)
				return;
			
			imageGallery.addFirst(imageGallery.getLast());
			imageGallery.removeLast();
			Iterator<Image> it = imageGallery.iterator();//pointer used for traversing the gallery and updating each canvas image with each click
			leftNode.setImage(it.next());
			midNode.setImage(it.next());
			rightNode.setImage(it.next());
		});
	}
	
/*
private static void setLeftScrollHover(Button leftScroll);
    PARAMETERS: Button leftScroll - left scroll button for setting functions
    DESCRIPTION: The left-scroll button is set to change color when hovered over and change back to its default color when hovered out.
*/
	private static void setLeftScrollHover(Button leftScroll)
	{
		//change size and color of button on mouse hover
		leftScroll.setOnMouseEntered(event->{leftScroll.setStyle("-fx-background-color: blue");leftScroll.setScaleX(leftScroll.getScaleX() * 1.2);
		leftScroll.setScaleY(leftScroll.getScaleY() * 1.2);leftScroll.requestFocus();});
		leftScroll.setOnMouseExited(event->{leftScroll.setStyle("-fx-background-color: lightblue");leftScroll.setScaleX(leftScroll.getScaleX() / 1.2);
		leftScroll.setScaleY(leftScroll.getScaleY() / 1.2);});
	}
	
/*
private static void setRightScroll(Button rightScroll, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
    PARAMETERS: Button rightScroll - right scroll button for setting functions
                Gallery imageGallery - image gallery used to implement right-scroll button 
                ImageView leftNode, midNode, rightNode - canvas node for rendering new images on each canvas when button is clicked
                              
                              
    DESCRIPTION: Functionality is set to the right-scroll button. When the user clicks the button, each canvas will display the next image in the 
                 gallery with the left-most image being hidden from view. The first image in the gallery is moved to the back. 
                 
                 (NOTE: The imageGallery will be modified with each click of the button such that the image at location imageGallery[0]
                 will always be transferred to location imageGallery[n - 1])
*/
	
	private void setRightScroll(Button rightScroll, ArrayDeque<Image> imageGallery, ImageView leftNode, ImageView midNode, ImageView rightNode) {
		//IMPLEMENTING RIGHT-SCROLL BUTTON:
		//1.)set mouse function
		//	a.) if gallery contains three images or less, disable scrolling and return
		//	b.) move first gallery image to the back
		//	c.) declare an iterator(pointer) to the front of the gallery
		//	d.) update each canvas with new images
		//  		i. set each canvas to point to and display the gallery image after it
		//				- set left canvas node to the image the iterator is currently pointing to
		//				- move iterator to the next image in the gallery 
		//				- repeat for mid and right canvas
		rightScroll.setOnAction(event->{
			if(imageGallery.size() <= 3) 
				return;
			
			Iterator<Image> it = imageGallery.iterator();//pointer used for traversing the gallery and updating each canvas image with each click
			imageGallery.addLast(imageGallery.getFirst());
			it.next();
			leftNode.setImage(it.next());
			midNode.setImage(it.next());
			rightNode.setImage(it.next());
			imageGallery.removeFirst();
		});
	}
	
/*
private static void setRightScrollHover(Button rightScroll);
    PARAMETERS: Button rightScroll - right scroll button for setting functions
    DESCRIPTION: The right-scroll button is set to change color when hovered over and change back to its default color when hovered out.
*/
	
	private static void setRightScrollHover(Button rightScroll) {
		//change size and color of button on mouse hover
		rightScroll.setOnMouseEntered(event->{rightScroll.setStyle("-fx-background-color: blue");rightScroll.setScaleX(rightScroll.getScaleX() * 1.2);
		rightScroll.setScaleY(rightScroll.getScaleY() * 1.2);rightScroll.requestFocus();});
		rightScroll.setOnMouseExited(event->{rightScroll.setStyle("-fx-background-color: lightblue");rightScroll.setScaleX(rightScroll.getScaleX() / 1.2);
		rightScroll.setScaleY(rightScroll.getScaleY() / 1.2);});
	}
	
/*
private static void setZoomButton(Stage window, Button zoom, Gallery imageGallery, ImageView midImgView, StackPane midCanvas);
    PARAMETERS: Stage window - owner window for declaring a child pop-up window
                Button zoom - zoom button for setting mouse function
                StackPane midCanvas - middle canvas of gallery display used to access its node and for pop-up window calculations
                ImageView midNode - mid canvas node for applying zoom functionality
  
    DESCRIPTION: The functionality of the zoom button is set. When the user clicks the zoom button, a separate pop-up window with an enlarged image is 
                 generated and shown. If the button is clicked when the pop-up is shown, the function returns.
*/
	
	private static void setZoomButton(Stage window,Button zoom, StackPane midCanvas, ImageView midNode) {
		//IMPLEMENTING ZOOM BUTTON:
		//1.) set mouse function
		//		a.) declare pop-up window
		//		b.) if image is zoomed out(pop-up window not showing)
		//				ii. generate pop-up window of enlarged image
		//			else, return
		zoom.setOnAction(event-> {
			PopUpWindow popUpWindow = new PopUpWindow();
				if(!(popUpWindow.getWindow().isShowing())) {
					popUpWindow.generatePopUpWindow(window,midCanvas,midNode);
				}else 
					return;
			});
		}
	
/*
private static void setZoomHover(Button zoom);
    PARAMETERS: Button zoom - zoom button for setting functions
    DESCRIPTION: The zoom button is set to change color when hovered over and change back to its default color when hovered out.
*/
	private static void setZoomHover(Button zoom) {
		//change size and color of button on mouse hover
		zoom.setOnMouseEntered(event->{zoom.setStyle("-fx-background-color: blue");zoom.setScaleX(zoom.getScaleX() * 1.2);
		zoom.setScaleY(zoom.getScaleY() * 1.2);zoom.requestFocus();});
		zoom.setOnMouseExited(event->{zoom.setStyle("-fx-background-color: lightblue");zoom.setScaleX(zoom.getScaleX() / 1.2);
		zoom.setScaleY(zoom.getScaleY() / 1.2);});
	}
}