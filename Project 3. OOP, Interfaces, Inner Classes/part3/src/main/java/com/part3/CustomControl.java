package com.part3;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CustomControl extends HBox {
    private Button button;
    private int controlNumber;

    public CustomControl(int controlNumber, ControlClickedHandler handler) {
        this.controlNumber = controlNumber;
        button = new Button("Control " + controlNumber);
        button.setOnAction(event -> handler.onControlClicked(controlNumber));
        this.getChildren().add(button);
    }
}
