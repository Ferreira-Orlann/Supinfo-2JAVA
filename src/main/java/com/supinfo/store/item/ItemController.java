package com.supinfo.store.item;

import com.supinfo.common.event.DefaultEventProducer;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.util.UUID;

@RequiredArgsConstructor
public class ItemController extends DefaultEventProducer<ItemEventListener> {
    private final ItemModel model;

    public Item changeName(Item item, String newName) {
        Item newItem = model.create(newName, item.getPrice(), item.getId());
        model.update(newItem);
        this.getListeners().forEach(listener -> listener.onNameChanged(item, newItem));
        return newItem;
    }

    public Item changePrice(Item item, int newPrice) {
        Item newItem = model.create(item.getName(), newPrice, item.getId());
        model.update(newItem);
        this.getListeners().forEach(listener -> listener.onPriceChanged(item, newItem));
        return newItem;
    }

    public Item changeAll(Item item, String newName, int newPrice) {
        Item newItem = model.create(newName, newPrice, item.getId());
        model.update(newItem);
        this.getListeners().forEach(listener -> listener.onPriceChanged(item, newItem));
        this.getListeners().forEach(listener -> listener.onNameChanged(item, newItem));
        return newItem;
    }

    public Item create(String name, int price) throws SQLException {
        Item newItem = model.create(name, price, UUID.randomUUID());
        model.register(newItem);
        this.getListeners().forEach(listener -> listener.onItemCreated(newItem));
        return newItem;
    }

    public void delete(Item item) throws SQLException {
        this.model.delete(item);
        this.getListeners().forEach(listener -> listener.onItemDeleted(item));
    }
}