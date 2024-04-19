package com.project_1_gui_and_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
//This file contains both part 3 and part 4. Since i recorded video when only part 3 was in assigment, i will explain part 4 in comments below. Please dont hit me.
public class Part3And4 extends Application {

    @Override
    public void start(Stage stage) {

        // Part 3. Build questionary for AUK applicant

        //The layout thingy
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10));

        // Program
        TextField nameField = new TextField();
        TextField emailField = new TextField();
        ComboBox<String> programComboBox = new ComboBox<>();
        programComboBox.getItems().addAll("BSE", "BDS", "BBA", "BGM");

        // Gender. Only 2 options, as in AUK application form.
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        maleRadio.setToggleGroup(genderGroup);
        RadioButton femaleRadio = new RadioButton("Female");
        femaleRadio.setToggleGroup(genderGroup);

        // Interests. Since i don't really remember the options, i will just put some random ones.
        CheckBox codingCheckBox = new CheckBox("Coding");
        CheckBox sportsCheckBox = new CheckBox("Sports");
        CheckBox artsCheckBox = new CheckBox("Arts");
        CheckBox musicCheckBox = new CheckBox("Music");

        
        TextArea reportArea = new TextArea();

        

        // I wanted to implement validation checking, but i am not getting paid for it). Maybe there is a way to do it with JavaFX, but i am not aware of it.
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
                
                StringBuilder report = new StringBuilder();
                report.append("Name: ").append(nameField.getText()).append("\n");
                report.append("Email: ").append(emailField.getText()).append("\n");
                report.append("Program: ").append(programComboBox.getValue()).append("\n");
                report.append("Gender: ").append(maleRadio.isSelected() ? "Male" : "Female").append("\n");
                report.append("Interests: ")
                      .append(codingCheckBox.isSelected() ? "Coding, " : "")
                      .append(sportsCheckBox.isSelected() ? "Sports, " : "")
                      .append(artsCheckBox.isSelected() ? "Arts" : "")
                      .append(musicCheckBox.isSelected() ? "Music" : "")
                      .append("\n");
                try{
                    saveToFile(nameField.getText(),report.toString());
                }catch(IOException ex){
                    System.out.println("Run it from java directory: " + ex.getMessage());
                }
                reportArea.setText(report.toString());
        });


        gridPane.add(new Label("Name:"), 0, 0);
        gridPane.add(nameField, 1, 0);

        
        gridPane.add(new Label("Email:"), 0, 1);
        gridPane.add(emailField, 1, 1);
     
        
        gridPane.add(new Label("Program:"), 0, 2);
        gridPane.add(programComboBox, 1, 2);
        
        gridPane.add(new Label("Gender:"), 0, 3);
        VBox genderBox = new VBox(5, maleRadio, femaleRadio);
        gridPane.add(genderBox, 1, 3);
        
        gridPane.add(new Label("Interests:"), 0, 4);
        VBox interestsBox = new VBox(5, codingCheckBox, sportsCheckBox, artsCheckBox);
        gridPane.add(interestsBox, 1, 4);
        
        gridPane.add(submitButton, 1, 5);
        gridPane.add(reportArea, 0, 6, 3, 1);

    
        Scene scene = new Scene(gridPane, 600, 400);
        stage.setScene(scene);
        stage.setTitle("AUK Application Form");
        stage.show();
    }

    public void saveToFile(String stdName,String data) throws IOException{
        // Part 4. File I/O App
        // This code creates file if it is not present and edits file if it is present. Nothing fancy.
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("project1_gui_and_io/src/main/java/com/project_1_gui_and_io/"+stdName + ".txt"))){
            writer.write(data);

        };
    
    }        
    public static void main(String[] args) {
        launch(args);
    }
}


