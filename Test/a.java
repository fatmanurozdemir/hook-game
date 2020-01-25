import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.binding.BooleanBinding;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class a extends Application {

    @Override
    public void start(Stage primaryStage) {
        Line line = new Line(100, 200, 200, 200);
        Line line1= new Line(350,50,350,300);

        BooleanBinding intersecting = line.endXProperty().greaterThanOrEqualTo(350);
        intersecting.addListener((obs, wasIntersecting, isNowIntersecting) -> {
            System.out.println("Collision!");
        });

        Timeline animation = new Timeline(
                new KeyFrame(Duration.seconds(1.5), new KeyValue(line.endXProperty(), 400))
        );
        animation.setCycleCount(1);
        animation.play();


        Pane root = new Pane(line);
        root.getChildren().add(line1);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}