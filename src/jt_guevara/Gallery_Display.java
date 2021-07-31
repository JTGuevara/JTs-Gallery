
package jt_guevara;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Gallery_Display {
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
