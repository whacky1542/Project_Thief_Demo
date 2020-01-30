package a;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Thief extends Circle implements Collidable {
	
	public Thief() {
		super(0, 0, 10, Color.BLACK);
	}
}
