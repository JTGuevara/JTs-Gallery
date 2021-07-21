package jt_guevara.test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

class Gallery_Layout_Test extends Application{

	@Test
	public void Generate_Gallery_Test() {
		
	}
	
	@Test
	public void set_gallery_appearance_alignment_test() {
		GridPane p = new GridPane();
		p.setAlignment(Pos.CENTER);
		assertEquals(p.getAlignment(), Pos.CENTER);
	}

	@Override
	public void start(Stage window) throws Exception {
		
	}
}
