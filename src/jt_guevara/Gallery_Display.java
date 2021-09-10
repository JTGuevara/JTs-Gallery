/* FILE: Gallery_Display.java
 * CLASS DESCRIPTION: The Gallery_Display class is the visual representation of the image gallery. A Gallery_Display consists of four components: 
 *                   a display component(or wall) for holding image canvases, a left canvas, a middle canvas and a right canvas	
 * 
 * FUNCTIONS:
 *    public Gallery_Display();
 *        DESCRIPTION: Declares an empty Gallery_Display by initializing a display(GridPane)
 *        
 *        
 *    public GridPane getDisplay();
 *        DESCRIPTION: Returns the display
 *        
 *    
 *    public StackPane getLeftCanvas(), getMidCanvas(), getRightCanvas();
 *        DESCRIPTION: These three functions return the left canvas, mid canvas and right canvas respectively
 *        
 *    public void setup_gallery();
 *        DESCRIPTION: Sets up gallery by setting style properties to the gallery display, setting style properties for each image canvas, 
 *                     applying an image view to each canvas as well as adding all canvases to the display. To do this, setup_gallery() calls 
 *                     the following private functions to accomplish its task: set_image_canvas(), set_image_view(), add_image_canvases() 
 *                     
 *                     
 *    private void set_gallery_style();
 *        DESCRIPTION: The gallery display has its style properties set
 *        
 *        
 *    private void set_image_canvas(StackPane canvas);
 *        PARAMETER: StackPane canvas - image canvas used to set style properties
 *        DESCRIPTION: Modifies and styles the image canvas
 *        
 *        
 *    private void set_image_view(StackPane canvas);
 *        PARAMETER: StackPane canvas - image canvas used for adding an image view component
 *        DESCRIPTION: Initializes an image view component(ImageView) and sets its properties. The image view is then binded and added
 *                     to the canvas.
 *    
 *    
 *    private void add_image_canvases();
 *        DESCRIPTION: Adds image canvases to the display
 *        
 *        
 *    public void bind_gallery(Stage window);
 *        PARAMETER: Stage window - application window used to apply property binding
 *        DESCRIPTION: This function binds(synchronizes) width and height properties of the gallery display to width and height properties of
 *                     the application window so that the gallery display is automatically resized with the window when the window changes. 
 *                     The same is done with each image canvas and the display. Each canvas is binded to the display so each canvas is resized
 *                     along with the display. 
 *                     
 */

package jt_guevara;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gallery_Display {
	private GridPane display;//gallery display component that contains image canvases
	private StackPane leftCanvas = new StackPane();//image canvases
	private StackPane midCanvas = new StackPane();
	private StackPane rightCanvas = new StackPane();
	
	public Gallery_Display() {display = new GridPane();}//constructor
	public GridPane getDisplay() {return display;}//get methods for display and canvases
	public StackPane getLeftCanvas() {return leftCanvas;}
	public StackPane getMidCanvas() {return midCanvas;}
	public StackPane getRightCanvas() {return rightCanvas;}
	
	public void setup_gallery()
	{
		set_gallery_style();
		set_image_canvas(leftCanvas);
		set_image_canvas(midCanvas);
		set_image_canvas(rightCanvas);
		set_image_view(leftCanvas);
		set_image_view(midCanvas);
		set_image_view(rightCanvas);
		add_image_canvases();
	}
	
	private void set_gallery_style() {
		display.setStyle("-fx-border-color: blue;-fx-border-width: 3px;-fx-border-color: royalblue;-fx-border-radius: 10px;"
				+ "-fx-background-color: darkblue;-fx-background-radius: 10px");
		display.setAlignment(Pos.CENTER);
		display.setMinHeight(250);
		display.setMaxHeight(750);
		display.setHgap(20);
		display.setVgap(20);
		display.setPadding(new Insets(15,15,15,15));
	}
	
	
	private void set_image_canvas(StackPane canvas)
	{
		canvas.setMinWidth(100);
		canvas.setMinHeight(100);
		canvas.setMaxWidth(400);
		canvas.setMaxHeight(560);
		canvas.setStyle("-fx-border-width: 3px;-fx-border-color: royalblue;-fx-border-radius: 10px;"
				+ "-fx-background-color: black;-fx-background-radius: 10px");
	}
	
	private void set_image_view(StackPane canvas){
		ImageView imgView = new ImageView();//image view - object embedded inside the canvas for rendering image on the screen
		imgView.minWidth(100);
		imgView.minHeight(100);
		imgView.setFitHeight(530);
		imgView.setFitWidth(100);
		imgView.maxWidth(370);
		imgView.maxHeight(530);
		imgView.fitWidthProperty().bind(canvas.widthProperty().subtract(25));
		imgView.fitHeightProperty().bind(canvas.heightProperty().subtract(25));
		canvas.getChildren().add(imgView);
	}
	
	
	private void add_image_canvases() {
		display.add(leftCanvas, 0, 0);
		display.add(midCanvas, 1, 0);
		display.add(rightCanvas, 2, 0);
	}
	
	
	public void bind_gallery(Stage window)
	{
		display.prefWidthProperty().bind(window.widthProperty());
		display.prefHeightProperty().bind(window.heightProperty());
		leftCanvas.prefWidthProperty().bind(display.widthProperty());
		leftCanvas.prefHeightProperty().bind(display.heightProperty());
		midCanvas.prefWidthProperty().bind(display.widthProperty());
		midCanvas.prefHeightProperty().bind(display.heightProperty());
		rightCanvas.prefWidthProperty().bind(display.widthProperty());
		rightCanvas.prefHeightProperty().bind(display.heightProperty());	
	}
}
