package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lab 06");

        Group root = new Group();
        Canvas canvas = new Canvas(300, 300);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.setFill(Color.BLACK);
        gc.setStroke(Color.MAGENTA);
        gc.fillText("Pie Chart", 125, 40);
        gc.strokeRect(20,20, 260,260);

        gc.setFill(Color.RED);
        gc.fillArc(50,70, 200, 200,0,20, ArcType.ROUND);
        gc.setFill(Color.YELLOW);
        gc.fillArc(50,70, 200, 200,20,40, ArcType.ROUND);
        gc.setFill(Color.BLUE);
        gc.fillArc(50,70, 200, 200,60,60, ArcType.ROUND);


        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
