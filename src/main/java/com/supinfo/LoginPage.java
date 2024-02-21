package com.supinfo;

import com.supinfo.usermanager.UserController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoginPage extends Application {
    private UserController userController;
    private TextField usernameField;
    private PasswordField passwordField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");

        // Créer une grille pour la disposition des éléments
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);

        // Ajouter les éléments à la grille
        Label usernameLabel = new Label("Username:");
        grid.add(usernameLabel, 0, 0);

        usernameField = new TextField();
        grid.add(usernameField, 1, 0);

        Label passwordLabel = new Label("Password:");
        grid.add(passwordLabel, 0, 1);

        passwordField = new PasswordField();
        grid.add(passwordField, 1, 1);

        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");

        Label messageLabel = new Label();
        grid.add(messageLabel, 0, 4);

        grid.add(loginButton, 0, 2);
        grid.add(registerButton, 1, 2);

        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String username = usernameField.getText();
                String password = passwordField.getText();

                userController.login(username, password);
            }
        });

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                // Ajoutez votre logique pour afficher la page d'inscription
                new RegisterPage().start(new Stage());
            }
        });

        // Créer la scène
        Scene scene = new Scene(grid, 300, 200);

        // Afficher la scène
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
