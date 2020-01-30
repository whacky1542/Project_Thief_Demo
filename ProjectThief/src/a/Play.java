package a;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Play extends Application {
	public void start(Stage primaryStage) {
		// Button Row for the quit button and any future buttons
		HBox btnRow = new HBox();
		Button quitBtn = new Button("Quit");
		quitBtn.setOnAction(e -> System.exit(0));
		btnRow.getChildren().add(quitBtn);
		btnRow.setAlignment(Pos.TOP_RIGHT);
		
		// Map for all the objects other than the thief and button row
		MapPane map = new MapPane();
		
		// View of the buttons, thief, and map
		StackPane view = new StackPane();
		view.getChildren().addAll(map, new Thief(), btnRow);
		view.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case UP:
				view.setLayoutY(view.getLayoutY() + 1);
				break;
			case DOWN:
				view.setLayoutY(view.getLayoutY() - 1);
				break;
			case LEFT:
				view.setLayoutX(view.getLayoutX() + 1);
				break;
			case RIGHT:
				view.setLayoutX(view.getLayoutX() - 1);
				break;
			}
		});
		
		// Lights, Camera, Action!!
		Scene game = new Scene(view, 500, 500);
		primaryStage.setTitle("Theif Demo");
		primaryStage.setScene(game);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
}
