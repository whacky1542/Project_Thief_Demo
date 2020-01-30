package a;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Play extends Application {
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
		Thief thief = new Thief();
		Wall wall1 = new Wall(0, 100, 200, 90);
		Wall wall2 = new Wall(95, -295, 800, 0);
		Wall wall3 = new Wall(-95, -295, 800, 0);
		Wall wall4 = new Wall(0, -695, 200, 90);
		StackPane map = new StackPane();
		map.getChildren().addAll(wall1, wall2, wall3, wall4);
		//----------
		
		// GUI for all the elements to reside in
		StackPane view = new StackPane();
		view.getChildren().addAll(map, thief, btnRow);
		view.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case UP:
				map.setTranslateY(map.getTranslateY() + 5);
				break;
			case DOWN:
				map.setTranslateY(map.getTranslateY() - 5);
				break;
			case LEFT:
				map.setTranslateX(map.getTranslateX() + 5);
				break;
			case RIGHT:
				map.setTranslateX(map.getTranslateX() - 5);
				break;
			}
		});
		//----------
		
		// Lights, Camera, Action!!
		Scene game = new Scene(view, 1000, 1000);
		primaryStage.setTitle("Theif Demo");
		primaryStage.setScene(game);
		primaryStage.show();
		//----------
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
