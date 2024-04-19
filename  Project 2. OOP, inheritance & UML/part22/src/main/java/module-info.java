module part22 {
    requires javafx.controls;
    requires javafx.fxml;

    opens part22 to javafx.fxml;
    exports part22;
}
