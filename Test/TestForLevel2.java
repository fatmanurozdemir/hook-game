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

public class TestForLevel2 extends Application {
	boolean a = false;
	boolean b = false;
	boolean c = false;
	TestForLevel3 tf3 = new TestForLevel3();
	@Override
	public void start(Stage stage) {
		// Creating circles
		Circle circle1 = new Circle(140, 480, 40, Color.BLACK);
		Circle circle2 = new Circle(310, 480, 40, Color.BLACK);
		Circle circle3 = new Circle(480, 480, 40, Color.BLACK);
		Circle circle4 = new Circle(700, 480, 40, Color.BLACK);

		// Creating semi-circles
		Arc sc1 = new Arc(312, 140, 38, 38, 90, -180);
		sc1.setType(ArcType.OPEN);
		sc1.setStrokeWidth(4);
		sc1.setStroke(Color.BLACK);
		sc1.setStrokeType(StrokeType.INSIDE);
		sc1.setFill(null);

		Arc sc2 = new Arc(310, 280, 38, 38, 90, 180);
		sc2.setType(ArcType.OPEN);
		sc2.setStrokeWidth(4);
		sc2.setStroke(Color.BLACK);
		sc2.setStrokeType(StrokeType.INSIDE);
		sc2.setFill(null);

		Arc sc3 = new Arc(480, 280, 38, 38, 180, -180);
		sc3.setType(ArcType.OPEN);
		sc3.setStrokeWidth(4);
		sc3.setStroke(Color.BLACK);
		sc3.setStrokeType(StrokeType.INSIDE);
		sc3.setFill(null);

		// Creating connection arcs
		Arc arc1 = new Arc(145, 143, 6, 6, 200, -120);
		arc1.setType(ArcType.OPEN);
		arc1.setStroke(Color.GRAY);
		arc1.setStrokeWidth(2);
		arc1.setStrokeType(StrokeType.INSIDE);
		arc1.setFill(null);

		Arc arc2 = new Arc(695, 285, 6, 6, 110, -120);
		arc2.setType(ArcType.OPEN);
		arc2.setStroke(Color.GRAY);
		arc2.setStrokeWidth(2);
		arc2.setStrokeType(StrokeType.INSIDE);
		arc2.setFill(null);

		// Creating lines
		Line line1 = new Line(140, 144, 140, 440);
		Line line2 = new Line(310, 380, 310, 440);
		Line line3 = new Line(480, 380, 480, 440);
		Line line4 = new Line(700, 284, 700, 440);
		Line line5 = new Line(144, 138, 164, 138);
		Line line6 = new Line(680, 280, 696, 280);

		Line thickLine1 = new Line(310, 60, 310, 104);
		thickLine1.setStrokeWidth(4);
		Line thickLine2 = new Line(166, 138, 316, 138);
		thickLine2.setStrokeWidth(4);
		Line thickLine3 = new Line(310, 176, 310, 244);
		thickLine3.setStrokeWidth(4);
		Line thickLine4 = new Line(310, 316, 310, 380);
		thickLine4.setStrokeWidth(4);
		Line thickLine5 = new Line(306, 280, 444, 280);
		thickLine5.setStrokeWidth(4);
		Line thickLine6 = new Line(480, 280, 480, 380);
		thickLine6.setStrokeWidth(4);
		Line thickLine7 = new Line(516, 280, 680, 280);
		thickLine7.setStrokeWidth(4);

		Line vLine1 = new Line(164, 120, 164, 160);
		vLine1.setStrokeWidth(4);
		Line vLine2 = new Line(680, 260, 680, 300);
		vLine2.setStrokeWidth(4);

		Line hLine1 = new Line(290, 380, 330, 380);
		hLine1.setStrokeWidth(4);
		Line hLine2 = new Line(460, 380, 500, 380);
		hLine2.setStrokeWidth(4);

		Group root = new Group(circle1, circle2, circle3, circle4, sc1, sc2, sc3, arc1, arc2, line1, line2, line3,
				line4, line5, line6, thickLine1, thickLine2, thickLine3, thickLine4, thickLine5, thickLine6, thickLine7,
				vLine1, hLine1, vLine2, hLine2);

		circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			//
			public void handle(MouseEvent t) {
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(vLine1);
				st.setByY(1);
				st.play();

				Timeline animation = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine2.endXProperty(), 166)));
				animation.play();
				
				a=true;

				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle1);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), vLine1);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), thickLine2);
				FadeTransition ft4 = new FadeTransition(Duration.seconds(1), line1);
				FadeTransition ft5 = new FadeTransition(Duration.seconds(1), arc1);
				FadeTransition ft6 = new FadeTransition(Duration.seconds(1), line5);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft4.setToValue(0);
				ft5.setToValue(0);
				ft6.setToValue(0);

				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ft.play();
						ft2.play();
						ft3.play();
						ft4.play();
						ft5.play();
						ft6.play();
					}
				});
			}
		});

		circle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(hLine1);
				st.setByX(1);
				st.play();

				Timeline anm1 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine4.startYProperty(), 380),
								new KeyValue(thickLine3.startYProperty(), 240),
								new KeyValue(thickLine3.endYProperty(), 308),
								new KeyValue(sc2.centerYProperty(), 344),
								new KeyValue(thickLine1.startYProperty(), 124),
								new KeyValue(thickLine1.endYProperty(), 168),
								new KeyValue(sc1.centerYProperty(), 204)));
				anm1.play();
				
				if(a == false || c == false){
					BooleanBinding intersecting = thickLine3.endYProperty().greaterThanOrEqualTo(280);
			        intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
			        	anm1.stop();
			        	a=false;
			        	b=false;
			        	c=false;
			        	start(stage);
			        });
					}

				Timeline anm2 = new Timeline(new KeyFrame(Duration.seconds(0.5),
						new KeyValue(thickLine3.startYProperty(), 278),
						new KeyValue(thickLine3.endYProperty(), 346),
						new KeyValue(sc2.centerYProperty(), 382), new KeyValue(sc2.lengthProperty(), 90),
						new KeyValue(thickLine1.startYProperty(), 162),
						new KeyValue(thickLine1.endYProperty(), 206),
						new KeyValue(sc1.centerYProperty(), 242)));

				anm1.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm2.play();
					}
				});

				Timeline anm3 = new Timeline(new KeyFrame(Duration.seconds(0.5),
						new KeyValue(thickLine3.startYProperty(), 316),
						new KeyValue(thickLine3.endYProperty(), 380),
						new KeyValue(sc2.centerYProperty(), 420),
						new KeyValue(sc2.lengthProperty(), 0),
						new KeyValue(thickLine1.startYProperty(), 200),
						new KeyValue(thickLine1.endYProperty(), 244),
						new KeyValue(sc1.centerYProperty(), 280)));

				anm2.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm3.play();
					}
				});

				Timeline anm4 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine3.startYProperty(), 380),
						new KeyValue(thickLine1.startYProperty(), 262),
						new KeyValue(thickLine1.endYProperty(), 306),
						new KeyValue(sc1.centerYProperty(), 344)));

				anm3.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm4.play();
					}
				});

				Timeline anm5 = new Timeline(new KeyFrame(Duration.seconds(0.5),
						new KeyValue(thickLine1.startYProperty(), 300),
						new KeyValue(thickLine1.endYProperty(), 344),
						new KeyValue(sc1.centerYProperty(), 380),
						new KeyValue(sc1.lengthProperty(), -90)));

				anm4.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm5.play();
					}
				});

				Timeline anm6 = new Timeline(new KeyFrame(Duration.seconds(0.5),
						new KeyValue(thickLine1.startYProperty(), 336),
						new KeyValue(thickLine1.endYProperty(), 380),
						new KeyValue(sc1.centerYProperty(), 418),
						new KeyValue(sc1.lengthProperty(), 0)));

				anm5.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm6.play();
					}
				});

				Timeline anm7 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine1.startYProperty(), 380),
						new KeyValue(thickLine1.endYProperty(), 380)));

				anm6.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm7.play();
					}
				});

				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle2);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), hLine1);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), line2);
				FadeTransition ft4 = new FadeTransition(Duration.seconds(1), thickLine1);
				FadeTransition ft5 = new FadeTransition(Duration.seconds(1), thickLine3);
				FadeTransition ft6 = new FadeTransition(Duration.seconds(1), thickLine4);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft4.setToValue(0);
				ft5.setToValue(0);
				ft6.setToValue(0);

				anm7.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						ft.play();
						ft2.play();
						ft3.play();
						ft4.play();
						ft5.play();
						ft6.play();
					}
				});
				
				ft6.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						tf3.start(stage);
					}
				});

			}
		});

		circle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(hLine2);
				st.setByX(1);
				st.play();

				Timeline anm = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine6.startYProperty(), 380)));
				anm.play();
				
				b=true;

				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle3);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), hLine2);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), thickLine6);
				FadeTransition ft4 = new FadeTransition(Duration.seconds(1), line3);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft4.setToValue(0);

				anm.setOnFinished(new EventHandler<ActionEvent>() {
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

		circle4.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(vLine2);
				st.setByY(1);
				st.play();

				Timeline anm1 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine7.startXProperty(), 680), new KeyValue(thickLine5.startXProperty(), 466),
						new KeyValue(thickLine5.endXProperty(), 604), new KeyValue(sc3.centerXProperty(), 642)));
				anm1.play();
				
				c=true;
				
				if(b == false){
					BooleanBinding intersecting = thickLine5.endXProperty().greaterThanOrEqualTo(466+19);
			        intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
			        	anm1.stop();
			        	a=false;
			        	b=false;
			        	c=false;
			        	start(stage);
			        });
					}

				Timeline anm2 = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(sc3.lengthProperty(), -90),
						new KeyValue(sc3.centerXProperty(), 680), new KeyValue(thickLine5.startXProperty(), 504),
						new KeyValue(thickLine5.endXProperty(), 646)));

				anm1.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm2.play();
					}
				});

				Timeline anm3 = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(sc3.lengthProperty(), 6),
						new KeyValue(sc3.centerXProperty(), 718), new KeyValue(thickLine5.startXProperty(), 542),
						new KeyValue(thickLine5.endXProperty(), 680)));

				anm2.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm3.play();
					}
				});

				Timeline anm4 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine5.startXProperty(), 680), new KeyValue(thickLine5.endXProperty(), 680)));

				anm3.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						anm4.play();
					}
				});

				FadeTransition ft = new FadeTransition(Duration.seconds(1), circle4);
				FadeTransition ft2 = new FadeTransition(Duration.seconds(1), vLine2);
				FadeTransition ft3 = new FadeTransition(Duration.seconds(1), line4);
				FadeTransition ft4 = new FadeTransition(Duration.seconds(1), line6);
				FadeTransition ft5 = new FadeTransition(Duration.seconds(1), arc2);
				FadeTransition ft6 = new FadeTransition(Duration.seconds(1), thickLine7);
				FadeTransition ft7 = new FadeTransition(Duration.seconds(1), thickLine5);

				ft.setToValue(0);
				ft2.setToValue(0);
				ft3.setToValue(0);
				ft4.setToValue(0);
				ft5.setToValue(0);
				ft6.setToValue(0);
				ft7.setToValue(0);

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
					}
				});
			}
		});

		// Creating a scene object
		Scene scene = new Scene(root, 840, 600, Color.WHITESMOKE);

		// Setting title to the Stage
		stage.setTitle("Level 2");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}