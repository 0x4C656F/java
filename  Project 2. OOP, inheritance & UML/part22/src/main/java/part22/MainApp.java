package part22;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
//2.2. Inheritance example 
public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false);
        displayArea.setPrefHeight(300);

        BaseMessage[] messages = {
            new TextMessage("Alice", "Hello!"),
            new ImageMessage("Bob", "http://example.com/image.jpg"),
            new VoiceMessage("Charlie", "http://example.com/audio.mp3"),
            new FileMessage("Dave", "/path/to/file.pdf"),
            new LocationMessage("Eve", "http://maps.example.com/location"),
            new ContactMessage("Frank", "Grace", "+1234567890")
        };

        for (BaseMessage msg : messages) {
            displayArea.appendText(msg.render()); 
        }

        root.getChildren().add(displayArea);
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
