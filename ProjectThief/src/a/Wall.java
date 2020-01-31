package a;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Wall extends Rectangle implements Collidable {
	public Wall() {
		
	}
	
	public Wall(double x, double y, double length, double rotation) {
		super(10, length, Color.BLACK);
		setTranslateX(x);
		setTranslateY(y);
		setRotate(rotation);
	}
	
	public double getBX() {
		return getWidth() / 2;
	}
	
	public double getBY() {
		return getHeight() / 2;
	}
}
