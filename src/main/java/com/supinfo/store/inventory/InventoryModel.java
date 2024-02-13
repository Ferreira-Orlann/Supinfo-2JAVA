package com.supinfo.store.inventory;

import com.supinfo.common.DataModel;
import com.supinfo.store.item.Item;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InventoryModel  implements DataModel<Inventory> {
    private final List<Inventory> inventories = new ArrayList<>();
    @Override
    public Inventory load(UUID id) {
        Inventory inventory = null;
        for(Inventory storedInventory : this.inventories) {
            if(storedInventory.getId() == id) {
                inventory = storedInventory;
                break;
            }
        }
        return inventory;
    }

    @Override
    public Inventory create(Object... args) {
        @SuppressWarnings("unchecked")
        Inventory inventory = new Inventory((Map<UUID, Pair<Item, Integer>>) args[0], (UUID) args[1]);
        return inventory;
    }

    @Override
    public boolean register(Inventory inventory) {
        return this.inventories.add(inventory);
    }

    @Override
    public boolean delete(Inventory inventory) {
        return this.inventories.remove(inventory);
    }

    @Override
    public boolean update(Inventory inventory) {
        Inventory loaded = this.load(inventory.getId());
        this.delete(loaded);
        this.register(inventory);
        return true;
    }

    public List<Inventory> getInventoriesByItem(Item item) {
        List<Inventory> inventories = new ArrayList<>();
        for(Inventory inventory : this.inventories) {
            if(inventory.hasItem(item)) {
                inventories.add(inventory);
            }
        }
        return inventories;
    }
}
