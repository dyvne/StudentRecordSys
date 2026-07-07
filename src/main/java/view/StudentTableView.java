package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Student;
import service.StudentManager;

public class StudentTableView {

    private StudentManager manager;

    public StudentTableView(StudentManager manager) {
        this.manager = manager;
    }

    public void show(Stage stage) {

        TableView<Student> table = new TableView<>();

        // Columns
        TableColumn<Student, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("studentId"));

        TableColumn<Student, String> firstCol = new TableColumn<>("First Name");
        firstCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Student, String> lastCol = new TableColumn<>("Last Name");
        lastCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Student, String> progCol = new TableColumn<>("Programme");
        progCol.setCellValueFactory(new PropertyValueFactory<>("programme"));

        TableColumn<Student, Integer> levelCol = new TableColumn<>("Level");
        levelCol.setCellValueFactory(new PropertyValueFactory<>("level"));

        TableColumn<Student, String> emailCol = new TableColumn<>("Email");
        emailCol.setCellValueFactory(new PropertyValueFactory<>("email"));

        table.getColumns().addAll(idCol, firstCol, lastCol, progCol, levelCol, emailCol);

        // Load data
        ObservableList<Student> data =
                FXCollections.observableArrayList(manager.getAllStudents());

        table.setItems(data);

        VBox root = new VBox(table);

        Scene scene = new Scene(root, 700, 400);

        stage.setTitle("Student List");
        stage.setScene(scene);
        stage.show();
    }
}