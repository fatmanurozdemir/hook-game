import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CoverPage extends Application {
	Level1 level1 = new Level1();
	@Override
	public void start(Stage stage) {
		// Creating a Group object
		Group root = new Group();

		// Creating a scene object
		Scene scene = new Scene(root, 840, 600, Color.WHITESMOKE);

		// Setting title to the Stage
		stage.setTitle("HELLO !");

		//Creating button object to starting the game
		Button btn = new Button();
		btn.setLayoutX(360);
		btn.setLayoutY(280);
		btn.setText("START THE GAME");
		
		//Setting button on action
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				level1.start(stage);
			}
		});
		
		//Adding button to group
		root.getChildren().add(btn);

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
