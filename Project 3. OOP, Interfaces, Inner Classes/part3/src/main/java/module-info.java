module com.part3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.part3 to javafx.fxml;
    exports com.part3;
}
