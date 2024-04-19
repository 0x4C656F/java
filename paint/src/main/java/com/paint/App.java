package com.paint;

import javafx.application.Application;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class App extends Application {
    public int SIZE = 5;
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);
        

        Circle circle = new Circle(SIZE);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(1);
        Canvas canvas = new Canvas(800, 600);
        root.getChildren().add(circle);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        ColorPicker colorPicker = new ColorPicker();
        
        root.getChildren().addAll(colorPicker, canvas);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Simple Paint App");
        primaryStage.show();
        canvas.setOnMouseMoved(e -> {
            circle.setTranslateX(e.getX() + SIZE + 10);
            circle.setTranslateY(e.getY() + SIZE + 10);
        });
        canvas.setOnMouseEntered(e -> {
            canvas.setCursor(Cursor.NONE);
            circle.setVisible(true);
        });
        canvas.setOnMouseExited(e -> {
            canvas.setCursor(Cursor.DEFAULT);
            circle.setVisible(false);
        });
        canvas.setOnMouseDragged(e -> {
            circle.setTranslateX(e.getX() + SIZE + 10 );
            circle.setTranslateY(e.getY() + SIZE + 10);
            double x = e.getX() - SIZE / 2;
            double y = e.getY() - SIZE / 2;
            
            gc.setFill(colorPicker.getValue());
            gc.fillOval(x, y, SIZE, SIZE);
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
