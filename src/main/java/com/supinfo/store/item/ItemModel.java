package com.supinfo.store.item;

import com.supinfo.common.DataModel;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ItemModel implements DataModel<Item> {
    private final List<Item> items = new ArrayList<>();

    @Override
    public Item load(UUID id) {
        Item item = null;
        for(Item storedItem : this.items) {
            if(storedItem.getId() == id) {
                item = storedItem;
                break;
            }
        }
        return item;
    }

    @Override
    public Item create(Object... args) {
        return new Item((String) args[0], (int) args[1], UUID.randomUUID());
    }

    @Override
    public boolean register(Item item) {
        return this.items.add(item);
    }

    @Override
    public boolean delete(Item item) {
        return this.items.remove(item);
    }

    @Override
    public boolean update(Item item) {
        Item loaded = this.load(item.getId());
        this.delete(loaded);
        this.register(item);
        return true;
    }
}
