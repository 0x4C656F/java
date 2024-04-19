module com.project_1_gui_and_io {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.project_1_gui_and_io to javafx.fxml;
    exports com.project_1_gui_and_io;
}
