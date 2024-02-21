package com.supinfo;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class StoreManagement extends Application {

    private ObservableList<String> peopleWithAccessList = FXCollections.observableArrayList();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Store Management");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);

        Label storeLabel = new Label("Store Management");
        Button createStoreButton = new Button("Create Store");
        Button deleteStoreButton = new Button("Delete Store");

        Label employeeLabel = new Label("Employee Management");
        Button addEmployeeButton = new Button("Add Employee");

        Label accessListLabel = new Label("People with Access to the Store");
        ListView<String> accessListView = new ListView<>(peopleWithAccessList);

        grid.add(storeLabel, 0, 0);
        grid.add(createStoreButton, 0, 1);
        grid.add(deleteStoreButton, 1, 1);

        grid.add(employeeLabel, 0, 2);
        grid.add(addEmployeeButton, 0, 3);

        grid.add(accessListLabel, 0, 4, 2, 1);
        grid.add(accessListView, 0, 5, 2, 1);

        createStoreButton.setOnAction(e -> handleCreateStore());
        deleteStoreButton.setOnAction(e -> handleDeleteStore());
        addEmployeeButton.setOnAction(e -> handleAddEmployee());

        Scene scene = new Scene(grid, 400, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleCreateStore() {
        System.out.println("Create Store clicked");
    }

    private void handleDeleteStore() {
        System.out.println("Delete Store clicked");
    }

    private void handleAddEmployee() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Employee");
        dialog.setHeaderText("Enter employee name:");
        dialog.setContentText("Name:");

        dialog.showAndWait().ifPresent(employeeName -> {
            System.out.println("Add Employee clicked: " + employeeName);
            peopleWithAccessList.add(employeeName);
        });
    }
}

