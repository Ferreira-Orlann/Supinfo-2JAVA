package com.supinfo.store.inventory;

import com.supinfo.common.DataModel;
import com.supinfo.database.Database;
import com.supinfo.store.item.Item;
import javafx.util.Pair;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

@RequiredArgsConstructor
public class InventoryModel  implements DataModel<Inventory> {
    private final Database db;

    @Override
    public Inventory load(UUID id) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("SELECT id FROM inventories WHERE id = ?");
            ps.setString(1, id.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Inventory(new HashMap<UUID, Pair<Item, Integer>>(), UUID.fromString(rs.getString("id")));
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public Inventory create(Object... args) {
        @SuppressWarnings("unchecked")
        Inventory inventory = new Inventory((Map<UUID, Pair<Item, Integer>>) args[0], (UUID) args[1]);
        return inventory;
    }

    @Override
    public boolean register(Inventory inventory) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("INSERT INTO inventories(id) VALUES (?)");
            ps.setString(1, inventory.getId().toString());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Inventory inventory) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("DELETE FROM inventories_items WHERE inventory_id = ?");
            ps.setString(1, inventory.getId().toString());
            ResultSet rs = ps.executeQuery();

            ps = this.db.query("DELETE FROM inventories WHERE id = ?");
            ps.setString(1, inventory.getId().toString());
            rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean removeItem(Inventory inventory, Item item) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("DELETE FROM inventories_items WHERE item_id = ? AND inventory_id = ?");
            ps.setString(1, item.getId().toString());
            ps.setString(2, inventory.getId().toString());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean addItem(Inventory inventory, Item item, int quantity) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("INSERT INTO inventories_items(inventory_id, item_id, quantity) VALUES (?,?,?)");
            ps.setString(1, inventory.getId().toString());
            ps.setString(2, item.getId().toString());
            ps.setDouble(3, quantity);
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean changeQuantity(Inventory inventory, Item item, int quantity) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("UPDATE inventories_items SET quantity = ? WHERE item_id = ? AND inventory_id = ?");
            ps.setDouble(1, quantity);
            ps.setString(2, item.getId().toString());
            ps.setString(3, inventory.getId().toString());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Inventory inventory) {
        return true;
    }

    public List<Inventory> getInventoriesByItem(Item item) {
        /*
        List<Inventory> inventories = new ArrayList<>();
        for(Inventory inventory : this.inventories) {
            if(inventory.hasItem(item)) {
                inventories.add(inventory);
            }
        }
        return inventories;

         */
        return null;
    }
}
