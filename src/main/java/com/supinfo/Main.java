package com.supinfo;

import com.supinfo.database.Database;
import com.supinfo.database.H2DatabaseBuilder;
import com.supinfo.store.StoreController;
import com.supinfo.store.StoreModel;
import com.supinfo.store.inventory.InventoryController;
import com.supinfo.store.inventory.InventoryModel;
import com.supinfo.store.item.ItemController;
import com.supinfo.store.item.ItemModel;
import com.supinfo.usermanager.UserController;
import com.supinfo.usermanager.UserModel;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (Database db = new Database(new H2DatabaseBuilder("./data/database", "sa", ""))) {

            UserModel userModel = new UserModel(db);
            InventoryModel inventoryModel = new InventoryModel(db);
            InventoryController inventoryController = new InventoryController(inventoryModel);
            StoreModel storeModel = new StoreModel(db, inventoryController);
            ItemModel itemModel = new ItemModel(db);


            UserController userController = new UserController(userModel);
            StoreController storeController = new StoreController(storeModel);
            ItemController itemController = new ItemController(itemModel);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Loginpage();

            }
        });
    }
}