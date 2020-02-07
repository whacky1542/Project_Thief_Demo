package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Thief extends Circle implements Collidable {
	public Thief() {
		super(10, Color.BLACK);
	}
	
	public Thief(double x, double y) {
		super(10, Color.BLACK);
		setTranslateX(x);
		setTranslateY(y);
	}
	
	public double getBX() {
		return getRadius();
	}
	
	public double getBY() {
		return getRadius();
	}
}
