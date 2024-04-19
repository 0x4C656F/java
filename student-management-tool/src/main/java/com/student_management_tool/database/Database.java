package com.student_management_tool.database;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import com.student_management_tool.entity.Student;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class Database {



    private static final String PATH = "student-management-tool/src/main/java/com/student_management_tool/database/students.txt";

    public static void initialize() throws IOException {
            createDbFiles();
    }

    private static void createDbFiles() throws IOException {
        File file = new File(PATH);
        if (file.exists()) {
           try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
             String firstLine = reader.readLine();

             if (firstLine == null || !firstLine.equals("id,name,age,email")) {
                    String oldContent = new String(Files.readAllBytes(Paths.get(PATH)));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));

                    writer.write("id,name,age,email\n");
                    writer.write(oldContent);
                    writer.close();
                }
            }
        } else {
           file.createNewFile();
           BufferedWriter writer = new BufferedWriter(new FileWriter(PATH));
           writer.write("id,name,age,email;\n");
           writer.close();
    }
}

    public static Student addStudent(String name, int age, String email) throws IOException{
        String id = UUID.randomUUID().toString();
        Student student = new Student(id,name, age, email);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))){
            writer.write(id + "," + name + "," + age + "," + email + "\n");
            return student;
        }
    }

    public static void removeStudentById(String id) throws IOException {

        List<Student> students = getAllStudents();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))){
        
        writer.write("id,name,age,email\n");
        for (Student student : students) {
            if (!student.getId().equals(id)) {
                writer.write(student.getId() + "," + student.getName() + "," + student.getAge() + "," + student.getEmail() + "\n");
            }
        }
    }catch(IOException e){
        System.out.println("Error removing student: " + e.getMessage());
    }
    }

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if(parts[0].equals("id")){
                    continue;
                }
                if (parts.length == 4) {
                    try {
                        Student student = new Student(parts[0], parts[1], Integer.parseInt(parts[2]), parts[3]);
                        students.add(student);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid age in line: " + line);
                    }
                } else {
                    System.out.println("Invalid line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading students: " + e.getMessage());
        }
        return students;
    }
}
