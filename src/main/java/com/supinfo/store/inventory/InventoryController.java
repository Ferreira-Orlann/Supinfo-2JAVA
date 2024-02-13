package com.supinfo.store.inventory;

import com.supinfo.common.event.DefaultEventProducer;
import com.supinfo.store.item.Item;
import com.supinfo.store.item.ItemEventListener;
import javafx.util.Pair;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequiredArgsConstructor
public class InventoryController extends DefaultEventProducer<InventoryEventListener> implements ItemEventListener {
    private final InventoryModel model;

    public Inventory create() {
        Inventory inventory = model.create(new HashMap<UUID, Pair<Item, Integer>>(), UUID.randomUUID());
        model.register(inventory);
        this.getListeners().forEach(listener -> listener.onInventoryCreated(inventory));
        return inventory;
    }

    public void delete(Inventory inventory) {
        model.delete(inventory);
        this.getListeners().forEach(listener -> listener.onInventoryDeleted(inventory));
    }

    public void addItem(Inventory inventory, Item item) {
        HashMap<UUID, Pair<Item, Integer>> items = inventory.getItemsCopy();
        items.put(item.getId(), new Pair<Item, Integer>(item, 1));
        Inventory newInventory = this.model.create(items, inventory.getId());
        this.model.update(newInventory);
        this.getListeners().forEach(listener -> listener.onItemQuantityChanged(inventory, item, 0, 1));
    }

    public void deleteItem(Inventory inventory, Item item) {
        HashMap<UUID, Pair<Item, Integer>> items = inventory.getItemsCopy();
        Pair<Item, Integer> pair = items.remove(item.getId());
        Inventory newInventory = this.model.create(items, inventory.getId());
        this.model.update(newInventory);
        this.getListeners().forEach(listener -> listener.onItemQuantityChanged(inventory, item, pair.getValue(), 0));
    }

    public void changeItemQuantity(Inventory inventory, Item item, int quantity) {
        HashMap<UUID, Pair<Item, Integer>> items = inventory.getItemsCopy();
        Pair<Item, Integer> pair = items.remove(item.getId());
        items.put(item.getId(), new Pair<Item, Integer>(item, quantity));
        Inventory newInventory = this.model.create(items, inventory.getId());
        this.model.update(newInventory);
        this.getListeners().forEach(listener -> listener.onItemQuantityChanged(inventory, item, pair.getValue(), quantity));
    }

    @Override
    public void onNameChanged(Item old, Item current) {
        List<Inventory> inventories = this.model.getInventoriesByItem(old);
        List<InventoryEventListener> listeners = this.getListeners();
        for(Inventory inventory : inventories) {
            Map<UUID, Pair<Item, Integer>> items = inventory.getItemsCopy();
            Pair<Item, Integer> pair = items.remove(old.getId());
            items.put(current.getId(), new Pair<>(current, pair.getValue()));
            Inventory newInventory = this.model.create(items, inventory.getId());

            listeners.forEach(listener -> listener.onItemNameChanged(inventory, old, current));
        }
    }

    @Override
    public void onPriceChanged(Item old, Item current) {
        List<Inventory> inventories = this.model.getInventoriesByItem(old);
        List<InventoryEventListener> listeners = this.getListeners();
        inventories.forEach(
                inventory -> listeners.forEach(
                        listener -> listener.onItemPriceChanged(inventory, old, current)
                )
        );
    }

    @Override
    public void onItemCreated(Item item) {}

    @Override
    public void onItemDeleted(Item item) {}
}
