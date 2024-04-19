package com.space_invaders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
 import javafx.stage.Stage;
import java.io.IOException;

public class App extends Application {


    private static Scene scene;

    @SuppressWarnings("exports")
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(), 600, 800);
        stage.setScene(scene);
        stage.show();
        setBackground();
    }

    private void setBackground(){
        Image bgImage = new Image(getClass().getResourceAsStream("/images/bg.png"));

        BackgroundImage backgroundImage = new BackgroundImage(bgImage,
        BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
        BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        ((AnchorPane) scene.getRoot()).setBackground(background);
    
    }

    private static Parent loadFXML() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("main.fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}