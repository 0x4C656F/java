package com.student_management_tool.entity;



import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Student {
    private final SimpleStringProperty name;
    private final SimpleIntegerProperty age;
    private final SimpleStringProperty email;
    private final String id;

    public Student(String id, String name, int age, String email) {
        this.id = id;
        this.name = new SimpleStringProperty(name);
        this.age = new SimpleIntegerProperty(age);
        this.email = new SimpleStringProperty(email);
    }

    public String getName() { return name.get(); }
    public void setName(String fName) { name.set(fName); }

    public int getAge() { return age.get(); }
    public void setAge(int fAge) { age.set(fAge); }

    public String getEmail() { return email.get(); }

    public SimpleStringProperty nameProperty() { return name; }
    public SimpleIntegerProperty ageProperty() { return age; }
    public SimpleStringProperty emailProperty() { return email; }
    public String getId() { return id; }
}
