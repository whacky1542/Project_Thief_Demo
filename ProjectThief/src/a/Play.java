package a;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Play extends Application {
	private double prevX;
	private double prevY;
	private Thief thief = new Thief(0, 350);
	private boolean lost;
	private boolean win;
	
	public void start(Stage primaryStage) {
		// Button Row and its components
		HBox btnRow = new HBox();
		btnRow.setAlignment(Pos.TOP_RIGHT);
		
		// Quit Button
		Button quitBtn = new Button("Quit");
		quitBtn.setOnAction(e -> System.exit(0));
		btnRow.getChildren().add(quitBtn);
		//----------
		
		// Graphical objects in the scene
		Wall wall1 = new Wall(0, 395, 200, 90);
		Wall wall2 = new Wall(95, 0, 800, 0);
		Wall wall3 = new Wall(-95, 0, 800, 0);
		Wall wall4 = new Wall(0, -395, 200, 90);
		ArrayList<Wall> walls = new ArrayList<Wall>();
		walls.add(wall1);
		walls.add(wall2);
		walls.add(wall3);
		walls.add(wall4);
		Box box1 = new Box(30, 150, 10);
		Box box2 = new Box(-30, 0, -10);
		Box box3 = new Box(0, -150, 3);
		ArrayList<Box> boxes = new ArrayList<Box>();
		boxes.add(box1);
		boxes.add(box2);
		boxes.add(box3);
		Laser laser1 = new Laser(-35, 150, 125);
		Laser laser2 = new Laser(35, 0, 125);
		Laser laser3 = new Laser(-50, -150, 95);
		ArrayList<Laser> lasers = new ArrayList<Laser>();
		lasers.add(laser1);
		lasers.add(laser2);
		lasers.add(laser3);
		Gem gem = new Gem(0, -350);
		Text winText = new Text("You Win!");
		winText.setFont(new Font("TimesRoman", 80));
		winText.setFill(Color.GOLD);
		winText.setStroke(Color.BLACK);
		Text loseText = new Text("You Lose!");
		loseText.setFont(new Font("TimesRoman", 80));
		loseText.setFill(Color.RED);
		loseText.setStroke(Color.BLACK);
		//----------
		
		// GUI for all the elements to reside in
		StackPane view = new StackPane();
		view.getChildren().addAll(gem, laser1, laser2, laser3, thief, wall1, wall2, wall3, wall4, box1, box2, box3, btnRow);
		view.setOnKeyPressed(e -> {
			prevX = thief.getTranslateX();
			prevY = thief.getTranslateY();
			switch (e.getCode()) {
			case UP:
				thief.setTranslateY(thief.getTranslateY() - 5);
				break;
			case DOWN:
				thief.setTranslateY(thief.getTranslateY() + 5);
				break;
			case LEFT:
				thief.setTranslateX(thief.getTranslateX() - 5);
				break;
			case RIGHT:
				thief.setTranslateX(thief.getTranslateX() + 5);
				break;
			}
		});
		//----------
		
		//Timeline for winning or losing
		Timeline end = new Timeline(new KeyFrame(Duration.seconds(3)));
		end.setCycleCount(1);
		end.setOnFinished(e -> System.exit(0));
		//----------
		
		// Timeline for game play
		EventHandler<ActionEvent> checkCollision = e -> {
			for (Box box : boxes) {
				if (thief.getBX() + box.getBX() > Math.abs(thief.getTranslateX() - box.getTranslateX()) && thief.getBY() + box.getBY() > Math.abs(thief.getTranslateY() - box.getTranslateY())) {
					thief.setTranslateX(prevX);
					thief.setTranslateY(prevY);
				}
			}
			
			for (Wall wall : walls) {
				if (thief.getBX() + wall.getBX() > Math.abs(thief.getTranslateX() - wall.getTranslateX()) && thief.getBY() + wall.getBY() > Math.abs(thief.getTranslateY() - wall.getTranslateY())) {
					thief.setTranslateX(prevX);
					thief.setTranslateY(prevY);
				}
			}
			
			for (Laser laser : lasers) {
				if (thief.getBX() + laser.getBX() > Math.abs(thief.getTranslateX() - laser.getTranslateX()) && thief.getBY() + laser.getBY() > Math.abs(thief.getTranslateY() - laser.getTranslateY())) {
					if (!lost) {
						view.getChildren().add(loseText);
						lost = true;
						end.play();
					}
				}
			}
			
			if (thief.getBX() + gem.getBX() > Math.abs(thief.getTranslateX() - gem.getTranslateX()) && thief.getBY() + gem.getBY() > Math.abs(thief.getTranslateY() - gem.getTranslateY())) {
				if (!win) {
					gem.setVisible(false);
					view.getChildren().add(winText);
					win = true;
					end.play();
				}
			}
		};
		Timeline time = new Timeline(new KeyFrame(Duration.seconds(0.01), checkCollision));
		time.setCycleCount(Timeline.INDEFINITE);
		time.play();
		//----------
		
		// Lights, Camera, Action!!
		Scene game = new Scene(view, 400, 900);
		primaryStage.setTitle("Theif Demo");
		primaryStage.setScene(game);
		primaryStage.show();
		//----------
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
