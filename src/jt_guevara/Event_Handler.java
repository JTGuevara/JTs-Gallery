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
 *               to the right to simulate a left scrolling motion. 
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
 *               switch one position to the left to simulate a right scrolling motion.
 * 
 * 		
 *    private static void set_zoom(Button zoom, Gallery imageGallery, ImageView midImgView, StackPane midCanvas);
 *       PARAMETERS: Button zoom - zoom button used to set event handler
 *                   StackPane midCanvas - middle canvas of gallery display used to access its image view
 *                   ImageView midImgView - image view for applying zoom functionality
 * 
 *       RESULT: Functionality is set to the zoom button. When the user clicks the button, the center image enlarges if it is 
 *               zoomed out and shrinks if it is zoomed in						 
 */

package jt_guevara;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Event_Handler {
	public Event_Handler() {}
	private static boolean zoomStatus = false;//boolean used in zoom function
	
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
		menuBar.getChildren().get(0).setOnMouseClicked(event->load_gallery(window, imageGallery, leftImgView, midImgView, rightImgView));
		menuBar.getChildren().get(1).setOnMouseClicked(event->Platform.exit());
		load_buttons(layout,imageGallery, mid_canvas, leftImgView, midImgView, rightImgView);
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
		
		//array list used to store file and directory paths from user
		java.util.List<File> files = fc.showOpenMultipleDialog(window);
		
		//check if user does not choose any files and clicks exit
		if(files == null)
			return;
		
		//add images to the gallery by 
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
	
	private static void load_UI_buttons(GridPane p, Gallery imageGallery, StackPane midCanvas, ImageView leftImgView, ImageView midImgView, ImageView rightImgView)
	{
		//local variables needed to access user interface buttons
		GridPane UI_Pane = (GridPane) p.getChildren().get(3);
		Button leftScroll = (Button) UI_Pane.getChildren().get(0);
		Button rightScroll = (Button) UI_Pane.getChildren().get(2);
		Button zoom = (Button) UI_Pane.getChildren().get(1);
		set_left_scroll(leftScroll, imageGallery, leftImgView, midImgView, rightImgView);
		set_right_scroll(rightScroll, imageGallery, leftImgView, midImgView, rightImgView);
		set_zoom(zoom,midImgView, midCanvas);
	}
	
	
	private static void set_left_scroll(Button leftScroll, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView) {
		leftScroll.setOnAction(new EventHandler<ActionEvent>() {
			//temporary images used to maintain order of the image gallery when scrolling
			Image temp1, temp2;
			@Override
			public void handle(ActionEvent event) {
				//disable scrolling when the gallery has less than 3 images 
				if(imageGallery.getSize() < 3)
					return;
				
				//series of statements to swap gallery images in the deque and shift them one position over 
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
	}
	
	
	private static void set_right_scroll(Button rightScroll, Gallery imageGallery, ImageView leftImgView, ImageView midImgView, ImageView rightImgView) {
		rightScroll.setOnAction(new EventHandler<ActionEvent>() {
			//temporary images used to maintain the order of the image gallery when scrolling
			Image temp1, temp2, temp3;
			@Override
			public void handle(ActionEvent event) {
				//disable scrolling when the gallery has less than 3 images
				if(imageGallery.getSize() < 3) 
					return;
				
				//series of statements to swap gallery images in the deque and shift them one position over 
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
	}
	
	private static void set_zoom(Button zoom, ImageView midImgView, StackPane midCanvas) {
		zoom.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//an image in a zoomed-in state is enlarged by 50%; an image in a zoomed-out state is shrunk by 50%
				if(zoomStatus == false) {
					zoomStatus = true;
					midCanvas.setMaxWidth(midCanvas.getMaxWidth() * 1.5);
					midCanvas.setMaxHeight(midCanvas.getMaxHeight() * 1.5);
					midImgView.maxWidth(midImgView.getFitWidth() * 1.5);
					midImgView.maxHeight(midImgView.getFitHeight() * 1.5);
				}
				else {
					zoomStatus = false;
					midCanvas.setMaxWidth(midCanvas.getMaxWidth() / 1.5);
					midCanvas.setMaxHeight(midCanvas.getMaxHeight() / 1.5);
					midImgView.maxWidth(midImgView.getFitWidth() / 1.5);
					midImgView.maxHeight(midImgView.getFitHeight() / 1.5);
				}
			}
		});
	}
	
}

