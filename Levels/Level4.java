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
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Level4 extends Application {
	//Creating boolean to check collisions
	boolean a = false;
	//Creating level5 object to pass to Level5 after Level4 finished successfully
	Level5 level5 = new Level5();
	@Override
	public void start(Stage stage) {
		// Creating circles
		Circle circle1 = new Circle(180, 360, 40, Color.BLACK);
		Circle circle2 = new Circle(360, 540, 40, Color.BLACK);
		Circle circle3 = new Circle(360, 360, 40, Color.WHITESMOKE);
		circle3.setStrokeWidth(3);
		circle3.setStroke(Color.BLACK);

		// Creating semi-circles
		Arc sc = new Arc(680, 122, 40, 40, 0, 180);
		sc.setType(ArcType.OPEN);
		sc.setStrokeWidth(4);
		sc.setStroke(Color.BLACK);
		sc.setStrokeType(StrokeType.INSIDE);
		sc.setFill(null);

		// Creating connection arcs
		Arc arc2 = new Arc(365, 125, 6, 6, 210, -150);
		arc2.setType(ArcType.OPEN);
		arc2.setStroke(Color.GRAY);
		arc2.setStrokeWidth(2);
		arc2.setStrokeType(StrokeType.INSIDE);
		arc2.setFill(null);

		Arc arc3 = new Arc(675, 355, 6, 6, 240, 150);
		arc3.setType(ArcType.OPEN);
		arc3.setStroke(Color.GRAY);
		arc3.setStrokeWidth(2);
		arc3.setStrokeType(StrokeType.INSIDE);
		arc3.setFill(null);

		// Creating lines
		Line line1 = new Line(180, 360, 320, 360);
		Line line2 = new Line(400, 360, 676, 360);
		Line line3 = new Line(680, 356, 680, 340);
		Line line4 = new Line(360, 400, 360, 540);
		Line line5 = new Line(360, 124, 360, 320);
		Line line6 = new Line(364, 120, 380, 120);

		Line vLine1 = new Line(380, 100, 380, 140);
		vLine1.setStrokeWidth(4);

		Line hLine1 = new Line(660, 340, 700, 340);
		hLine1.setStrokeWidth(4);

		Line thickLine1 = new Line(380, 120, 640, 120);
		thickLine1.setStrokeWidth(4);
		Line thickLine2 = new Line(720, 120, 760, 120);
		thickLine2.setStrokeWidth(4);
		Line thickLine3 = new Line(680, 116, 680, 340);
		thickLine3.setStrokeWidth(4);

		Line turnableLine = new Line(360, 320, 360, 400);
		turnableLine.setStroke(Color.BLUE);

		//Setting circle1 on action
		circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				// Checking whether turnableLine2 is vertical or horizontal (returning true if it is horizontal)
				if (turnableLine.getRotate() % 180 == 90) {
					// Enlarging hLine1
					ScaleTransition st = new ScaleTransition();
					st.setDuration(Duration.seconds(1));
					st.setNode(hLine1);
					st.setByX(1);
					st.play();

					//Shortening thickLine3
					Timeline animation = new Timeline(
							new KeyFrame(Duration.seconds(1), new KeyValue(thickLine3.startYProperty(), 340)));
					animation.play();
					
					// Eliminating the possibility of a collision thickLine3 can cause
					a=true;

					// Removing all the shapes which connected to clicked circle
					FadeTransition ft = new FadeTransition(Duration.seconds(1), circle1);
					FadeTransition ft2 = new FadeTransition(Duration.seconds(1), hLine1);
					FadeTransition ft3 = new FadeTransition(Duration.seconds(1), line1);
					FadeTransition ft4 = new FadeTransition(Duration.seconds(1), line2);
					FadeTransition ft5 = new FadeTransition(Duration.seconds(1), line3);
					FadeTransition ft6 = new FadeTransition(Duration.seconds(1), thickLine3);
					FadeTransition ft7 = new FadeTransition(Duration.seconds(1), arc3);

					ft.setToValue(0);
					ft2.setToValue(0);
					ft3.setToValue(0);
					ft4.setToValue(0);
					ft5.setToValue(0);
					ft6.setToValue(0);
					ft7.setToValue(0);

					// Putting animations in order to prevent them happen at the same time
					animation.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							ft.play();
							ft2.play();
							ft3.play();
							ft4.play();
							ft5.play();
							ft6.play();
							ft7.play();
						}
					});
				}
			}
		});
		
		//Setting circle2 on action
		circle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				// Checking whether turnableLine1 is vertical or horizontal (returning true if it is vertical)
				if (turnableLine.getRotate() % 180 == 0) {
					// Enlarging vLine1
					ScaleTransition st = new ScaleTransition();
					st.setDuration(Duration.seconds(1));
					st.setNode(vLine1);
					st.setByY(1);
					st.play();

					// Sliding thickLine2 and sc, shortening thickLine1
					Timeline anm1 = new Timeline(new KeyFrame(Duration.seconds(1),
							new KeyValue(thickLine1.endXProperty(), 380),
							new KeyValue(thickLine2.startXProperty(), 460),
							new KeyValue(thickLine2.endXProperty(), 500), new KeyValue(sc.centerXProperty(), 420)));
					anm1.play();
					
					// Checking collision situation of thickLine2 and thickLine3, if it happens restarting the same level
					if (a == false) {
						BooleanBinding intersecting = thickLine2.startXProperty().lessThanOrEqualTo(680);
						intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
							anm1.stop();
							start(stage);
						});
					}

					// Sliding thickLine2 and shortening sc
					Timeline anm2 = new Timeline(new KeyFrame(Duration.seconds(0.5),
							new KeyValue(sc.lengthProperty(), 94), new KeyValue(sc.centerXProperty(), 384),
							new KeyValue(thickLine2.startXProperty(), 420),
							new KeyValue(thickLine2.endXProperty(), 460)));

					Timeline anm3 = new Timeline(new KeyFrame(Duration.seconds(0.5), new KeyValue(sc.lengthProperty(), -6),
							new KeyValue(sc.centerXProperty(), 336), new KeyValue(thickLine2.startXProperty(), 380),
							new KeyValue(thickLine2.endXProperty(), 420)));

					//Shortening thickLine2
					Timeline anm4 = new Timeline(
							new KeyFrame(Duration.seconds(1), new KeyValue(thickLine2.startXProperty(), 380),
									new KeyValue(thickLine2.endXProperty(), 380)));
					
					// Removing all the shapes which connected to clicked circle
					FadeTransition ft = new FadeTransition(Duration.seconds(1), circle2);
					FadeTransition ft2 = new FadeTransition(Duration.seconds(1), vLine1);
					FadeTransition ft3 = new FadeTransition(Duration.seconds(1), line4);
					FadeTransition ft4 = new FadeTransition(Duration.seconds(1), line5);
					FadeTransition ft5 = new FadeTransition(Duration.seconds(1), arc2);
					FadeTransition ft6 = new FadeTransition(Duration.seconds(1), thickLine1);
					FadeTransition ft7 = new FadeTransition(Duration.seconds(1), thickLine2);
					FadeTransition ft8 = new FadeTransition(Duration.seconds(1), line6);
					FadeTransition ft9 = new FadeTransition(Duration.seconds(1), circle3);
					FadeTransition ft10 = new FadeTransition(Duration.seconds(1), turnableLine);

					ft.setToValue(0);
					ft2.setToValue(0);
					ft3.setToValue(0);
					ft4.setToValue(0);
					ft5.setToValue(0);
					ft6.setToValue(0);
					ft7.setToValue(0);
					ft8.setToValue(0);
					ft9.setToValue(0);
					ft10.setToValue(0);
					
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
							ft10.play();
						}
					});
					
					//Starting Level5 if Level4 is completed successfully
					ft10.setOnFinished(e->
					level5.start(stage));
					
				}
			}
		});
		
		//Setting circle3 on action
		circle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				turnableLine.setRotate(t.getClickCount() * 90 );
			}
		});

		// Creating a Group object
		Group root = new Group(circle1, circle2, circle3, line1, line2, line3, line4, line5, line6, vLine1, hLine1,
				thickLine1, thickLine2, thickLine3, turnableLine, sc, arc2, arc3);

		// Creating a scene object
		Scene scene = new Scene(root, 840, 600, Color.WHITESMOKE);

		// Setting title to the Stage
		stage.setTitle("Level 4");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
