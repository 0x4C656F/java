module com.paint {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.paint to javafx.fxml;
    exports com.paint;
}
