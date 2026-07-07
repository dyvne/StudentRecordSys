package application;

import javafx.application.Application;
import javafx.stage.Stage;
import service.StudentManager;
import view.AddStudentView;
import view.DashboardView;
import view.LoginView;

public class Main extends Application {

    @Override
    public void start(Stage stage) {

        LoginView loginView = new LoginView();
        loginView.show(stage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}