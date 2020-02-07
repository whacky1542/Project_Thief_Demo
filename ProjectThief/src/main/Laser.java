package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Laser extends Line implements Collidable {
	public Laser() {
		
	}
	
	public Laser(double x, double y, double length) {
		super(0, 0, length, 0);
		setTranslateX(x);
		setTranslateY(y);
		setStroke(Color.RED);
	}
	
	public double getBX() {
		return getEndX() / 2;
	}
	
	public double getBY() {
		return getEndY() / 2;
	}
}
