package a;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Box extends Rectangle implements Collidable {
	public Box() {
		super(50, 50, Color.BROWN);
	}
	
	public Box(double x, double y, double rotation) {
		super(40, 40);
		setTranslateX(x);
		setTranslateY(y);
		setFill(Color.BROWN);
		setStroke(Color.BLACK);
		setRotate(rotation);
	}
	
	public double getBX() {
		if (getRotate() == 90)
			return getHeight() / 2;
		return getWidth() / 2;
	}
	
	public double getBY() {
		if (getRotate() == 90)
			return getWidth() / 2;
		return getHeight() / 2;
	}
}
