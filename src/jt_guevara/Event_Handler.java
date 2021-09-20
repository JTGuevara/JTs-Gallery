/* FILE: Event_Handler.java
 * DESCRIPTION: 
 *    The Event_Handler class handles the overall functionality and behavior of the application. The class sets event handlers(functions) to user interface 
 *    components(gallery display, menu, buttons) that are called in response to the user's actions 
 * 
 * FUNCTIONS:
 *    public static void load_event_handlers(Stage window, GridPane layout, Gallery imageGallery);
 *       PARAMETERS: Stage window - Stage parameter used to set event handlers to menu items
 *                   GridPane layout - main layout container used to access sub-components(gallery display, canvases) for setting functions to them
 *                   Gallery imageGallery - Gallery object representing a collection of images; used to set the event handler for the load_gallery() 
 *                                          helper function 
 *                                          
 *       RESULT: Event functionality is set to all application components(menu items, gallery display, buttons) so they perform the specified action when 
 *               clicked by the user
 *               
 * 
 *    private static void set_menu_items(HBox menuBar, Stage window, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
 *       PARAMETERS: HBox menuBar - menu bar for setting functions to menu items 
 *                   Stage window, Gallery imageGallery, - window and gallery components used to set a function to a specific menu item for uploading a gallery  
 *                   ImageView leftImgView, midImgView, 
 *                   rightImgView
 *                   
 *       RESULT: Functionality is set to all menu items. Each menu item is set to execute its appropriate function when the item is clicked. Also each menu item
 *               changes color when the mouse is hovered over it.
 * 
 * 
 *    private static void load_gallery(Stage window, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
 *       PARAMETERS: Stage window - Stage parameter used to open a file dialog screen through the user's operating system
 *                   Gallery imageGallery - Gallery object used to add and clear images via activating the menu item
 *                   ImageView leftImgView, - ImageView objects used to render images on the application window by manipulating the Gallery
 *                             midImgView,
 *                             rightImgView
 * 
 *       RESULT: Functionality is set to the menu item, 'Load Gallery'. When the user activates the menu item, a file dialog window appears on the user's
 *               system, prompting the user to choose image files from their directory. The image files are then placed inside the Gallery. Depending on 
 *               the user's choice, the three image views(leftImgView, midImgView, rightImgView) will access the Gallery, set and render the first three 
 *               images on the screen. 
 * 
 * 		
 *    private static void load_buttons(GridPane layout, Gallery imageGallery, StackPane midCanvas, ImageView leftImgView, ImageView midImgView, 
 *                  ImageView rightImgView);
 *       PARAMETERS: GridPane layout - main layout container for retrieving button bar and buttons
 *                   Gallery imageGallery - Gallery object for setting event handlers to buttons
 *                   StackPane midCanvas - sub-component of gallery display for setting zoom function
 *                   ImageView leftImgView, - ImageView objects for setting functions to scroll buttons
 *                             midImgView,
 *                             rightImgView
 * 
 *       RESULT: Functionality is set to the left-scroll, right-scroll and zoom buttons.
 * 
 * 
 * 		
 *    private static void set_left_scroll(Button leftScroll, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
 *       PARAMETERS: Button leftScroll - left scroll button used to set event handler
 *                   Gallery imageGallery - Gallery object for scrolling images
 *                   ImageView leftImgView, - ImageView objects for rendering new images from the Gallery when scrolled
 *                             midImgView,
 *                             rightImgView
 * 
 *       RESULT: Functionality is set to the left-scroll button. When the user clicks the button, the images viewed on the canvas will switch one position 
 *               to the right to simulate a left scrolling motion. Also, the button changes size and color from default when hovered over and back to default 
 *               when hovered out.
 * 
 * 
 *    private static void set_right_scroll(Button rightScroll, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView);
 *       PARAMETERS: Button leftScroll - right scroll button used to set scrolling function
 *                   Gallery imageGallery - Gallery object for scrolling images
 *                   ImageView leftImgView, - ImageView objects for rendering new images from the Gallery when scrolled
 *                             midImgView,
 *                             rightImgView
 * 
 *       RESULT: Functionality is set to the right-scroll button. When the user clicks the button, the images viewed on the canvas will 
 *               switch one position to the left to simulate a right scrolling motion. Also, the button changes size and color from default when hovered 
 *               over and back to default when hovered out.
 * 
 * 
 *    private static void set_zoom(Button zoom, Gallery imageGallery, ImageView midImgView, StackPane midCanvas);
 *       PARAMETERS: Button zoom - zoom button used to set event handler
 *                   StackPane midCanvas - middle canvas of gallery display used to access its image view
 *                   ImageView midImgView - image view for applying zoom functionality
 * 
 *       RESULT: Functionality is set to the zoom button. When the user clicks the button, the center image enlarges if it is 
 *               zoomed out and shrinks if it is zoomed in. Also, the button changes size and color from default when hovered over 
 *               and back to default when hovered out.					 
 */

package jt_guevara;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Platform;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;
import javafx.stage.Stage;

