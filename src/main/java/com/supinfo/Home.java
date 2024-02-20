package com.supinfo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Home extends Application {

    private Stage primaryStage;
    private Scene homeScene;
    private Profile profilePage = new Profile();
    private LoginPage loginPage = new LoginPage();

    private InventoryManagement Inventory = new InventoryManagement();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Page d'Accueil");

        createHomePage();

        this.primaryStage.setScene(homeScene);
        this.primaryStage.show();
    }

    private void createHomePage() {
        Button profilButton = new Button("Profil");
        Button deconnexionButton = new Button("Deconnexion");

        HBox navBar = new HBox(10);
        navBar.setPadding(new Insets(10, 10, 10, 10));
        navBar.getChildren().addAll(profilButton, deconnexionButton);

        VBox magasinButtons = new VBox(10);
        magasinButtons.setPadding(new Insets(10, 10, 10, 10));

        String[] nomsMagasins = {"Magasin A", "Magasin B", "Magasin C"};

        for (String nomMagasin : nomsMagasins) {
            Button magasinButton = new Button("Voir Inventaire de " + nomMagasin);
            magasinButton.setOnAction(e -> afficherInventaire(nomMagasin));
            magasinButtons.getChildren().add(magasinButton);
        }

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(navBar);
        borderPane.setCenter(magasinButtons);

        homeScene = new Scene(borderPane, 500, 400);

        profilButton.setOnAction(e -> launchProfile());

        deconnexionButton.setOnAction(e -> launchLogin());
    }

    private void afficherInventaire(String nomMagasin) {
        Inventory.start(new Stage());
    }

    private void launchProfile() {
        profilePage.start(new Stage());
    }
    private void launchLogin() {
        loginPage.start(new Stage());
    }

}
