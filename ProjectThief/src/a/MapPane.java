package a;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class MapPane extends Pane {
	private Rectangle testBox = new Rectangle(250, 250, 50, 50);
	
	public MapPane() {
		testBox.setFill(Color.ORANGE);
		getChildren().add(testBox);
	}
}
