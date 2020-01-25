import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.input.MouseEvent;

public class Level1 extends Application {
	// Creating a boolean variable to check collision
	boolean a = false;
	// Creating Level2 object to pass to Level2 when Level1 finished
	// successfully
	Level2 level2 = new Level2();

	@Override
	public void start(Stage stage) {
		// Creating circles
		Circle circle1 = new Circle(500, 500, 40, Color.BLACK);
		Circle circle2 = new Circle(660, 380, 40, Color.BLACK);

		// Creating semi-circle
		Arc sc = new Arc(500, 102, 40, 40, 0, 180);
		sc.setType(ArcType.OPEN);
		sc.setStrokeWidth(4);
		sc.setStroke(Color.BLACK);
		sc.setStrokeType(StrokeType.INSIDE);
		sc.setFill(null);

		// Creating connection arcs
		Arc arc2 = new Arc(105, 375, 6, 6, 150, 150);
		arc2.setType(ArcType.OPEN);
		arc2.setStroke(Color.GRAY);
		arc2.setStrokeWidth(2);
		arc2.setStrokeType(StrokeType.INSIDE);
		arc2.setFill(null);

		Arc arc3 = new Arc(105, 105, 6, 6, 210, -150);
		arc3.setType(ArcType.OPEN);
		arc3.setStroke(Color.GRAY);
		arc3.setStrokeWidth(2);
		arc3.setStrokeType(StrokeType.INSIDE);
		arc3.setFill(null);

		// Creating lines
		Line line1 = new Line(104, 380, 620, 380);
		Line line2 = new Line(500, 340, 500, 500);
		Line line3 = new Line(100, 106, 100, 376);
		Line line4 = new Line(104, 100, 120, 100);

		Line vLine1 = new Line(120, 80, 120, 120);
		vLine1.setStrokeWidth(4);
		Line hLine1 = new Line(480, 340, 520, 340);
		hLine1.setStrokeWidth(4);

		Line thickLine1 = new Line(500, 340, 500, 96);
		thickLine1.setStrokeWidth(4);
		Line thickLine2 = new Line(120, 100, 460, 100);
		thickLine2.setStrokeWidth(4);
		Line thickLine3 = new Line(540, 100, 640, 100);
		thickLine3.setStrokeWidth(4);

		// Creating a Group object
		Group root = new Group(circle1, circle2, line1, line2, line3, line4, vLine1, hLine1, thickLine1, thickLine2,
				thickLine3, sc, arc2, arc3);

		// Setting circle1 on action
		circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				// Enlarging hLine1
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(hLine1);
				st.setByX(1);
				st.play();

				// Shortening thickLine1
				Timeline animation = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine1.endYProperty(), 338)));
				animation.play();
				
				// Eliminating the possibility of a collision thickLine1 can cause
				a = true;

				// Removing all the shapes which connected to clicked circle
				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle1);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), hLine1);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), thickLine1);
				FadeTransition ft4 = new FadeTransition(Duration.seconds(1), line2);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft4.setToValue(0);

				// Putting animations in order to prevent them happen at the same time
				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ft.play();
						ft2.play();
						ft3.play();
						ft4.play();
					}
				});

			}
		});

		// Setting circle2 on action
		circle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				// Enlarging vLine1
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(vLine1);
				st.setByY(1);
				st.play();

				// Sliding thickLine3 and sc, shortening thickLine2
				Timeline anm1 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine2.endXProperty(), 120), new KeyValue(thickLine3.startXProperty(), 200),
						new KeyValue(thickLine3.endXProperty(), 300), new KeyValue(sc.centerXProperty(), 162)));
				anm1.play();

				// Checking collision situation of thickLine3 and thickLine1, if it happens restarting the same level
				if (a == false) {
					BooleanBinding intersecting = thickLine3.startXProperty().lessThanOrEqualTo(500);
					intersecting.addListener((obs) -> {
						anm1.stop();
						start(stage);
					});
				}

				// Sliding thickLine3 and shortening sc
				Timeline anm2 = new Timeline(new KeyFrame(Duration.seconds(0.5), new KeyValue(sc.lengthProperty(), 94),
						new KeyValue(sc.centerXProperty(), 124), new KeyValue(thickLine3.startXProperty(), 160),
						new KeyValue(thickLine3.endXProperty(), 260)));
				
				Timeline anm3 = new Timeline(new KeyFrame(Duration.seconds(0.5), new KeyValue(sc.lengthProperty(), 0),
						new KeyValue(sc.centerXProperty(), 76), new KeyValue(thickLine3.startXProperty(), 120),
						new KeyValue(thickLine3.endXProperty(), 220)));

				//Shortening thickLine3
				Timeline anm4 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine3.startXProperty(), 120), new KeyValue(thickLine3.endXProperty(), 120)));
				
				// Removing all the shapes which connected to clicked circle
				FadeTransition ft = new FadeTransition(Duration.seconds(1), vLine1);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), line1);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), line3);
				FadeTransition ft4 = new FadeTransition(Duration.seconds(1), line4);
				FadeTransition ft5 = new FadeTransition(Duration.seconds(1), arc2);
				FadeTransition ft6 = new FadeTransition(Duration.seconds(1), arc3);
				FadeTransition ft7 = new FadeTransition(Duration.seconds(1), circle2);
				FadeTransition ft8 = new FadeTransition(Duration.seconds(1), thickLine2);
				FadeTransition ft9 = new FadeTransition(Duration.seconds(1), thickLine3);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft4.setToValue(0);
				ft5.setToValue(0);
				ft6.setToValue(0);
				ft7.setToValue(0);
				ft8.setToValue(0);
				ft9.setToValue(0);
				
				// Putting animations in order to prevent them happen at the same time
				anm1.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm2.play();
					}
				});
				
				anm2.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm3.play();
					}
				});
				
				anm3.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm4.play();
					}
				});

				anm4.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ft.play();
						ft2.play();
						ft3.play();
						ft4.play();
						ft5.play();
						ft6.play();
						ft7.play();
						ft8.play();
						ft9.play();
					}
				});

				//Starting Level2 if Level1 is completed successfully
				ft9.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						level2.start(stage);
					}
				});
			}
		});

		// Creating a scene object
		Scene scene = new Scene(root, 420 * 2, 300 * 2, Color.WHITESMOKE);

		// Setting title to the Stage
		stage.setTitle("Level 1");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}

}
