package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import service.StudentManager;


public class DashboardView {
    private Label totalStudents;
    private StudentManager manager;

    private void refreshStats() {
        totalStudents.setText("Total Students: " + manager.getTotalStudents());
    }

    public DashboardView(StudentManager manager) {
        this.manager = manager;
    }

    public void show(Stage stage) {

        Label title = new Label("Smart Student Record Management System");
        title.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        Label welcome = new Label("Welcome Administrator");

        totalStudents = new Label();
        refreshStats();

        Button addStudentButton = new Button("Add Student");
        Button viewStudentButton = new Button("View Students");
        Button exitButton = new Button("Exit");

        // Button sizes
        addStudentButton.setPrefWidth(200);
        viewStudentButton.setPrefWidth(200);
        exitButton.setPrefWidth(200);

        // Styling buttons
        addStudentButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        viewStudentButton.setStyle("-fx-background-color: #2196F3; -fx-text-fill: white;");
        exitButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white;");

        addStudentButton.setOnAction(e -> {
            new AddStudentView(manager).show(new Stage());
            refreshStats();
        });

        viewStudentButton.setOnAction(e -> {
            new StudentTableView(manager).show(new Stage());
        });

        exitButton.setOnAction(e -> stage.close());

        VBox root = new VBox(15);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                title,
                welcome,
                totalStudents,
                addStudentButton,
                viewStudentButton,
                exitButton
        );

        Scene scene = new Scene(root, 500, 400);

        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();
    }
}