import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.Duration;

public class Method {
	
	// DÝK LÝNE UZATIYOR
	public void boyUzatma(Line line) {
		ScaleTransition scaleTransition = new ScaleTransition();
		scaleTransition.setDuration(Duration.seconds(1));
		scaleTransition.setNode(line);
		scaleTransition.setByY(1);
		scaleTransition.play();
	}

	// YAN LÝNE UZATIYOR
	public void enUzatma(Line line) {
		ScaleTransition scaleTransition = new ScaleTransition();
		scaleTransition.setDuration(Duration.seconds(1));
		scaleTransition.setNode(line);
		scaleTransition.setByX(1);
		scaleTransition.play();
	}

	// dik LÝNELARI KISALTIYOR circle1 i yok ediyor(en son her seyi yok ediyor)
	public void dikKaydýrma(Line line, int x, Circle circle, Line hLine, Line line2) {
		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(line.endYProperty(), x)));
		animation.play();

		FadeTransition trans = new FadeTransition(Duration.seconds(1), circle);
		FadeTransition trans2 = new FadeTransition(Duration.seconds(1), hLine);
		FadeTransition trans3 = new FadeTransition(Duration.seconds(1), line2);
		FadeTransition trans4 = new FadeTransition(Duration.seconds(1), line);

		trans.setToValue(0);
		trans2.setToValue(0);
		trans3.setToValue(0);
		trans4.setToValue(0);

		animation.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				trans.play();
				trans2.play();
				trans3.play();
				trans4.play();
			}
		});
	}

	// sc yi kaydýrýp yok ediyor, thickline3 ü yok ediyor(kaydýrmýyor!)(en son
	// her seyi yok ediyor)
	public void yanKaydýrma(Arc sc, int x, int y, int z, int a, int b, Line thickLine, Line thickLine2, int k,
			Line vLine1, Line line1, Line line3, Line line4, Arc arc2, Arc arc3, Circle circle2) {

		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(sc.centerXProperty(), x)));
		animation.play();
		Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(sc.lengthProperty(), y)));
		Timeline animation3 = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(sc.centerXProperty(), z)));
		Timeline animation4 = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(sc.lengthProperty(), a)));
		Timeline animation5 = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(sc.centerXProperty(), b)));
		Timeline animation6 = new Timeline(
				new KeyFrame(Duration.seconds(1), new KeyValue(thickLine.endXProperty(), z)));

		FadeTransition trans = new FadeTransition(Duration.seconds(1), circle2);
		FadeTransition trans2 = new FadeTransition(Duration.seconds(1), vLine1);
		FadeTransition trans3 = new FadeTransition(Duration.seconds(1), line1);
		FadeTransition trans4 = new FadeTransition(Duration.seconds(1), line3);
		FadeTransition trans5 = new FadeTransition(Duration.seconds(1), line4);
		FadeTransition trans6 = new FadeTransition(Duration.seconds(1), thickLine2);
		FadeTransition trans7 = new FadeTransition(Duration.seconds(1), arc2);
		FadeTransition trans8 = new FadeTransition(Duration.seconds(1), arc3);

		trans.setToValue(0);
		trans2.setToValue(0);
		trans3.setToValue(0);
		trans4.setToValue(0);
		trans5.setToValue(0);
		trans6.setToValue(0);
		trans7.setToValue(0);
		trans8.setToValue(0);

		animation.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				animation3.play();
				animation2.play();
				animation4.play();
				animation5.play();
			
			/* thickLine2 bir türlü kaybolmuyor
				yokEtme(thickLine2);*/
			}
		});
		animation5.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				animation6.play();
			}
		});
		animation6.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				trans.play();
				trans2.play();
				trans3.play();
				trans4.play();
				trans5.play();
				trans6.play();
				trans7.play();
				trans8.play();
			}
		});
	}

	// thickline2 yi KISALTIYOR
	public void yokederekyanKaydýrma(Line line, int x) {

		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(line.endXProperty(), x)));
		animation.play();

	}

	/* thickline3 ü kaydýrýyor (yok etmiyor!)
	public void yanKaydýrma2(Line line, int x, int y, int z, int m) {

		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(2), new KeyValue(line.startXProperty(), x),
				new KeyValue(line.endXProperty(), y)));
		animation.setCycleCount(1);
		animation.play();
		Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(2), new KeyValue(line.startXProperty(), z),
				new KeyValue(line.endXProperty(), m)));
		animation2.setCycleCount(1);

		animation.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				animation2.play();
			}
		});
	}*/
	
	// thickline3 ü kaydýrýyor (yok etmiyor!)
	public void yanKaydýrma2(Line line, Line line2, int x, int y,int a, int b, int z, int m) {
		TranslateTransition tt = new TranslateTransition(Duration.millis(2000),line);
		tt.setByX(-40);
		tt.play();
		/*
		Timeline animation = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(line.startXProperty(), x),
				new KeyValue(line.endXProperty(), y)));
		animation.play();*/
		
		tt.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (line.getStartX() == line2.getStartX()) {
					//
				} else {
					Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(1),
							new KeyValue(line.startXProperty(), z), new KeyValue(line.endXProperty(), m)));
					Timeline animation3 = new Timeline(new KeyFrame(Duration.seconds(1),
							new KeyValue(line.startXProperty(), a), new KeyValue(line.endXProperty(), b)));
					animation2.play();
					animation3.play();
				}
			}
		});

			
		
		/*else{
		Timeline animation2 = new Timeline(new KeyFrame(Duration.seconds(1), new KeyValue(line.startXProperty(), z),
				new KeyValue(line.endXProperty(), m)));

		animation.setOnFinished(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.print(line.getStartX());
				
				animation2.play();

			}
		});
		}*/

	}

	// arc siliyor
	public void yokEtme(Arc arc) {
		FadeTransition ft = new FadeTransition(Duration.seconds(1), arc);
		ft.setToValue(0);
		ft.play();
	}

	// LÝNELARI SÝLÝYOR
	public void yokEtme(Line line) {
		FadeTransition ft = new FadeTransition(Duration.seconds(1), line);
		ft.setToValue(0);
		ft.play();
	}
}
