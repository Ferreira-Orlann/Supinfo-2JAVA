package com.supinfo;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;



public class InventoryManagement extends Application {

    private ObservableList<Item> items;
    private TableView<Item> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inventory Management");

        items = FXCollections.observableArrayList(
                new Item(1, "Item 1", 10.99, 50),
                new Item(2, "Item 2", 20.99, 30),
                new Item(3, "Item 3", 5.99, 15)
        );

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setVgap(10);
        grid.setHgap(10);

        tableView = createTableView();
        grid.add(tableView, 0, 0, 3, 1);

        Button addItemButton = new Button("Add Item");
        Button removeItemButton = new Button("Remove Item");

        grid.add(addItemButton, 0, 1);
        grid.add(removeItemButton, 1, 1);

        // Ajouter des actions aux boutons (à implémenter)
        addItemButton.setOnAction(e -> handleAddItem());
        removeItemButton.setOnAction(e -> handleRemoveItem());

        Scene scene = new Scene(grid, 500, 300);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TableView<Item> createTableView() {
        TableView<Item> tableView = new TableView<>();
        TableColumn<Item, Integer> idColumn = new TableColumn<>("ID");
        TableColumn<Item, String> nameColumn = new TableColumn<>("Name");
        TableColumn<Item, Double> priceColumn = new TableColumn<>("Price");
        TableColumn<Item, Integer> stockColumn = new TableColumn<>("Stock");

        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());

        tableView.getColumns().addAll(idColumn, nameColumn, priceColumn, stockColumn);
        tableView.setItems(items);

        return tableView;
    }

    private void handleAddItem() {
        // À implémenter : Logique pour ajouter un nouvel article à l'inventaire
    }

    private void handleRemoveItem() {
        // À implémenter : Logique pour supprimer un article de l'inventaire
    }

    public static class Item {
        private final Integer id;
        private final String name;
        private final Double price;
        private final Integer stock;

        public Item(Integer id, String name, Double price, Integer stock) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.stock = stock;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Double getPrice() {
            return price;
        }

        public Integer getStock() {
            return stock;
        }

        public IntegerProperty idProperty() {
            return new SimpleIntegerProperty(id);
        }

        public StringProperty nameProperty() {
            return new SimpleStringProperty(name);
        }

        public DoubleProperty priceProperty() {
            return new SimpleDoubleProperty(price);
        }

        public IntegerProperty stockProperty() {
            return new SimpleIntegerProperty(stock);
        }
    }
}

