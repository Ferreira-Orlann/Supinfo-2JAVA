package com.supinfo.store.inventory;

import com.supinfo.common.DataModel;
import com.supinfo.store.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class InventoryModel implements DataModel<Inventory> {
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
        Inventory inventory = new Inventory((Map<Item, Integer>) args[0], (UUID) args[1]);
        return null;
    }

    @Override
    public boolean delete(Inventory inventory) {
        return this.inventories.remove(inventory);
    }

    @Override
    public boolean update(Inventory inventory) {
        return true;
    }
}
