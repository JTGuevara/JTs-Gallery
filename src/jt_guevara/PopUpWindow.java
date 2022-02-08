/* FILE: PopUpWindow.java
   CLASS DESCRIPTION: The PopUpWindow class implements the function of the image gallery's zoom button. It generates a pop-up window containing
                      an enlarged image from the center canvas.
*/
package jt_guevara;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PopUpWindow {
	public PopUpWindow() {}
	private Stage popup = new Stage();//enlarged pop-up window for displaying zoomed image
	public Stage getWindow() {return popup;}//get method for pop-up window

/*
public void generatePopUpWindow(Stage window,Button zoom, StackPane midCanvas, ImageView midNode, GridPane layout);
    PARAMETERS: Stage window - parent window required for creating a child pop-up window 
                StackPane midCanvas - center canvas for accessing node and calculating pop-up window size
                ImageView midNode - middle canvas node for accessing its image for scaling
*/
	public void generatePopUpWindow(Stage window,StackPane midCanvas, ImageView midNode) {
		//TO GENERATE A POP-UP WINDOW FOR A ZOOMED-IN IMAGE
		//1.)declare necessary JavaFX nodes for pop-up window
		//2.)set up pop-up window
		//		a.) set pop-up window width and height
		//		b.) set window mode (disable any mouse input outside the pop-up window 
		//			until it is closed)
		//		c.) apply binding properties to zoomed image
		//		d.) set pop-up window to close when clicked with the mouse
		//		d.) add image to pop-up window
		//		e.) place pop-up window in the center of the application screen
		//			i. calculate pop-up window coordinates using the parent window
		//3.) show window
		Pane p = new Pane();
		ImageView zoomedImage = new ImageView();
		Scene s = new Scene(p,midCanvas.getWidth() * 1.37,midCanvas.getHeight() * 1.37);
		popup.setWidth(midCanvas.getWidth() * 1.37);
		popup.setHeight(midCanvas.getHeight() * 1.37);
		popup.initModality(Modality.APPLICATION_MODAL);
		//binding properties are applied to the image to lock it in place so it remains fixed in size with 
		//the window when it pops up
		zoomedImage.fitWidthProperty().bind(popup.widthProperty());
		zoomedImage.fitHeightProperty().bind(popup.heightProperty());
		zoomedImage.setImage(midNode.getImage());
		p.setOnMousePressed(event->{popup.close();});
		p.getChildren().add(zoomedImage);
		//do not change the next two statements below, or else the pop-up window will not appear at the center!
		popup.setX(window.getX() + window.getWidth() / 2 - popup.getWidth() / 2);
		popup.setY(window.getY() + (window.getHeight() / 2 - popup.getHeight() / 2) * 0.4);
		popup.setScene(s);
		
		popup.show();
	}
}
