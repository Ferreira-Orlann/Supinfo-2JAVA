package com.supinfo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Profile extends Application {
    private UserManager userManager = new UserManager();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Main Page");

        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(20, 50, 20, 50));

        Button profileButton = new Button("Voir mon Profil");
        profileButton.setOnAction(e -> showProfile());

        Button button1 = new Button("Bouton 1");
        Button button2 = new Button("Bouton 2");

        vbox.getChildren().addAll(profileButton, button1, button2);

        Scene scene = new Scene(vbox, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void showProfile() {
        String userProfile = userManager.getConnectedUserProfile();

        Stage profileStage = new Stage();
        profileStage.setTitle("Profil Utilisateur");
        VBox profileVBox = new VBox(10);
        profileVBox.setPadding(new Insets(20, 50, 20, 50));
        profileVBox.getChildren().add(new Button("Fermer"));
        profileVBox.getChildren().add(new javafx.scene.control.Label(userProfile));
        Scene profileScene = new Scene(profileVBox, 300, 200);
        profileStage.setScene(profileScene);
        profileStage.show();
    }
    private static class UserManager {
        public String getConnectedUserProfile() {
            return "Nom: John Doe\nEmail: john.doe@example.com";
        }
    }
}
