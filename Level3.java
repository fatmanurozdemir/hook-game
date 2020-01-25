import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
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
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;

public class Level3 extends Application {
	// Creating boolean to check collisions
	boolean a = false;
	boolean b = false;
	// Creating level4 object to pass to Level4 after Level3 finishedsuccessfully
	Level4 level4 = new Level4();

	@Override
	public void start(Stage stage) {
		// Creating circles
		Circle circle1 = new Circle(140, 380, 40, Color.BLACK);
		Circle circle2 = new Circle(260, 440, 40, Color.BLACK);
		Circle circle3 = new Circle(380, 520, 40, Color.BLACK);

		// Creating semi-circles
		Arc sc1 = new Arc(660, 102, 40, 40, 0, 180);
		sc1.setType(ArcType.OPEN);
		sc1.setStrokeWidth(4);
		sc1.setStroke(Color.BLACK);
		sc1.setStrokeType(StrokeType.INSIDE);
		sc1.setFill(null);

		Arc sc2 = new Arc(658, 220, 40, 40, 90, -180);
		sc2.setType(ArcType.OPEN);
		sc2.setStrokeWidth(4);
		sc2.setStroke(Color.BLACK);
		sc2.setStrokeType(StrokeType.INSIDE);
		sc2.setFill(null);

		// Creating connection arcs
		Arc cArc1 = new Arc(385, 105, 6, 6, 210, -140);
		cArc1.setType(ArcType.OPEN);
		cArc1.setStroke(Color.GRAY);
		cArc1.setStrokeWidth(2);
		cArc1.setStrokeType(StrokeType.INSIDE);
		cArc1.setFill(null);

		Arc cArc2 = new Arc(465, 225, 6, 6, 210, -140);
		cArc2.setType(ArcType.OPEN);
		cArc2.setStroke(Color.GRAY);
		cArc2.setStrokeWidth(2);
		cArc2.setStrokeType(StrokeType.INSIDE);
		cArc2.setFill(null);

		Arc cArc3 = new Arc(455, 435, 6, 6, 250, 140);
		cArc3.setType(ArcType.OPEN);
		cArc3.setStroke(Color.GRAY);
		cArc3.setStrokeWidth(2);
		cArc3.setStrokeType(StrokeType.INSIDE);
		cArc3.setFill(null);

		Arc cArc4 = new Arc(655, 375, 6, 6, 250, 140);
		cArc4.setType(ArcType.OPEN);
		cArc4.setStroke(Color.GRAY);
		cArc4.setStrokeWidth(2);
		cArc4.setStrokeType(StrokeType.INSIDE);
		cArc4.setFill(null);

		// Creating lines
		Line line1 = new Line(380, 104, 380, 480);
		Line line2 = new Line(460, 224, 460, 436);
		Line line3 = new Line(180, 380, 656, 380);
		Line line4 = new Line(280, 440, 456, 440);
		Line line5 = new Line(384, 100, 400, 100);
		Line line6 = new Line(464, 220, 480, 220);
		Line line7 = new Line(660, 360, 660, 376);

		Line vLine1 = new Line(400, 80, 400, 120);
		vLine1.setStrokeWidth(4);
		Line vLine2 = new Line(480, 200, 480, 240);
		vLine2.setStrokeWidth(4);

		Line hLine = new Line(640, 360, 680, 360);
		hLine.setStrokeWidth(4);

		Line thickLine1 = new Line(400, 100, 620, 100);
		thickLine1.setStrokeWidth(4);
		Line thickLine2 = new Line(700, 100, 760, 100);
		thickLine2.setStrokeWidth(4);
		Line thickLine3 = new Line(480, 220, 660, 220);
		thickLine3.setStrokeWidth(4);
		Line thickLine4 = new Line(660, 94, 660, 180);
		thickLine4.setStrokeWidth(4);
		Line thickLine5 = new Line(660, 260, 660, 360);
		thickLine5.setStrokeWidth(4);

		// Creating a Group object
		Group root = new Group(circle1, circle2, circle3, line1, line2, line3, line4, line5, line6, line7, vLine1,
				vLine2, hLine, thickLine1, thickLine2, thickLine3, thickLine4, thickLine5, sc1, sc2, cArc1, cArc2,
				cArc3, cArc4);

		// Setting circle1 on action
		circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				// Enlarging hLine
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(hLine);
				st.setByX(1);
				st.play();

				//Sliding thickLine4 and sc2, shortening thickLine5
				Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine4.startYProperty(), 196), new KeyValue(thickLine4.endYProperty(), 282),
						new KeyValue(thickLine5.startYProperty(), 360), new KeyValue(sc2.centerYProperty(), 320)));
				animation.play();

				//Eliminating the possibility of a collision which thickLine4 can cause
				b = true;

				//Checking collision situation of thickLine3 and thickLine4, if it happens restarting the same level
				if (a == false) {
					BooleanBinding intersecting = thickLine4.endYProperty().lessThanOrEqualTo(220);
					intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
						animation.stop();
						//Forming same conditions for the beginning of Level3
						a = false;
						b = false;
						start(stage);
					});
				}

				//Shortening sc2 and sliding thickLine4
				Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(0.5),
						new KeyValue(sc2.lengthProperty(), 0), new KeyValue(sc2.centerYProperty(), 400),
						new KeyValue(thickLine4.startYProperty(), 274), new KeyValue(thickLine4.endYProperty(), 360)));

				//Shortening thickLine4
				Timeline animation3 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine4.startYProperty(), 360)));

				//Putting animations in order to prevent them happen at the same time
				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation2.play();
					}
				});

				animation2.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation3.play();
					}
				});

				//Removing all the shapes which connected to clicked circle
				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle1);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), cArc4);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), hLine);
				FadeTransition ft5 = new FadeTransition(Duration.seconds(1), line3);
				FadeTransition ft6 = new FadeTransition(Duration.seconds(1), line7);
				FadeTransition ft7 = new FadeTransition(Duration.seconds(1), thickLine4);
				FadeTransition ft8 = new FadeTransition(Duration.seconds(1), thickLine5);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft5.setToValue(0);
				ft6.setToValue(0);
				ft7.setToValue(0);
				ft8.setToValue(0);

				animation3.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ft.play();
						ft2.play();
						ft3.play();
						ft5.play();
						ft6.play();
						ft7.play();
						ft8.play();
					}
				});
			}
		});

		// Setting circle2 on action
		circle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				// Enlarging vLine2
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(vLine2);
				st.setByY(1);
				st.play();

				//Shortening thickLine3
				Timeline animation = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine3.endXProperty(), 480)));
				animation.play();
				//Eliminating the possibility of collision which thickLine3 can cause
				a = true;

				//Removing all the shapes which connected to clicked circle
				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle2);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), cArc2);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), cArc3);
				FadeTransition ft5 = new FadeTransition(Duration.seconds(1), line4);
				FadeTransition ft6 = new FadeTransition(Duration.seconds(1), line6);
				FadeTransition ft7 = new FadeTransition(Duration.seconds(1), vLine2);
				FadeTransition ft8 = new FadeTransition(Duration.seconds(1), line2);
				FadeTransition ft9 = new FadeTransition(Duration.seconds(1), thickLine3);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft5.setToValue(0);
				ft6.setToValue(0);
				ft7.setToValue(0);
				ft8.setToValue(0);
				ft9.setToValue(0);

				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ft.play();
						ft2.play();
						ft3.play();
						ft5.play();
						ft6.play();
						ft7.play();
						ft8.play();
						ft9.play();
					}
				});
			}
		});

		// Setting circle3 on action
		circle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				// Enlarging vLine1
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(vLine1);
				st.setByY(1);
				st.play();

				//Sliding thickLine2 and sc1, shortening thickLine1
				Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine2.startXProperty(), 480), new KeyValue(thickLine2.endXProperty(), 540),
						new KeyValue(thickLine1.endXProperty(), 400), new KeyValue(sc1.centerXProperty(), 440)));
				animation.play();
				
				//Checking collision situation of thickLine2 and thickLine4, if it happens restarting the same level
				if (b == false) {
					BooleanBinding intersecting = thickLine2.startXProperty().lessThanOrEqualTo(660);
					intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
						animation.stop();
						//Forming same conditions for the beginning of Level3
						b = false;
						a = false;
						start(stage);
					});
				}

				//Shortening sc1 and sliding thickLine2
				Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(0.5),
						new KeyValue(sc1.lengthProperty(), 0), new KeyValue(sc1.centerXProperty(), 360),
						new KeyValue(thickLine2.startXProperty(), 400), new KeyValue(thickLine2.endXProperty(), 460)));

				//Shortening thickLine2
				Timeline animation3 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine2.endXProperty(), 400)));

				//Putting animations in order to prevent them happen at the same time
				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation2.play();
					}
				});

				animation2.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation3.play();
					}
				});
			
				//Removing all the shapes which connected to clicked circle
				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle3);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), sc1);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), thickLine2);
				FadeTransition ft5 = new FadeTransition(Duration.seconds(1), line1);
				FadeTransition ft6 = new FadeTransition(Duration.seconds(1), line5);
				FadeTransition ft7 = new FadeTransition(Duration.seconds(1), thickLine2);
				FadeTransition ft8 = new FadeTransition(Duration.seconds(1), cArc1);
				FadeTransition ft9 = new FadeTransition(Duration.seconds(1), vLine1);
				FadeTransition ft10 = new FadeTransition(Duration.seconds(1), thickLine1);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft5.setToValue(0);
				ft6.setToValue(0);
				ft7.setToValue(0);
				ft8.setToValue(0);
				ft9.setToValue(0);
				ft10.setToValue(0);

				animation3.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ft.play();
						ft2.play();
						ft3.play();
						ft5.play();
						ft6.play();
						ft7.play();
						ft8.play();
						ft9.play();
						ft10.play();
					}
				});
				
				//Starting Level4 if Level3 is completed successfully
				ft9.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						level4.start(stage);
					}
				});

			}
		});
		// Creating a scene object
		Scene scene = new Scene(root, 840, 600, Color.WHITESMOKE);

		// Setting title to the Stage
		stage.setTitle("Level 3");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}