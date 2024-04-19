module com.student_management_tool {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.student_management_tool to javafx.fxml;
    exports com.student_management_tool;
    opens com.student_management_tool.entity to javafx.base;
}
 