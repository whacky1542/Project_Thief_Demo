package main;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Gem extends Rectangle implements Collidable {
	public Gem() {
		super(50, 50, Color.RED);
		setRotate(45);
	}
	
	public Gem(double x, double y) {
		super(25, 25);
		setTranslateX(x);
		setTranslateY(y);
		setFill(Color.RED);
		setStroke(Color.BLACK);
		setRotate(45);
	}
	
	public double getBX() {
		return getWidth() / 2;
	}
	
	public double getBY() {
		return getHeight() / 2;
	}
}
