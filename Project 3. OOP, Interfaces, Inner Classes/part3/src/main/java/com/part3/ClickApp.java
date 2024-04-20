package com.part3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ClickApp extends Application {

    private Label infoLabel;

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        infoLabel = new Label("No control selected");

        ControlClickedHandler handler = controlNumber -> infoLabel.setText("Selected control: Control " + controlNumber);

        for (int i = 0; i < 7; i++) {
            CustomControl customControl = new CustomControl(i, handler);
            root.getChildren().add(customControl);
        }

        root.getChildren().add(infoLabel);
        Scene scene = new Scene(root, 300, 200);
        primaryStage.setTitle("ClickApp");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
