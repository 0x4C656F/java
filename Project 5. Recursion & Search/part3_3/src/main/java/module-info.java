module part3_3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens part3_3 to javafx.fxml;
    exports part3_3;
}
