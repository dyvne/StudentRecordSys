package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import service.LoginManager;
import service.StudentManager;
import service.StudentManager;

public class LoginView {

    private final LoginManager loginManager = new LoginManager();
    private final StudentManager studentManager = new StudentManager();

    public void show(Stage stage) {


        // Title


        Label title = new Label("Smart Student Record System");
        title.setStyle(
                "-fx-font-size:26;" +
                        "-fx-font-weight:bold;" +
                        "-fx-text-fill:#1565C0;"
        );

        Label subtitle = new Label("Administrator Login");
        subtitle.setStyle(
                "-fx-font-size:15;" +
                        "-fx-text-fill:#555555;"
        );


        // Username


        Label userLabel = new Label("Username");
        userLabel.setMaxWidth(Double.MAX_VALUE);
        userLabel.setAlignment(Pos.CENTER_LEFT);

        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        usernameField.setPrefHeight(40);

        // Password

        Label passLabel = new Label("Password");
        passLabel.setMaxWidth(Double.MAX_VALUE);
        passLabel.setAlignment(Pos.CENTER_LEFT);

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        passwordField.setPrefHeight(40);

        // Show password field

        TextField visiblePassword = new TextField();
        visiblePassword.setManaged(false);
        visiblePassword.setVisible(false);
        visiblePassword.setPrefHeight(40);

        visiblePassword.textProperty().bindBidirectional(passwordField.textProperty());

        CheckBox showPassword = new CheckBox("Show Password");

        showPassword.setOnAction(e -> {

            if(showPassword.isSelected()){

                visiblePassword.setVisible(true);
                visiblePassword.setManaged(true);

                passwordField.setVisible(false);
                passwordField.setManaged(false);

            }else{

                passwordField.setVisible(true);
                passwordField.setManaged(true);

                visiblePassword.setVisible(false);
                visiblePassword.setManaged(false);

            }

        });

        StackPane passwordPane = new StackPane(passwordField, visiblePassword);


        // Buttons


        Button loginButton = new Button("Login");
        loginButton.setPrefWidth(320);
        loginButton.setPrefHeight(42);

        loginButton.setStyle(
                "-fx-background-color:#1976D2;" +
                        "-fx-text-fill:white;" +
                        "-fx-font-size:15;" +
                        "-fx-font-weight:bold;" +
                        "-fx-background-radius:8;"
        );

        Button forgotButton = new Button("Forgot Password?");
        forgotButton.setStyle(
                "-fx-background-color:transparent;" +
                        "-fx-text-fill:#1976D2;" +
                        "-fx-font-size:13;"
        );


        // Login Event


        Runnable loginAction = () -> {

            String username = usernameField.getText().trim();

            String password;

            if(showPassword.isSelected())
                password = visiblePassword.getText();
            else
                password = passwordField.getText();

            // Validation

            if(username.isEmpty() || password.isEmpty()){

                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Missing Information");
                alert.setHeaderText(null);
                alert.setContentText("Please enter both username and password.");
                alert.showAndWait();

                return;
            }

            // Authentication

            if(loginManager.login(username,password)){

                Alert success = new Alert(Alert.AlertType.INFORMATION);
                success.setTitle("Success");
                success.setHeaderText(null);
                success.setContentText("Login Successful!");
                success.showAndWait();

                // Open Dashboard

                DashboardView dashboard = new DashboardView(studentManager);
                dashboard.show(stage);

            }else{

                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setTitle("Login Failed");
                error.setHeaderText(null);
                error.setContentText("Invalid Username or Password.");
                error.showAndWait();

            }

        };

        loginButton.setOnAction(e -> loginAction.run());

        usernameField.setOnAction(e -> loginAction.run());
        passwordField.setOnAction(e -> loginAction.run());
        visiblePassword.setOnAction(e -> loginAction.run());


        // Forgot Password


        forgotButton.setOnAction(e -> {

            Alert info = new Alert(Alert.AlertType.INFORMATION);

            info.setTitle("Forgot Password");

            info.setHeaderText("Password Recovery");

            info.setContentText(
                    "Default Administrator Account\n\n" +
                            "Username : admin\n" +
                            "Password : 1234\n\n" +
                            "Future versions will support secure password recovery."
            );

            info.showAndWait();

        });


        // Layout


        VBox card = new VBox(12);

        card.setAlignment(Pos.CENTER);

        card.setPadding(new Insets(30));

        card.setMaxWidth(450);

        card.setStyle(
                "-fx-background-color:white;" +
                        "-fx-background-radius:15;" +
                        "-fx-border-radius:15;" +
                        "-fx-border-color:#DDDDDD;"
        );

        card.getChildren().addAll(

                title,
                subtitle,

                userLabel,
                usernameField,

                passLabel,
                passwordPane,

                showPassword,

                loginButton,

                forgotButton

        );

        StackPane root = new StackPane(card);

        root.setStyle("-fx-background-color:#F4F6F9;");

        Scene scene = new Scene(root,700,500);

        stage.setTitle("Smart Student Record System");

        stage.setScene(scene);

        stage.show();

    }

}