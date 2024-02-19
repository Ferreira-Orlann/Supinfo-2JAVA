package com.supinfo;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AdminManagementPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Admin Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);

        Label whitelistLabel = new Label("Whitelist Email:");
        TextField whitelistField = new TextField();
        Button whitelistButton = new Button("Whitelist");

        Label updateAccountLabel = new Label("Update Employee Account:");
        TextField updateAccountField = new TextField();
        Button updateAccountButton = new Button("Update Account");

        Label deleteAccountLabel = new Label("Delete Employee Account:");
        TextField deleteAccountField = new TextField();
        Button deleteAccountButton = new Button("Delete Account");

        Label createStoreLabel = new Label("Create New Store:");
        TextField createStoreField = new TextField();
        Button createStoreButton = new Button("Create Store");

        Label createItemLabel = new Label("Create New Item:");
        TextField createItemField = new TextField();
        Button createItemButton = new Button("Create Item");

        Label deleteItemLabel = new Label("Delete Item:");
        TextField deleteItemField = new TextField();
        Button deleteItemButton = new Button("Delete Item");

        grid.add(whitelistLabel, 0, 0);
        grid.add(whitelistField, 1, 0);
        grid.add(whitelistButton, 2, 0);

        grid.add(updateAccountLabel, 0, 1);
        grid.add(updateAccountField, 1, 1);
        grid.add(updateAccountButton, 2, 1);

        grid.add(deleteAccountLabel, 0, 2);
        grid.add(deleteAccountField, 1, 2);
        grid.add(deleteAccountButton, 2, 2);

        grid.add(createStoreLabel, 0, 3);
        grid.add(createStoreField, 1, 3);
        grid.add(createStoreButton, 2, 3);

        grid.add(createItemLabel, 0, 4);
        grid.add(createItemField, 1, 4);
        grid.add(createItemButton, 2, 4);

        grid.add(deleteItemLabel, 0, 5);
        grid.add(deleteItemField, 1, 5);
        grid.add(deleteItemButton, 2, 5);

        whitelistButton.setOnAction(e -> handleWhitelist(whitelistField.getText()));
        updateAccountButton.setOnAction(e -> handleUpdateAccount(updateAccountField.getText()));
        deleteAccountButton.setOnAction(e -> handleDeleteAccount(deleteAccountField.getText()));
        createStoreButton.setOnAction(e -> handleCreateStore(createStoreField.getText()));
        createItemButton.setOnAction(e -> handleCreateItem(createItemField.getText()));
        deleteItemButton.setOnAction(e -> handleDeleteItem(deleteItemField.getText()));

        Scene scene = new Scene(grid, 500, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleWhitelist(String email) {
        System.out.println("Whitelisting email: " + email);
    }

    private void handleUpdateAccount(String employeeId) {
        System.out.println("Updating account for employee: " + employeeId);
    }

    private void handleDeleteAccount(String employeeId) {
        System.out.println("Deleting account for employee: " + employeeId);
    }

    private void handleCreateStore(String storeName) {
        System.out.println("Creating new store: " + storeName);
    }

    private void handleCreateItem(String itemName) {
        System.out.println("Creating new item: " + itemName);
    }

    private void handleDeleteItem(String itemId) {
        System.out.println("Deleting item: " + itemId);
    }
}
