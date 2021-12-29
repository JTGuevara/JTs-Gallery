/* FILE: Event_Handler.java
 * DESCRIPTION: The Event_Handler class handles the overall functionality and behavior of the application. The class sets event handlers(functions) to 
 *              user interface components(gallery display, menu components, buttons) that are called in response to the user's actions  		                         					 
 */

package jt_guevara;
import javafx.application.Platform;
import java.io.File;
import java.util.ArrayDeque;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Event_Handler {
	public Event_Handler() {}
	private static boolean zoomState = false;//used to track the zoom state of the center image
	private static Stage popup = new Stage();//pop-up window for zoomed image
	
/*
public static void setComponents(Stage window, GridPane layout, Gallery imageGallery);
	PARAMETERS: Stage window - required JavaFX window used to set event handlers to menu items
	            GridPane layout - main layout container used to access application components(gallery display, canvases) for setting functions to them
	            ArrayDeque<Image> imageGallery - image gallery representing a collection of images; used to set menu item function for uploading images
	                                           
	DESCRIPTION: Functionality is set to all application components(menu items, gallery display, buttons, settings) so they perform the specified action 
	             when clicked by the user
*/
	
	public void setComponents(Stage window, GridPane layout, ArrayDeque<Image> imageGallery)
	{
		//local variables for accessing application components
		HBox menuBar = (HBox) layout.getChildren().get(0);
		GridPane display = (GridPane) layout.getChildren().get(1);
		StackPane left_canvas = (StackPane) display.getChildren().get(0);
		StackPane mid_canvas = (StackPane) display.getChildren().get(1);
		StackPane right_canvas = (StackPane) display.getChildren().get(2);
		ImageView leftImgView = (ImageView) left_canvas.getChildren().get(0);
		ImageView midImgView = (ImageView) mid_canvas.getChildren().get(0);
		ImageView rightImgView = (ImageView) right_canvas.getChildren().get(0);
		//set functions to menu items
		setMenuItems(menuBar,window, imageGallery, leftImgView, midImgView, rightImgView);
		setButtons(window,layout,imageGallery, mid_canvas, leftImgView, midImgView, rightImgView);
	}
	
/*
private static void setMenuItems(HBox menuBar, Stage window, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
	PARAMETERS: HBox menuBar - menu bar for setting functions to and accessing specific menu items  
	            Stage window, Gallery imageGallery, - application components used for setting menu items 
	            ImageView leftImgView, midImgView, rightImgView - objects for implementing a gallery upload function for a menu item
	                           
	                    
	DESCRIPTION: Functionality is set to all menu items. Each menu item is set to execute its appropriate function when the item is clicked. Also 
	             each menu item changes color when the mouse is hovered over it and away.
*/
	
	private static void setMenuItems(HBox menuBar, Stage window, ArrayDeque<Image> imageGallery, ImageView leftImgView, 
			ImageView midImgView, ImageView rightImgView) {
		//local variables to access menu items
		Text gallery = (Text) menuBar.getChildren().get(0);
		Text settings = (Text) menuBar.getChildren().get(1);
		Text exit = (Text) menuBar.getChildren().get(2);
		//set functions to menu items
		//(on click)
		gallery.setOnMouseClicked(event->load_gallery(window, imageGallery, leftImgView, midImgView, rightImgView));
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
private static void load_gallery(Stage window, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
	PARAMETERS: Stage window - Stage parameter used to open a file explorer screen through the user's operating system
	            ArrayDeque<Image> imageGallery - image gallery containing images to be displayed 
	            ImageView leftImgView, midImgView, rightImgView - ImageView objects used to render images on the application 
	                            
	DESCRIPTION: Sets the menu item 'Gallery' to open a file explorer window for the user for uploading images to an image gallery when the item
	             is clicked. On window confirmation, the first three images of the gallery are displayed to the user. On window cancellation, 
	             the file explorer window is closed.
*/
	private static void load_gallery(Stage window, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView)
	{
		//clear any previous image galleries, if any
		if(imageGallery.size() > 0) {
			imageGallery.clear();
			leftImgView.setImage(null);
			midImgView.setImage(null);
			rightImgView.setImage(null);
		}
		
		
		//file explorer window for user, filtered to only image files
		FileChooser fc = new FileChooser();
		fc.setTitle("Select Image(s)");
		fc.getExtensionFilters().add(new ExtensionFilter("Image Files","*.jpg","*.png","*.jpeg"));
		
		//set initial directory - (created for testing purposes, change directory for your specific system but disable when not needed or program will fail)
		fc.setInitialDirectory(new File("C:/Users/Joan/Documents/Programs/Git Projects/JTs-Gallery/src/jt_guevara/test/"));
		
		//temporary array list used to store user file/directory paths 
		java.util.List<File> files = fc.showOpenMultipleDialog(window);
		
		//check if user does not choose any files and clicks exit
		if(files == null)
			return;
		
		//add images to the gallery, set the first three images in the image deque to be displayed to user
		for(int i = 0;i < files.size();++i) {
			imageGallery.add(new Image("file:" + files.get(i).getAbsolutePath()));
			if(i == 0)
				leftImgView.setImage(imageGallery.getLast());
			if(i == 1)
				midImgView.setImage(imageGallery.getLast());
			if(i == 2)
				rightImgView.setImage(imageGallery.getLast());
			}
	}
	
/*
private static void setButtons(GridPane layout, ArrayDeque<Image> imageGallery, StackPane midCanvas, ImageView leftImgView, ImageView midImgView, 
                               ImageView rightImgView);
    PARAMETERS: GridPane layout - main layout container for retrieving button interface and buttons
                ArrayDeque<Image> imageGallery - image gallery for setting event handlers to buttons
                StackPane midCanvas - gallery display canvas for setting zoom function
                ImageView leftImgView, midImgView, rightImgview- ImageView objects for setting functions to scroll buttons
                               
                              
    DESCRIPTION: Functionality is set to the left-scroll, right-scroll and zoom buttons.
*/
	private void setButtons(Stage window,GridPane layout, ArrayDeque<Image> imageGallery, StackPane midCanvas, ImageView leftImgView, ImageView midImgView, ImageView rightImgView)
	{
		//local variables needed to access user interface buttons
		GridPane buttonBar = (GridPane) layout.getChildren().get(2);
		Button leftScroll = (Button) buttonBar.getChildren().get(0);
		Button rightScroll = (Button) buttonBar.getChildren().get(2);
		Button zoom = (Button) buttonBar.getChildren().get(1);
		setLeftScroll(leftScroll, imageGallery, leftImgView, midImgView, rightImgView);
		setRightScroll(rightScroll, imageGallery, leftImgView, midImgView, rightImgView);
		setZoomButton(window,zoom,midImgView, midCanvas, layout);
	}
	
/*
private static void setLeftScrollButton(Button leftScroll, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
    PARAMETERS: Button leftScroll - left scroll button 
                ArrayDeque<Image> imageGallery - image gallery used to set behavior of left-scroll button 
                ImageView leftImgView, midImgView, rightImgView - ImageView objects for rendering new images on display canvases when scrolled
                             
                              
    DESCRIPTION: Functionality is set to the left-scroll button. When the user clicks the button, each image displayed will shift one position to the right.
                 The left-most image is cleared and a new image from the queue is displayed with the right-most image being cleared and hidden from view.
*/
	
	private void setLeftScroll(Button leftScroll, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView) {
		leftScroll.setOnAction(new EventHandler<ActionEvent>() {
			//temporary images used to maintain order of the image gallery when scrolling
			Image temp1, temp2;
			@Override
			public void handle(ActionEvent event) {
				//disable scrolling when the gallery has less than 3 images 
				if(imageGallery.size() < 3)
					return;
				
				//shift each image in array one position over to simulate scroll 
				temp1 = imageGallery.getLast();
				imageGallery.removeLast();
				temp2 = imageGallery.getFirst();
				imageGallery.removeFirst();
				rightImgView.setImage(imageGallery.getFirst());
				imageGallery.addFirst(temp2);
				midImgView.setImage(temp2);
				imageGallery.addFirst(temp1);
				leftImgView.setImage(temp1);
			}
		});
		
		setLeftScrollHover(leftScroll);
	}
	
	/*
	 private static void setLeftScrollHover(Button leftScroll);
        PARAMETERS: Button leftScroll - left scroll button for applying hovering behavior
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
private static void setRightScrollButton(Button rightScroll, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
    PARAMETERS: Button rightScroll - right scroll button 
                Gallery imageGallery - image gallery used to set behavior of right-scroll button 
                ImageView leftImgView, midImgView, rightImgView - ImageView objects for rendering new images on the canvas when scrolled
                              
                              
    DESCRIPTION: Functionality is set to the right-scroll button. When the user clicks the button, each image displayed will shift one position 
                 to the left. The right-most image is cleared and a new image from the queue is displayed with the left-most image being cleared 
                 and hidden from view.  
*/
	
	private void setRightScroll(Button rightScroll, ArrayDeque<Image> imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView) {
		rightScroll.setOnAction(new EventHandler<ActionEvent>() {
			//temporary images used to maintain the order of the image gallery when scrolling(scrolling right is slightly different than scrolling left)
			Image temp1, temp2, temp3;
			@Override
			public void handle(ActionEvent event) {
				//disable scrolling when the gallery has less than 3 images
				if(imageGallery.size() < 3) 
					return;
				
				//shift each image in array one position over to simulate scroll 
				temp1 = imageGallery.getFirst();
				imageGallery.removeFirst();
				imageGallery.addLast(temp1);
				temp2 = imageGallery.getFirst();
				imageGallery.removeFirst();
				temp3 = imageGallery.getFirst();
				imageGallery.removeFirst();
				
				
				rightImgView.setImage(imageGallery.getFirst());
				imageGallery.addFirst(temp3);
				midImgView.setImage(imageGallery.getFirst());
				imageGallery.addFirst(temp2);
				leftImgView.setImage(imageGallery.getFirst());
			}
		});
		
		setRightScrollHover(rightScroll);
	}
	
/*
private static void setRightScrollHover(Button rightScroll);
    PARAMETERS: Button rightScroll - right scroll button for applying hovering behavior
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
                Button zoom - zoom button used to set event handler
                StackPane midCanvas - middle canvas of gallery display used to access its image view
                ImageView midImgView - image view for applying zoom functionality
  
    DESCRIPTION: The zoom button is set to perform an action. When the user clicks the zoom button, the center image enlarges if it is zoomed out by 
                 opening a new pop-up window and rendering an enlarged image in the center of the application screen. When clicked again, the pop-up 
                 window closes.
*/
	
	private static void setZoomButton(Stage window,Button zoom, ImageView midImgView, StackPane midCanvas, GridPane layout) {
		
		zoom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//if image is zoomed out(zoomState = false), enlarge it by 30% by opening a pop-up window
				//if image is zoomed in(zoomState = true), close pop-up window
				if(zoomState == false) {
					zoomState = true;
					//declare necessary JavaFX nodes for pop-up window
					Pane p = new Pane();
					ImageView zoomedImage = new ImageView();
					Scene s = new Scene(p,midCanvas.getWidth() * 1.3,midCanvas.getHeight() * 1.3);
					//set up pop-up window
					popup.setWidth(midCanvas.getWidth() * 1.3);
					popup.setHeight(midCanvas.getHeight() * 1.27);
					zoomedImage.fitWidthProperty().bind(popup.widthProperty());
					zoomedImage.fitHeightProperty().bind(popup.heightProperty());
					zoomedImage.setImage(midImgView.getImage());
					p.getChildren().add(zoomedImage);
					//place pop-up window in the center of the application screen
					popup.setX(window.getX() + window.getWidth() / 2 - popup.getWidth() / 2);
					popup.setY(window.getY() + (window.getHeight() / 2 - popup.getHeight() / 2) * 0.4);
					popup.setScene(s);
					popup.show();
				}
				else {
					zoomState = false;
					popup.close();
				}
			}
		});
		
		setZoomHover(zoom);
	}
	
/*
private static void setZoomHover(Button zoom);
    PARAMETERS: Button zoom - zoom button for applying hovering behavior
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

