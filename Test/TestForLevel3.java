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

public class TestForLevel3 extends Application {
	boolean a = false;
	boolean b = false;
	TestForLevel4 tf4 = new TestForLevel4();
	@Override
	public void start(Stage stage) {
		// Creating circles
		Circle circle1 = new Circle(70 * 2, 190 * 2, 20 * 2, Color.BLACK);
		Circle circle2 = new Circle(130 * 2, 220 * 2, 20 * 2, Color.BLACK);
		Circle circle3 = new Circle(190 * 2, 260 * 2, 20 * 2, Color.BLACK);

		// Creating semi-circles
		Arc sc1 = new Arc(330 * 2, 52 * 2 - 2, 20 * 2, 20 * 2, 0, 180);
		sc1.setType(ArcType.OPEN);
		sc1.setStrokeWidth(4);
		sc1.setStroke(Color.BLACK);
		sc1.setStrokeType(StrokeType.INSIDE);
		sc1.setFill(null);

		Arc sc2 = new Arc(328 * 2 + 2, 110 * 2, 20 * 2, 20 * 2, 90, -180);
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

		Arc cArc3 = new Arc(228 * 2 - 1, 218 * 2 - 1, 3 * 2, 3 * 2, 250, 140);
		cArc3.setType(ArcType.OPEN);
		cArc3.setStroke(Color.GRAY);
		cArc3.setStrokeWidth(2);
		cArc3.setStrokeType(StrokeType.INSIDE);
		cArc3.setFill(null);

		Arc cArc4 = new Arc(328 * 2 - 1, 188 * 2 - 1, 3 * 2, 3 * 2, 250, 140);
		cArc4.setType(ArcType.OPEN);
		cArc4.setStroke(Color.GRAY);
		cArc4.setStrokeWidth(2);
		cArc4.setStrokeType(StrokeType.INSIDE);
		cArc4.setFill(null);

		// Creating lines
		Line line1 = new Line(380, 104, 190 * 2, 240 * 2);
		Line line2 = new Line(460, 112 * 2, 230 * 2, 218 * 2);
		Line line3 = new Line(180, 190 * 2, 328 * 2, 380);
		Line line4 = new Line(280, 220 * 2, 456, 440);
		Line line5 = new Line(384, 100, 200 * 2, 100);
		Line line6 = new Line(464, 110 * 2, 240 * 2, 110 * 2);
		Line line7 = new Line(660, 180 * 2, 330 * 2, 188 * 2);

		Line vLine1 = new Line(400, 80, 400, 120);
		vLine1.setStrokeWidth(4);
		Line vLine2 = new Line(240 * 2, 100 * 2, 240 * 2, 120 * 2);
		vLine2.setStrokeWidth(4);

		Line hLine = new Line(320 * 2, 180 * 2, 340 * 2, 180 * 2);
		hLine.setStrokeWidth(4);

		Line thickLine1 = new Line(400, 100, 620, 100);
		thickLine1.setStrokeWidth(4);
		Line thickLine2 = new Line(700, 100, 760, 100);
		thickLine2.setStrokeWidth(4);
		Line thickLine3 = new Line(480, 220, 660, 220);
		thickLine3.setStrokeWidth(4);
		Line thickLine4 = new Line(330 * 2, 47 * 2, 330 * 2, 90 * 2);
		thickLine4.setStrokeWidth(4);
		Line thickLine5 = new Line(330 * 2, 130 * 2, 330 * 2, 180 * 2);
		thickLine5.setStrokeWidth(4);

		// Creating a Group object
		Group root = new Group(circle1, circle2, circle3, line1, line2, line3, line4, line5, line6, line7, vLine1,
				vLine2, hLine, thickLine1, thickLine2, thickLine3, thickLine4, thickLine5, sc1, sc2, cArc1, cArc2,
				cArc3, cArc4);
		
		circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(hLine);
				st.setByX(1);
				st.play();

				Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine4.startYProperty(), 196), new KeyValue(thickLine4.endYProperty(), 282)));
				animation.play();
				b = true;
				
				Timeline animation10 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine4.startYProperty(), 360)));

				Timeline animation6 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine4.startYProperty(), 274), new KeyValue(thickLine4.endYProperty(), 360)));

				Timeline animation2 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine5.startYProperty(), 360)));
				animation2.play();
				
				Timeline animation3 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(sc2.lengthProperty(), 0)));

				Timeline animation4 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(sc2.centerYProperty(), 320)));
				animation4.play();
				
				Timeline animation5 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(sc2.centerYProperty(), 400)));

				if (a == false) {
					BooleanBinding intersecting = thickLine4.endYProperty().lessThanOrEqualTo(220);
					intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
						animation.stop();
						animation2.stop();
						animation4.stop();
						a = false;
						b = false;
						start(stage);
					});
				}

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

				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation3.play();
						animation5.play();
						animation6.play();
					}
				});
				animation6.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation10.play();
					}
				});
				animation10.setOnFinished(new EventHandler<ActionEvent>() {
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
		circle2.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(vLine2);
				st.setByY(1);
				st.play();

				Timeline animation = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine3.endXProperty(), 480)));
				animation.setCycleCount(1);
				animation.play();
				a = true;

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
		circle3.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				ScaleTransition st = new ScaleTransition();
				st.setDuration(Duration.seconds(1));
				st.setNode(vLine1);
				st.setByY(1);
				st.play();

				Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine2.startXProperty(), 480), new KeyValue(thickLine2.endXProperty(), 540)));
				animation.setCycleCount(1);
				animation.play();
				Timeline animation6 = new Timeline(new KeyFrame(Duration.seconds(1),
						new KeyValue(thickLine2.startXProperty(), 400), new KeyValue(thickLine2.endXProperty(), 460)));
				animation6.setCycleCount(1);
				Timeline animation10 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine2.endXProperty(), 400)));
				animation10.setCycleCount(1);
				Timeline animation2 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(thickLine1.endXProperty(), 400)));
				animation2.setCycleCount(1);
				animation2.play();
				Timeline animation3 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(sc1.lengthProperty(), 0)));
				animation3.setCycleCount(1);
				Timeline animation4 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(sc1.centerXProperty(), 440)));
				animation4.setCycleCount(1);
				animation4.play();
				Timeline animation5 = new Timeline(
						new KeyFrame(Duration.seconds(1), new KeyValue(sc1.centerXProperty(), 360)));
				animation5.setCycleCount(1);
				if (b == false) {
					BooleanBinding intersecting = thickLine2.startXProperty().lessThanOrEqualTo(660);
					intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
						animation.stop();
						animation2.stop();
						animation4.stop();
						b = false;
						a = false;

						start(stage);
					});
				}

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
				animation.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation3.play();
						animation5.play();
						animation6.play();
						ft10.play();
					}
				});
				animation6.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						animation10.play();
					}
				});
				animation10.setOnFinished(new EventHandler<ActionEvent>() {
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
				
				ft9.setOnFinished(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						tf4.start(stage);
					}
				});
			}
		});
		// Creating a scene object
		Scene scene = new Scene(root, 420 * 2, 300 * 2, Color.WHITESMOKE);

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