package com.supinfo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UserManagement extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("User Management");

        Button createButton = new Button("Create User");
        Button readButton = new Button("Read User");
        Button updateButton = new Button("Update User");
        Button deleteButton = new Button("Delete User");

        // Ajouter des actions aux boutons (à implémenter)
        createButton.setOnAction(e -> handleCreateUser());
        readButton.setOnAction(e -> handleReadUser());
        updateButton.setOnAction(e -> handleUpdateUser());
        deleteButton.setOnAction(e -> handleDeleteUser());

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(createButton, readButton, updateButton, deleteButton);

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCreateUser() {
        System.out.println("Create User clicked");
        // À implémenter : Logique de création d'utilisateur
    }

    private void handleReadUser() {
        System.out.println("Read User clicked");
        // À implémenter : Logique de lecture d'utilisateur
    }

    private void handleUpdateUser() {
        System.out.println("Update User clicked");
        // À implémenter : Logique de mise à jour d'utilisateur
    }

    private void handleDeleteUser() {
        System.out.println("Delete User clicked");
        // À implémenter : Logique de suppression d'utilisateur
    }
}
