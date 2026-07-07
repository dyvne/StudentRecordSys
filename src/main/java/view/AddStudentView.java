package view;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Student;
import service.StudentManager;

public class AddStudentView {

    private StudentManager manager;

    public AddStudentView(StudentManager manager) {
        this.manager = manager;
    }

    public void show(Stage stage) {

        TextField idField = new TextField();
        idField.setPromptText("Student ID");

        TextField firstNameField = new TextField();
        firstNameField.setPromptText("First Name");

        TextField lastNameField = new TextField();
        lastNameField.setPromptText("Last Name");

        //  FIXED: Use ComboBox instead of TextField
        ComboBox<String> genderField = new ComboBox<>();
        genderField.getItems().addAll("Male", "Female");
        genderField.setPromptText("Select Gender");

        TextField programmeField = new TextField();
        programmeField.setPromptText("Programme");

        TextField levelField = new TextField();
        levelField.setPromptText("Level");

        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        TextField searchField = new TextField();
        searchField.setPromptText("Enter Student ID to Search");

        Button addButton = new Button("Add Student");
        Button searchButton = new Button("Search Student");
        Button deleteButton = new Button("Delete Student");
        Button updateButton = new Button("Update Student");
        Button viewButton = new Button("View Students");

        Label message = new Label();

        // ADD STUDENT
        addButton.setOnAction(e -> {
            try {
                Student student = new Student(
                        idField.getText(),
                        firstNameField.getText(),
                        lastNameField.getText(),
                        genderField.getValue(),
                        programmeField.getText(),
                        Integer.parseInt(levelField.getText()),
                        emailField.getText()
                );

                manager.addStudent(student);
                message.setText("Student Added Successfully!");

            } catch (Exception ex) {
                message.setText("Error: Invalid input!");
            }
        });

        //  SEARCH
        searchButton.setOnAction(e -> {
            Student student = manager.searchStudent(searchField.getText());

            if (student != null) {
                idField.setText(student.getStudentId());
                firstNameField.setText(student.getFirstName());
                lastNameField.setText(student.getLastName());
                genderField.setValue(student.getGender());
                programmeField.setText(student.getProgramme());
                levelField.setText(String.valueOf(student.getLevel()));
                emailField.setText(student.getEmail());

                message.setText("Student Found!");
            } else {
                message.setText("Student not found.");
            }
        });

        //  DELETE
        deleteButton.setOnAction(e -> {
            boolean deleted = manager.deleteStudent(idField.getText());

            if (deleted) {
                idField.clear();
                firstNameField.clear();
                lastNameField.clear();
                genderField.setValue(null);
                programmeField.clear();
                levelField.clear();
                emailField.clear();
                searchField.clear();

                message.setText("Student Deleted Successfully!");
            } else {
                message.setText("Student ID not found.");
            }
        });

        //  UPDATE
        updateButton.setOnAction(e -> {
            try {
                Student updatedStudent = new Student(
                        idField.getText(),
                        firstNameField.getText(),
                        lastNameField.getText(),
                        genderField.getValue(),
                        programmeField.getText(),
                        Integer.parseInt(levelField.getText()),
                        emailField.getText()
                );

                boolean updated = manager.updateStudent(updatedStudent);

                if (updated) {
                    message.setText("Student Updated Successfully!");
                } else {
                    message.setText("Student ID not found.");
                }

            } catch (Exception ex) {
                message.setText("Error: Invalid input!");
            }
        });

        //  VIEW
        viewButton.setOnAction(e -> {
            StudentTableView tableView = new StudentTableView(manager);
            tableView.show(new Stage());
        });

        VBox root = new VBox(10,
                idField,
                firstNameField,
                lastNameField,
                genderField,
                programmeField,
                levelField,
                emailField,
                addButton,
                updateButton,
                viewButton,
                searchField,
                searchButton,
                deleteButton,
                message
        );

        Scene scene = new Scene(root, 400, 500);
        stage.setTitle("Student Record System");
        stage.setScene(scene);
        stage.show();
    }
}