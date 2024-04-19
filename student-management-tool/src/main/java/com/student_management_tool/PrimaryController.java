package com.student_management_tool;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;



import com.student_management_tool.database.Database;
import com.student_management_tool.entity.Student;
public class PrimaryController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private TextField ageTextField;

    @FXML
    private TableView<Student> table;

public void initialize(){
    ObservableList<Student> students = FXCollections.observableArrayList(Database.getAllStudents());

    TableColumn<Student, String> nameColumn = new TableColumn<>("Name");
    nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
    nameColumn.setMinWidth(100);


    TableColumn<Student, Integer> ageColumn = new TableColumn<>("Age");
    ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));


    TableColumn<Student, String> emailColumn = new TableColumn<>("Email");
    emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
    emailColumn.setMinWidth(200);
    
    TableColumn<Student, Void> removeColumn = new TableColumn<>("Action");
    removeColumn.setMinWidth(100);

    removeColumn.setCellFactory(col -> new TableCell<Student, Void>() {
    private final Button removeButton = new Button("Remove");
    
    {
        removeButton.setOnAction(event -> {
            Student student = getTableView().getItems().get(getIndex());
            getTableView().getItems().remove(student);
            try{
                Database.removeStudentById(student.getId());
            }catch(Exception e){
                System.out.println("Error removing student: " + e.getMessage());
            }
        });
    }

    @Override
    protected void updateItem(Void item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || getIndex() >= getTableView().getItems().size()) {
            setGraphic(null);
        } else {
            setGraphic(removeButton);
        }
    }
});



    table.getColumns().addAll(nameColumn, ageColumn, emailColumn,removeColumn);
    table.getStyleClass().add("students-table-view ");
    table.setItems(students);
}

    @FXML
    private void handleAddStudent() {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String age = ageTextField.getText();
        try{
        Student student = Database.addStudent(name, Integer.parseInt(age), email);
        table.getItems().add(student);
        }catch(Exception e){
            System.out.println("Error adding student: " + e.getMessage());
        }

        nameTextField.clear();
        emailTextField.clear();
        ageTextField.clear();
    }


}
