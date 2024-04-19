package com.project_1_gui_and_io;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

 // This is the first part of Project 1: Gui and I/O . 
 // This app simulates the flow from one input element to another with the help of buttons and text fields.
public class Part1 extends Application {
 

    @Override
    public void start(Stage stage) throws IOException {
        VBox root = new VBox(10);
        Scene scene = new Scene(root, 500, 500);
        TextArea textArea1 = new TextArea("I am a text,area, press action 1");
        Button button1 = new Button("Run the action 1");
        TextField textField2 = new TextField("Press enter while focus");
        textField2.setEditable(false);
        
        button1.setOnAction(e -> {
            String text = textArea1.getText();
            textArea1.clear();
            textField2.setText(text);
        });
        Label label1 = new Label("If you press enter on the text field above, magic will happen");

        textField2.setOnAction(e -> {
            String text = textField2.getText();
            textField2.clear();
            label1.setText(text);
        });
        TextField textField3 = new TextField();
        Button button2 = new Button("Run the action 2");
        button2.setOnAction(e -> {
            String text = label1.getText();
            label1.setText("");
            textField3.setText(text);
        });
        Button button3 = new Button("Restart to phase 1");
        button3.setOnAction(e -> {
            String text = textField3.getText();
            textField3.clear();
            textArea1.setText(text);

        });

        root.getChildren().addAll( textArea1, button1, textField2,label1, button2, textField3, button3);
        stage.setScene(scene);
        stage.show();
    }

    

    public static void main(String[] args) {
        launch();
    }

}