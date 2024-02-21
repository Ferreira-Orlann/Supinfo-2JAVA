package com.supinfo.store.item;

import com.supinfo.common.DataModel;
import com.supinfo.database.Database;
import com.supinfo.store.inventory.Inventory;
import lombok.RequiredArgsConstructor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
public class ItemModel implements DataModel<Item> {
    private final Database db;

    @Override
    public Item load(UUID id) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("SELECT name,price FROM items WHERE id = ?");
            ps.setString(1, id.toString());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Item(rs.getString("name"),(int) rs.getDouble("price"), id);
            }
        } catch (SQLException e) {
            return null;
        }
        return null;
    }

    @Override
    public Item create(Object... args) {
        return new Item((String) args[0], (int) args[1], UUID.randomUUID());
    }

    @Override
    public boolean register(Item item) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("INSERT INTO items(id, name, price) VALUES (?,?,?)");
            ps.setString(1, item.getId().toString());
            ps.setString(2, item.getName());
            ps.setDouble(3, item.getPrice());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(Item item) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("DELETE FROM items WHERE id = ?");
            ps.setString(1, item.getId().toString());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public boolean update(Item item) {
        PreparedStatement ps = null;
        try {
            ps = this.db.query("UPDATE items SET name = ?, SET price = ? WHERE id = ?");
            ps.setString(1, item.getName());
            ps.setDouble(2, item.getPrice());
            ps.setString(3, item.getId().toString());
            ResultSet rs = ps.executeQuery();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