public class Event_Handler {
	public Event_Handler() {}
	private static boolean zoomState = false;//used to track the zoom state of the center image
	private static Timeline zoomIn = new Timeline();
	private static Timeline zoomOut = new Timeline();
	
	
	public void load_event_handlers(Stage window, GridPane layout, Gallery imageGallery)
	{
		//local variables needed to access user interface components
		HBox menuBar = (HBox) layout.getChildren().get(0);
		GridPane display = (GridPane) layout.getChildren().get(1);
		StackPane left_canvas = (StackPane) display.getChildren().get(0);
		StackPane mid_canvas = (StackPane) display.getChildren().get(1);
		StackPane right_canvas = (StackPane) display.getChildren().get(2);
		ImageView leftImgView = (ImageView) left_canvas.getChildren().get(0);
		ImageView midImgView = (ImageView) mid_canvas.getChildren().get(0);
		ImageView rightImgView = (ImageView) right_canvas.getChildren().get(0);
		System.out.println(layout.toString());
		//set functions to menu items
		set_menu_items(menuBar,window, imageGallery, leftImgView, midImgView, rightImgView);
		load_buttons(layout,imageGallery, mid_canvas, leftImgView, midImgView, rightImgView);
	}
	
	
	private static void set_menu_items(HBox menuBar, Stage window, Gallery imageGallery, ImageView leftImgView, 
			ImageView midImgView, ImageView rightImgView) {
		//local variables to access menu items
		Text gallery = (Text) menuBar.getChildren().get(0);
		Text exit = (Text) menuBar.getChildren().get(1);
		//set click functions
		gallery.setOnMouseClicked(event->load_gallery(window, imageGallery, leftImgView, midImgView, rightImgView));
		exit.setOnMouseClicked(event->Platform.exit());
		//set menu items to change color on hover
		gallery.setOnMouseEntered(event->{gallery.setFill(Color.BLUE);gallery.requestFocus();});
		gallery.setOnMouseExited(event->{gallery.setFill(Color.WHITE);});
		exit.setOnMouseEntered(event->{exit.setFill(Color.BLUE);});
		exit.setOnMouseExited(event->{exit.setFill(Color.WHITE);});
		}
	
	
	private static void load_gallery(Stage window, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView)
	{
		//check to see if a previous gallery was loaded by user and should be cleared for the new one 
		if(imageGallery.getSize() > 0)
			imageGallery.clearGallery();
		
		
		//file dialog screen for user filtered to choose only image files
		FileChooser fc = new FileChooser();
		fc.setTitle("Select Image(s)");
		fc.getExtensionFilters().add(new ExtensionFilter("Image Files","*.jpg","*.png","*.jpeg"));
		
		//set initial directory - (created for testing purposes, change directory for your specific system but disable when not needed or program will fail)
		fc.setInitialDirectory(new File("C:/Users/Joan/Documents/Programs/Git Projects/JTs-Gallery/src/jt_guevara/test/"));
		
		//array list used to store file and directory paths from user
		java.util.List<File> files = fc.showOpenMultipleDialog(window);
		
		//check if user does not choose any files and clicks exit
		if(files == null)
			return;
		
		//add images to the gallery, set the first three images in the image array to be displayed
		for(int i = 0;i < files.size();++i) {
			imageGallery.addImage(new Image("file:" + files.get(i).getAbsolutePath()));
			if(i == 0)
				leftImgView.setImage(imageGallery.getImages().getLast());
			if(i == 1)
				midImgView.setImage(imageGallery.getImages().getLast());
			if(i == 2)
				rightImgView.setImage(imageGallery.getImages().getLast());
			}
	}

	
	private void load_buttons(GridPane layout, Gallery imageGallery, StackPane midCanvas, ImageView leftImgView, ImageView midImgView, ImageView rightImgView)
	{
		//local variables needed to access user interface buttons
		GridPane buttonBar = (GridPane) layout.getChildren().get(2);
		Button leftScroll = (Button) buttonBar.getChildren().get(0);
		Button rightScroll = (Button) buttonBar.getChildren().get(2);
		Button zoom = (Button) buttonBar.getChildren().get(1);
		set_left_scroll(leftScroll, imageGallery, leftImgView, midImgView, rightImgView);
		set_right_scroll(rightScroll, imageGallery, leftImgView, midImgView, rightImgView);
		set_zoom(zoom,midImgView, midCanvas, layout);
	}
	
	
	private void set_left_scroll(Button leftScroll, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView) {
		leftScroll.setOnAction(new EventHandler<ActionEvent>() {
			//temporary images used to maintain order of the image gallery when scrolling
			Image temp1, temp2;
			@Override
			public void handle(ActionEvent event) {
				//disable scrolling when the gallery has less than 3 images 
				if(imageGallery.getSize() < 3)
					return;
				
				//shift each image in array one position over to simulate scroll 
				temp1 = imageGallery.getImages().getLast();
				imageGallery.getImages().removeLast();
				temp2 = imageGallery.getImages().getFirst();
				imageGallery.getImages().removeFirst();
				rightImgView.setImage(imageGallery.getImages().getFirst());
				imageGallery.getImages().addFirst(temp2);
				midImgView.setImage(temp2);
				imageGallery.getImages().addFirst(temp1);
				leftImgView.setImage(temp1);
			}
		});
		
		//change size and color of button on mouse hover
		leftScroll.setOnMouseEntered(event->{leftScroll.setStyle("-fx-background-color: blue");leftScroll.setScaleX(leftScroll.getScaleX() * 1.2);
			leftScroll.setScaleY(leftScroll.getScaleY() * 1.2);leftScroll.requestFocus();});
		leftScroll.setOnMouseExited(event->{leftScroll.setStyle("-fx-background-color: white");leftScroll.setScaleX(leftScroll.getScaleX() / 1.2);
			leftScroll.setScaleY(leftScroll.getScaleY() / 1.2);});
	}
	
	
	private void set_right_scroll(Button rightScroll, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView) {
		rightScroll.setOnAction(new EventHandler<ActionEvent>() {
			//temporary images used to maintain the order of the image gallery when scrolling(scrolling right is slightly different than scrolling left)
			Image temp1, temp2, temp3;
			@Override
			public void handle(ActionEvent event) {
				//disable scrolling when the gallery has less than 3 images
				if(imageGallery.getSize() < 3) 
					return;
				
				//shift each image in array one position over to simulate scroll 
				temp1 = imageGallery.getImages().getFirst();
				imageGallery.getImages().removeFirst();
				imageGallery.getImages().addLast(temp1);
				temp2 = imageGallery.getImages().getFirst();
				imageGallery.getImages().removeFirst();
				temp3 = imageGallery.getImages().getFirst();
				imageGallery.getImages().removeFirst();
				
				
				rightImgView.setImage(imageGallery.getImages().getFirst());
				imageGallery.getImages().addFirst(temp3);
				midImgView.setImage(imageGallery.getImages().getFirst());
				imageGallery.getImages().addFirst(temp2);
				leftImgView.setImage(imageGallery.getImages().getFirst());
			}
		});
		
		//change size and color of button on mouse hover
		rightScroll.setOnMouseEntered(event->{rightScroll.setStyle("-fx-background-color: blue");rightScroll.setScaleX(rightScroll.getScaleX() * 1.2);
			rightScroll.setScaleY(rightScroll.getScaleY() * 1.2);rightScroll.requestFocus();});
		rightScroll.setOnMouseExited(event->{rightScroll.setStyle("-fx-background-color: white");rightScroll.setScaleX(rightScroll.getScaleX() / 1.2);
			rightScroll.setScaleY(rightScroll.getScaleY() / 1.2);});
	}
	
	
	private static void set_zoom(Button zoom, ImageView midImgView, StackPane midCanvas, GridPane layout) {
		//define and set zoom animations 
		zoomIn.setCycleCount(1);
		zoomIn.getKeyFrames().add(new KeyFrame(Duration.seconds(0),
				new KeyValue(midCanvas.maxWidthProperty(),midCanvas.getMaxWidth()),
				new KeyValue(midCanvas.maxHeightProperty(),midCanvas.getMaxHeight())));
		zoomIn.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1),
				new KeyValue(midCanvas.maxWidthProperty(),midCanvas.getMaxWidth() * 1.7),
				new KeyValue(midCanvas.maxHeightProperty(),midCanvas.getMaxHeight() * 1.7)));
		
		zoomOut.setCycleCount(1);
		zoomOut.getKeyFrames().add(new KeyFrame(Duration.seconds(0),
				new KeyValue(midCanvas.maxWidthProperty(),midCanvas.getMaxWidth() * 1.7),
				new KeyValue(midCanvas.maxHeightProperty(),midCanvas.getMaxHeight() * 1.7)));
		zoomOut.getKeyFrames().add(new KeyFrame(Duration.seconds(0.1),
				new KeyValue(midCanvas.maxWidthProperty(),midCanvas.getMaxWidth()),
				new KeyValue(midCanvas.maxHeightProperty(),midCanvas.getMaxHeight())));
		zoom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//an image in a zoomed-in state is enlarged by 70%; an image in a zoomed-out state is shrunk by 70%
				if(zoomState == false) {
					zoomState = true;
					zoomIn.play();
				}
				else
				{
					zoomState = false;
					zoomOut.play();
				}
			}
		});
		
		//change size and color of button on mouse hover
		zoom.setOnMouseEntered(event->{zoom.setStyle("-fx-background-color: blue");zoom.setScaleX(zoom.getScaleX() * 1.2);
			zoom.setScaleY(zoom.getScaleY() * 1.2);zoom.requestFocus();});
		zoom.setOnMouseExited(event->{zoom.setStyle("-fx-background-color: white");zoom.setScaleX(zoom.getScaleX() / 1.2);
			zoom.setScaleY(zoom.getScaleY() / 1.2);});
	}
}

