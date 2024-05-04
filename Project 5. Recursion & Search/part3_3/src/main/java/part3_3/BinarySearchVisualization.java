package part3_3;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

public class BinarySearchVisualization extends Application {

    private TextField arraySizeInput;
    private TextField searchValueInput;
    private Slider speedSlider;
    private Label statusLabel;
    private Button searchButton;
    private Canvas canvas;
    private GraphicsContext gc;
    private Timeline timeline;

    @Override
    public void start(Stage primaryStage) {
        arraySizeInput = new TextField();
        arraySizeInput.setPromptText("Enter array size");

        searchValueInput = new TextField();
        searchValueInput.setPromptText("Enter search value");

        speedSlider = new Slider(0, 1000, 500);

        searchButton = new Button("Start Search");
        searchButton.setOnAction(e -> startSearch());

        statusLabel = new Label("Status");

        canvas = new Canvas(400, 200);
        gc = canvas.getGraphicsContext2D();

        VBox layout = new VBox(10, statusLabel, arraySizeInput, searchValueInput, speedSlider, searchButton, canvas);
        layout.setSpacing(10);

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(layout);
        scrollPane.setFitToWidth(true);

        Scene scene = new Scene(scrollPane, 420, 400);

        primaryStage.setTitle("Binary Search Visualization");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void startSearch() {
        int arraySize = Integer.parseInt(arraySizeInput.getText());
        int[] array = new int[arraySize];
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 2;
        }

        int key = Integer.parseInt(searchValueInput.getText());
        binarySearchWithVisualization(array, key);
    }

    private void binarySearchWithVisualization(int[] array, int key) {
        final int[] low = {0};
        final int[] high = {array.length - 1};
        final int[] iterCount = {0};

        timeline = new Timeline();
        int duration = (int) speedSlider.getValue();
        timeline.getKeyFrames().add(new KeyFrame(Duration.millis(duration), event -> {
            int mid = (low[0] + high[0]) / 2;
            iterCount[0]++;
            statusLabel.setText(String.format("Iter: %d, Range: %d-%d (size: %d), Mid: %d (value: %d)",
                    iterCount[0], low[0], high[0], (high[0] - low[0] + 1), mid, array[mid]));
            drawArray(array, low[0], mid, high[0]);
            if (low[0] <= high[0]) {
                if (array[mid] < key) {
                    low[0] = mid + 1;
                } else if (array[mid] > key) {
                    high[0] = mid - 1;
                } else {
                    statusLabel.setText("Value found at index: " + mid + " after " + iterCount[0] + " iterations");
                    timeline.stop();
                }
            } else {
                statusLabel.setText("Value not found after " + iterCount[0] + " iterations");
                timeline.stop();
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void drawArray(int[] array, int low, int mid, int high) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        double rectWidth = canvas.getWidth() / array.length;

        for (int i = 0; i < array.length; i++) {
            if (i >= low && i <= high) {
                if (i == mid) {
                    gc.setFill(Color.RED); // Current mid
                } else {
                    gc.setFill(Color.BLUE); // Search range
                }
            } else {
                gc.setFill(Color.GRAY); // Inactive part of the array
            }
            gc.fillRect(i * rectWidth, 0, rectWidth, 50);
            gc.setFill(Color.BLACK);
            gc.fillText(String.valueOf(array[i]), i * rectWidth + 2, 40);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
