package com.supinfo;

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

public class RegisterPage extends Application {

    private TextField newUsernameField;
    private PasswordField newPasswordField;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Register Page");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);

        Label newUsernameLabel = new Label("New Username:");
        newUsernameField = new TextField();
        Label newPasswordLabel = new Label("New Password:");
        newPasswordField = new PasswordField();
        Button registerButton = new Button("Register");

        grid.add(newUsernameLabel, 0, 0);
        grid.add(newUsernameField, 1, 0);
        grid.add(newPasswordLabel, 0, 1);
        grid.add(newPasswordField, 1, 1);
        grid.add(registerButton, 1, 2);

        registerButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                String newUsername = newUsernameField.getText();
                String newPassword = newPasswordField.getText();

                System.out.println("User registered successfully!");

                primaryStage.close();
            }
        });

        Scene scene = new Scene(grid, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
