package com.project_1_gui_and_io;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

// This is the second part of Project 1: Gui and I/O . Just run it. It's madness. I like it. 
// It does not make any sense, but i demonstrates that i can do smthing. Even if this smthing is pointless. 
public class Part2 extends Application {

    @Override
    public void start(Stage stage) {

        // Shapes
        Circle circle = new Circle(50, Color.BLUE);
        circle.setOpacity(0.5);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);

        Rectangle rectangle = new Rectangle(100, 60, Color.RED);
        rectangle.setOpacity(0.5);
        rectangle.setStroke(Color.BLACK);
        rectangle.setStrokeWidth(2);
        rectangle.setStrokeLineCap(StrokeLineCap.ROUND);
        rectangle.setStrokeLineJoin(StrokeLineJoin.MITER);
        rectangle.getStrokeDashArray().addAll(10d, 5d);

        Ellipse ellipse = new Ellipse(50, 30);
        ellipse.setFill(Color.YELLOW);
        ellipse.setStroke(Color.BLACK);
        ellipse.setStrokeWidth(2);

        Line line = new Line(0, 0, 100, 100);
        line.setStroke(Color.GREEN);
        line.setStrokeWidth(2);

        Polyline polyline = new Polyline();
        polyline.getPoints().addAll(0.0, 0.0, 50.0, 30.0, 10.0, 60.0);
        polyline.setStrokeWidth(2);
        polyline.setStroke(Color.ORANGE);

        Text text = new Text("JavaFX Layouts");

        // Pane with circle and rectangle
        Pane pane = new Pane();
        pane.getChildren().addAll(circle, rectangle);
        rectangle.setX(150); 

        // HBox with ellipse
        HBox hbox = new HBox(ellipse);
        hbox.setAlignment(Pos.CENTER_RIGHT);
        hbox.setPadding(new Insets(10));

        // VBox with line and polyline
        VBox vbox = new VBox(10, line, polyline);
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(15));

        // GridPane with text
        GridPane gridPane = new GridPane();
        gridPane.add(text, 0, 0);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));

        
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hbox);
        borderPane.setLeft(vbox);
        borderPane.setCenter(gridPane);
        borderPane.setBottom(pane);
        BorderPane.setAlignment(pane, Pos.BOTTOM_LEFT);
        borderPane.setPadding(new Insets(20)); 

      
        Scene scene = new Scene(borderPane, 400, 400);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
