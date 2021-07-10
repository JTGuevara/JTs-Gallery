/* FILE: Gallery_Layout.java
 * DESCRIPTION: The Gallery_Layout Class handles the appearance and layout of the image gallery on the user interface	
 * 
 * FUNCTIONS:
 * 		public static void generate_gallery(Stage window, GridPane p);
 * 			PARAMETERS: Stage window			- window parameter used to bind gallery layout properties
 * 						GridPane p 				- main layout container used to insert a gallery layout component
 * 			
 * 			PREREQUISITE: 3 StackPane objects for canvases must be declared
 * 			RESULT: A grid layout component representing an image gallery containing three image canvases is added to the main layout(p) and placed on the window below the menu 
 * 					items. The private helper functions: set_gallery_appearance(), create_image_canvas() and bind_gallery() have already been called		
 * 
 * 		
 * 		private static void set_gallery_appearance(GridPane galleryLayout);
 * 			PARAMETERS: GridPane galleryLayout	- gallery layout component used to set gallery properties and appearance
 * 			RESULT: The gallery layout properties are set.	
 * 
 * 
 * 		private StackPane create_image_canvas();
 * 			RESULT:	An image canvas is returned with an embedded ImageView component. Image canvas and image view properties are set.
 * 
 * 		
 * 		private static void bind_gallery(Stage window, GridPane galleryLayout, Pane canvas1, Pane canvas2, Pane canvas3);
 * 			PARAMETERS: Stage window			- Window parameter for binding galleryLayout and canvas properties
 * 						GridPane galleryLayout  - gallery layout component used to bind height and width properties to window
 * 						Pane canvas1,			- layout sub-components used to bind height and width properties to gallery 
 * 							 canvas2,
 * 							 canvas3
 * 			
 * 			RESULT: The height and width of the gallery layout and its canvas components are binded(synchronized) to the height and width of the application window
                    so that the layout is resized along with the window when the window is resized
 */

package jt_guevara;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gallery_Layout {
	public static void generate_gallery(Stage window,GridPane p)
	{
		GridPane galleryLayout = new GridPane();//gallery layout component(grid) for holding image canvases
		set_gallery_appearance(galleryLayout);
		StackPane canvas1 = create_image_canvas();//three image canvases used for placing inside gallery grid
		StackPane canvas2 = create_image_canvas();
		StackPane canvas3 = create_image_canvas();
		bind_gallery(window,galleryLayout,canvas1,canvas2,canvas3); 
		galleryLayout.add(canvas1, 0, 0);
		galleryLayout.add(canvas2, 1, 0);
		galleryLayout.add(canvas3, 2, 0);
		p.add(galleryLayout, 0, 1);
	}
	
	
	private static void set_gallery_appearance(GridPane galleryLayout) {
		galleryLayout.setStyle("-fx-border-color: blue");
		galleryLayout.setAlignment(Pos.CENTER);
		galleryLayout.setMinHeight(250);
		galleryLayout.setMaxHeight(700);
		galleryLayout.setHgap(20);
		galleryLayout.setVgap(20);
		galleryLayout.setPadding(new Insets(15,15,15,15));
	}
	
	
	private static StackPane create_image_canvas()
	{
		StackPane canvas = new StackPane();//canvas to be set and returned
		canvas.setMinWidth(100);
		canvas.setMinHeight(100);
		canvas.setMaxWidth(400);
		canvas.setMaxHeight(560);
		canvas.setStyle("-fx-border-color: green");
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
		return canvas;
	}
	
	
	private static void bind_gallery(Stage window, GridPane galleryLayout, Pane canvas1, Pane canvas2, Pane canvas3)
	{
		galleryLayout.prefWidthProperty().bind(window.widthProperty());
		galleryLayout.prefHeightProperty().bind(window.heightProperty());
		canvas1.prefWidthProperty().bind(galleryLayout.widthProperty());
		canvas2.prefWidthProperty().bind(galleryLayout.widthProperty());
		canvas1.prefHeightProperty().bind(galleryLayout.heightProperty());
		canvas2.prefHeightProperty().bind(galleryLayout.heightProperty());
		canvas3.prefWidthProperty().bind(galleryLayout.widthProperty());
		canvas3.prefHeightProperty().bind(galleryLayout.heightProperty());
	}
}
