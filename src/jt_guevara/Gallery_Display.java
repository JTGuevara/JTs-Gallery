/* FILE: Gallery_Display.java
 * CLASS DESCRIPTION: The Gallery_Display class is the visual representation of the image gallery. A Gallery_Display consists of a display
 *                    component(or wall) for holding image canvases, a left canvas, a middle canvas and a right canvas. Each canvas contains
 *                    an embedded object(ImageView) or node that actually contains and renders the image.                  
 */

package jt_guevara;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gallery_Display {
	private GridPane display;								//gallery display component that contains image canvases
	private StackPane leftCanvas = new StackPane();			//image canvases
	private StackPane midCanvas = new StackPane();
	private StackPane rightCanvas = new StackPane();
	private ImageView leftNode = new ImageView();			//objects embedded inside the canvas to contain and render the image
	private ImageView midNode = new ImageView();
	private ImageView rightNode = new ImageView();
	
	public Gallery_Display() {display = new GridPane();}	//constructor
	public GridPane getDisplay() {return display;}			//get methods for display, canvases and nodes
	public StackPane getLeftCanvas() {return leftCanvas;}
	public StackPane getMidCanvas() {return midCanvas;}
	public StackPane getRightCanvas() {return rightCanvas;}
	public ImageView getLeftNode() {return leftNode;}
	public ImageView getMidNode() {return midNode;}
	public ImageView getRightNode() {return rightNode;}
	
/*
public void setUpDisplay();
    DESCRIPTION: Sets up gallery display by setting style properties to the gallery display, setting style properties for each image canvas, 
                 applying an image node to each canvas as well as adding all canvases to the display. 	
 */
	public void setUpDisplay()
	{
		setDisplayStyle();
		setImageCanvas(leftCanvas);
		setImageCanvas(midCanvas);
		setImageCanvas(rightCanvas);
		setImageNode(leftCanvas, leftNode);
		setImageNode(midCanvas, midNode);
		setImageNode(rightCanvas, rightNode);
		addImageCanvases();
	}
	
/*
 private void setDisplayStyle();
     DESCRIPTION: The gallery display has its style properties set
*/
	 private void setDisplayStyle() {
		display.setStyle("-fx-border-color: blue;-fx-border-width: 5px;-fx-border-color: royalblue;-fx-border-radius: 10px;"
				+ "-fx-background-color: darkblue;-fx-background-radius: 10px");
		display.setOpacity(.9);
		display.setAlignment(Pos.CENTER);
		display.setMinHeight(250);
		display.setMaxHeight(display.getMaxHeight());
		display.setHgap(20);
		display.setVgap(20);
		display.setPadding(new Insets(20,20,20,20));
	}
	
/*
 private void setImageCanvas(StackPane canvas);
     PARAMETER: StackPane canvas - image canvas used to set style properties
     DESCRIPTION: Modifies and styles the image canvas
*/
	private void setImageCanvas(StackPane canvas)
	{
		canvas.setMinWidth(100);
		canvas.setMinHeight(100);
		canvas.setMaxWidth(display.getMaxWidth());
		canvas.setMaxHeight(display.getMaxHeight());
		canvas.setStyle("-fx-border-width: 2px;-fx-border-color: royalblue;-fx-border-radius: 10px;"
				+ "-fx-background-color: black;-fx-background-radius: 10px");
	}
/*
 private void setImageNode(StackPane canvas);
     PARAMETER: StackPane canvas - image canvas used for adding an image node
     DESCRIPTION: Sets properties of the specified image node(ImageView). The image node is then binded and added
                  to the canvas.
*/
	
	private void setImageNode(StackPane canvas, ImageView node){
		node.minWidth(100);
		node.minHeight(100);
		node.setFitHeight(530);
		node.setFitWidth(100);
		node.maxWidth(370);
		node.maxHeight(530);
		//binding properties are set so the width and height of the image node is fixed to its canvas
		node.fitWidthProperty().bind(canvas.widthProperty().subtract(25));
		node.fitHeightProperty().bind(canvas.heightProperty().subtract(25));
		canvas.getChildren().add(node);
	}
	
/*
 private void addImageCanvases();
     DESCRIPTION: Adds image canvases to the display
*/
	private void addImageCanvases() {
		display.add(leftCanvas, 0, 0);
		display.add(midCanvas, 1, 0);
		display.add(rightCanvas, 2, 0);
	}
	
/*
 public void synchronizeDisplay(Stage window);
     PARAMETER: Stage window - application window used to apply property binding
     DESCRIPTION: Sets binding properties to the display and each canvas. These binding properties allow for dynamic resizing of components
                  every time the user changes the size of the window.
*/
	public void synchronizeDisplay(Stage window)
	{
		//to set binding properties and allow for dynamic resizing of components, the width and height properties of the display are bound(synchronized)
		//to the application window's width and height so the display is resized only when the window is changed
		display.prefWidthProperty().bind(window.widthProperty());
		display.prefHeightProperty().bind(window.heightProperty());
		//the same is done with each canvas in relation to the display
		leftCanvas.prefWidthProperty().bind(display.widthProperty());
		leftCanvas.prefHeightProperty().bind(display.heightProperty());
		midCanvas.prefWidthProperty().bind(display.widthProperty());
		midCanvas.prefHeightProperty().bind(display.heightProperty());
		rightCanvas.prefWidthProperty().bind(display.widthProperty());
		rightCanvas.prefHeightProperty().bind(display.heightProperty());	
	}
}
