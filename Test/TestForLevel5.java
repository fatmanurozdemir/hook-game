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

public class TestForLevel5 extends Application {
	boolean a = false;
	boolean b = false;
	boolean c = false;

	@Override
	public void start(Stage stage) {
		// Creating circles
		Circle circle1 = new Circle(70 * 2, 145 * 2, 20 * 2, Color.BLACK);
		Circle circle2 = new Circle(70 * 2, 205 * 2, 20 * 2, Color.BLACK);
		Circle circle3 = new Circle(340, 265 * 2, 20 * 2, Color.BLACK);
		Circle circle4 = new Circle(295 * 2, 265 * 2, 20 * 2, Color.BLACK);

		Circle emptycircle1 = new Circle(340, 290, 40, Color.WHITESMOKE);
		emptycircle1.setStrokeWidth(3);
		emptycircle1.setStroke(Color.BLACK);
		emptycircle1.setStrokeType(StrokeType.INSIDE);

		Circle emptycircle2 = new Circle(170 * 2, 205 * 2, 20 * 2, Color.WHITESMOKE);
		emptycircle2.setStrokeWidth(3);
		emptycircle2.setStroke(Color.BLACK);
		emptycircle2.setStrokeType(StrokeType.INSIDE);

		// Creating semi-circles
		Arc sc1 = new Arc(470, 50 * 2, 38, 38, 0, 180);
		sc1.setType(ArcType.OPEN);
		sc1.setStrokeWidth(4);
		sc1.setStroke(Color.BLACK);
		sc1.setStrokeType(StrokeType.INSIDE);
		sc1.setFill(null);

		Arc sc2 = new Arc(235 * 2, 160, 38, 38, 90, 180);
		sc2.setType(ArcType.OPEN);
		sc2.setStrokeWidth(4);
		sc2.setStroke(Color.BLACK);
		sc2.setStrokeType(StrokeType.INSIDE);
		sc2.setFill(null);

		Arc sc3 = new Arc(630, 100, 38, 38, 90, -180);
		sc3.setType(ArcType.OPEN);
		sc3.setStrokeWidth(4);
		sc3.setStroke(Color.BLACK);
		sc3.setStrokeType(StrokeType.INSIDE);
		sc3.setFill(null);

		// Creating connection arcs
		Arc arc1 = new Arc(345, 52 * 2 + 1, 3 * 2, 3 * 2, 60, 150);
		arc1.setType(ArcType.OPEN);
		arc1.setStroke(Color.GRAY);
		arc1.setStrokeWidth(2);
		arc1.setStrokeType(StrokeType.INSIDE);
		arc1.setFill(null);

		Arc arc2 = new Arc(292 * 2 + 1, 82 * 2 + 1, 3 * 2, 3 * 2, -10, 140);
		arc2.setType(ArcType.OPEN);
		arc2.setStroke(Color.GRAY);
		arc2.setStrokeWidth(2);
		arc2.setStrokeType(StrokeType.INSIDE);
		arc2.setFill(null);

		Arc arc3 = new Arc(232 * 2 + 1, 142 * 2 + 1, 3 * 2, 3 * 2, 250, 140);
		arc3.setType(ArcType.OPEN);
		arc3.setStroke(Color.GRAY);
		arc3.setStrokeWidth(2);
		arc3.setStrokeType(StrokeType.INSIDE);
		arc3.setFill(null);

		Arc arc4 = new Arc(312 * 2 + 1, 202 * 2 + 1, 3 * 2, 3 * 2, 250, 140);
		arc4.setType(ArcType.OPEN);
		arc4.setStroke(Color.GRAY);
		arc4.setStrokeWidth(2);
		arc4.setStrokeType(StrokeType.INSIDE);
		arc4.setFill(null);

		Line line1 = new Line(180, 290, 300, 290);
		Line turnableLine1 = new Line(340, 250, 340, 330);
		turnableLine1.setStroke(Color.BLUE);
		Line line3 = new Line(380, 290, 464, 290);
		Line line4 = new Line(180, 410, 300, 410);
		Line turnableLine2 = new Line(300, 410, 380, 410);
		turnableLine2.setStroke(Color.BLUE);
		Line line6 = new Line(380, 410, 624, 410);
		Line line7 = new Line(340, 104, 340, 250);
		Line line8 = new Line(340, 330, 340, 370);
		Line line9 = new Line(340, 450, 340, 500);
		Line line10 = new Line(590, 164, 590, 490);
		Line line11 = new Line(343, 100, 360, 100);
		Line line12 = new Line(562, 160, 582, 160);
		Line line13 = new Line(470, 262, 470, 284);
		Line line14 = new Line(630, 382, 630, 404);

		Line thickLine1 = new Line(360, 100, 434, 100);
		thickLine1.setStrokeWidth(4);
		Line thickLine2 = new Line(506, 100, 636, 100);
		thickLine2.setStrokeWidth(4);
		Line thickLine3 = new Line(470, 98, 470, 124);
		thickLine3.setStrokeWidth(4);
		Line thickLine4 = new Line(464, 160, 564, 160);
		thickLine4.setStrokeWidth(4);
		Line thickLine5 = new Line(470, 196, 470, 263);
		thickLine5.setStrokeWidth(4);
		Line thickLine6 = new Line(630, 40, 630, 64);
		thickLine6.setStrokeWidth(4);
		Line thickLine7 = new Line(630, 136, 630, 386);
		thickLine7.setStrokeWidth(4);

		Line vLine1 = new Line(360, 80, 360, 120);
		vLine1.setStrokeWidth(4);
		Line vLine2 = new Line(564, 140, 564, 180);
		vLine2.setStrokeWidth(4);

		Line hLine1 = new Line(450, 264, 490, 264);
		hLine1.setStrokeWidth(4);
		Line hLine2 = new Line(610, 386, 650, 386);
		hLine2.setStrokeWidth(4);

		emptycircle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				turnableLine1.setRotate(t.getClickCount() * 90);
			}
		});

		emptycircle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				turnableLine2.setRotate(t.getClickCount() * 90);
			}
		});

		circle4.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				ScaleTransition scaleTransition = new ScaleTransition();
				scaleTransition.setDuration(Duration.seconds(1));
				scaleTransition.setNode(vLine2);
				scaleTransition.setByY(1);
				scaleTransition.play();

				Timeline animation = new Timeline(
						new KeyFrame(Duration.seconds(2), new KeyValue(thickLine4.startXProperty(), 564)));
				animation.play();
				a = true;

				FadeTransition trans = new FadeTransition(Duration.seconds(2), line12);
				FadeTransition trans2 = new FadeTransition(Duration.seconds(2), arc2);
				FadeTransition trans3 = new FadeTransition(Duration.seconds(2), line10);
				FadeTransition trans4 = new FadeTransition(Duration.seconds(2), circle4);
				FadeTransition trans5 = new FadeTransition(Duration.seconds(2), vLine2);
				FadeTransition trans6 = new FadeTransition(Duration.seconds(2), thickLine4);

				trans.setToValue(0);
				trans2.setToValue(0);
				trans3.setToValue(0);
				trans4.setToValue(0);
				trans5.setToValue(0);
				trans6.setToValue(0);

				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						trans.play();
						trans2.play();
						trans3.play();
						trans4.play();
						trans5.play();
						trans6.play();
					}
				});
			}
		});

		circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (turnableLine1.getRotate() % 180 == 90) {
					ScaleTransition st = new ScaleTransition();
					st.setDuration(Duration.seconds(1));
					st.setNode(hLine1);
					st.setByX(1);
					st.play();

					Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),
							new KeyValue(thickLine3.startYProperty(), 166),
							new KeyValue(thickLine3.endYProperty(), 192),
							new KeyValue(thickLine5.startYProperty(), 264), new KeyValue(sc2.centerYProperty(), 228)));
					animation.play();

					if (a == false) {
						BooleanBinding intersecting = thickLine3.endYProperty().lessThanOrEqualTo(160);
						intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
							animation.stop();
							a = false;
							b = false;
							start(stage);
						});
					}

					b = true;

					Timeline animation2 = new Timeline(
							new KeyFrame(Duration.seconds(0.5), new KeyValue(thickLine3.startYProperty(), 200),
									new KeyValue(thickLine3.endYProperty(), 228),
									new KeyValue(sc2.centerYProperty(), 264), new KeyValue(sc2.lengthProperty(), 90)));

					Timeline animation3 = new Timeline(new KeyFrame(Duration.seconds(0.5),
							new KeyValue(thickLine3.startYProperty(), 238),
							new KeyValue(thickLine3.endYProperty(), 264), new KeyValue(sc2.centerYProperty(), 264 + 38),
							new KeyValue(sc2.lengthProperty(), 0)));

					Timeline animation4 = new Timeline(
							new KeyFrame(Duration.seconds(1), new KeyValue(thickLine3.startYProperty(), 264)));

					FadeTransition ft = new FadeTransition(Duration.seconds(1), circle1);
					FadeTransition ft2 = new FadeTransition(Duration.seconds(1), thickLine5);
					FadeTransition ft3 = new FadeTransition(Duration.seconds(1), thickLine3);
					FadeTransition ft5 = new FadeTransition(Duration.seconds(1), line1);
					FadeTransition ft6 = new FadeTransition(Duration.seconds(1), hLine1);
					FadeTransition ft7 = new FadeTransition(Duration.seconds(1), line3);
					FadeTransition ft8 = new FadeTransition(Duration.seconds(1), line13);
					FadeTransition ft9 = new FadeTransition(Duration.seconds(1), arc3);

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
							animation2.play();
						}
					});

					animation2.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							animation3.play();
						}
					});

					animation3.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							animation4.play();
						}
					});

					animation4.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							ft.play();
							ft2.play();
							ft3.play();
							ft5.play();
							ft6.play();
							ft7.play();
							ft8.play();
							ft8.play();
							ft9.play();
						}
					});

				}
			}
		});

		circle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (turnableLine1.getRotate() % 180 == 0 && turnableLine2.getRotate() % 180 == 90) {
					ScaleTransition st = new ScaleTransition();
					st.setDuration(Duration.seconds(1));
					st.setNode(vLine1);
					st.setByY(1);
					st.play();

					Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),
							new KeyValue(thickLine2.startXProperty(), 432), new KeyValue(thickLine2.endXProperty(), 562),
							new KeyValue(thickLine1.endXProperty(), 360), new KeyValue(sc1.centerXProperty(), 396)));
					animation.play();

					c = true;

					if (b == false) {
						BooleanBinding intersecting = thickLine2.startXProperty().lessThanOrEqualTo(472);
						intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
							animation.stop();
							a = false;
							b = false;
							c = false;
							start(stage);
						});
					}

					Timeline animation2 = new Timeline(
							new KeyFrame(Duration.seconds(0.5), new KeyValue(thickLine2.startXProperty(), 396),
									new KeyValue(thickLine2.endXProperty(), 526),
									new KeyValue(sc1.centerXProperty(), 360), new KeyValue(sc1.lengthProperty(), 90)));

					Timeline animation3 = new Timeline(new KeyFrame(Duration.seconds(0.5), new KeyValue(thickLine2.startXProperty(), 360),
									new KeyValue(thickLine2.endXProperty(), 490),
									new KeyValue(sc1.centerXProperty(), 324), new KeyValue(sc1.lengthProperty(), 0)));

					Timeline animation4 = new Timeline(
							new KeyFrame(Duration.seconds(1), new KeyValue(thickLine2.endXProperty(), 360)));

					FadeTransition ft = new FadeTransition(Duration.seconds(1), circle3);
					FadeTransition ft2 = new FadeTransition(Duration.seconds(1), sc1);
					FadeTransition ft3 = new FadeTransition(Duration.seconds(1), thickLine1);
					FadeTransition ft5 = new FadeTransition(Duration.seconds(1), line11);
					FadeTransition ft6 = new FadeTransition(Duration.seconds(1), line9);
					FadeTransition ft7 = new FadeTransition(Duration.seconds(1), thickLine2);
					FadeTransition ft8 = new FadeTransition(Duration.seconds(1), line7);
					FadeTransition ft9 = new FadeTransition(Duration.seconds(1), vLine1);
					FadeTransition ft10 = new FadeTransition(Duration.seconds(1), arc1);
					FadeTransition ft11 = new FadeTransition(Duration.seconds(1), turnableLine1);
					FadeTransition ft12 = new FadeTransition(Duration.seconds(1), emptycircle1);
					FadeTransition ft13 = new FadeTransition(Duration.seconds(1), line8);

					ft.setToValue(0);
					ft2.setToValue(0);
					ft3.setToValue(0);
					ft5.setToValue(0);
					ft6.setToValue(0);
					ft7.setToValue(0);
					ft8.setToValue(0);
					ft9.setToValue(0);
					ft10.setToValue(0);
					ft11.setToValue(0);
					ft12.setToValue(0);
					ft13.setToValue(0);

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

					animation3.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							animation4.play();
						}
					});

					animation4.setOnFinished(new EventHandler<ActionEvent>() {
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
							ft11.play();
							ft12.play();
							ft13.play();
						}
					});

				}
			}
		});

		circle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				if (turnableLine2.getRotate() % 180 == 0) {
					ScaleTransition st = new ScaleTransition();
					st.setDuration(Duration.seconds(1));
					st.setNode(hLine2);
					st.setByX(1);
					st.play();

					Timeline animation = new Timeline(
							new KeyFrame(Duration.seconds(1), new KeyValue(thickLine7.startYProperty(), 386),
									new KeyValue(thickLine6.endYProperty(), 314),new KeyValue(thickLine6.startYProperty(), 290),
									new KeyValue(sc3.centerYProperty(), 350)));
					animation.play();

					if (c == false) {
						BooleanBinding intersecting = thickLine6.endYProperty().lessThanOrEqualTo(104);
						intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
							animation.stop();
							a = false;
							b = false;
							c = false;
							start(stage);
						});
					}

					Timeline animation2 = new Timeline(
							new KeyFrame(Duration.seconds(0.5), new KeyValue(thickLine6.endYProperty(), 350),
									new KeyValue(thickLine6.startYProperty(), 326),
									new KeyValue(sc3.centerYProperty(), 386), new KeyValue(sc3.lengthProperty(), -90)));

					Timeline animation3 = new Timeline(
							new KeyFrame(Duration.seconds(0.5), new KeyValue(thickLine6.endYProperty(), 386),
									new KeyValue(thickLine6.startYProperty(), 362),
									new KeyValue(sc3.centerYProperty(), 422), new KeyValue(sc3.lengthProperty(), 0)));

					Timeline animation4 = new Timeline(
							new KeyFrame(Duration.seconds(1), new KeyValue(thickLine6.startYProperty(), 386)));

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

					animation3.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							animation4.play();
						}
					});
					
					FadeTransition ft = new FadeTransition(Duration.seconds(1), circle2);
					FadeTransition ft2 = new FadeTransition(Duration.seconds(1), thickLine6);
					FadeTransition ft3 = new FadeTransition(Duration.seconds(1), thickLine7);
					FadeTransition ft5 = new FadeTransition(Duration.seconds(1), line6);
					FadeTransition ft6 = new FadeTransition(Duration.seconds(1), hLine2);
					FadeTransition ft7 = new FadeTransition(Duration.seconds(1), line14);
					FadeTransition ft8 = new FadeTransition(Duration.seconds(1), line4);
					FadeTransition ft9 = new FadeTransition(Duration.seconds(1), arc4);
					FadeTransition ft10 = new FadeTransition(Duration.seconds(1), emptycircle2);
					FadeTransition ft11 = new FadeTransition(Duration.seconds(1), turnableLine2);

					ft.setToValue(0);
					ft2.setToValue(0);
					ft3.setToValue(0);
					ft5.setToValue(0);
					ft6.setToValue(0);
					ft7.setToValue(0);
					ft8.setToValue(0);
					ft9.setToValue(0);
					ft10.setToValue(0);
					ft11.setToValue(0);
					
					animation4.setOnFinished(new EventHandler<ActionEvent>() {
						@Override
						public void handle(ActionEvent event) {
							ft.play();
							ft2.play();
							ft3.play();
							ft5.play();
							ft6.play();
							ft7.play();
							ft8.play();
							ft8.play();
							ft9.play();
							ft10.play();
							ft11.play();
						}
					});
				}
			}
		});

		// Creating a Group object
		Group root = new Group(circle1, circle2, circle3, circle4, emptycircle1, emptycircle2, sc1, sc2, sc3, line1,
				turnableLine1, line3, line4, turnableLine2, line6, line7, line8, line9, line10, line11, line12, line13,
				line14, thickLine1, thickLine2, thickLine3, thickLine4, thickLine5, thickLine6, thickLine7, vLine1,
				vLine2, hLine1, hLine2, arc1, arc2, arc3, arc4);

		// Creating a scene object
		Scene scene = new Scene(root, 840, 600, Color.WHITESMOKE);

		// Setting title to the Stage
		stage.setTitle("Level 5");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();
	}

	public static void main(String args[]) {
		launch(args);
	}
}
