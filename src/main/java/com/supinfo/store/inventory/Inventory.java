package com.supinfo.store.inventory;

import com.supinfo.store.item.Item;
import javafx.util.Pair;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;

@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Inventory {
    private Map<UUID, Pair<Item, Integer>> items;
    @Getter
    private UUID id;

    public void forEachItems(BiConsumer<? super UUID, ? super Pair<Item, Integer>> action) {
        this.items.forEach(action);
    }

    public boolean hasItem(Item item) {
        return this.items.containsKey(item.getId());
    }

    public HashMap<UUID, Pair<Item, Integer>> getItemsCopy() {
        return new HashMap<>(this.items);
    }

    public int getQuantityByItem(Item item) {
        if (!this.hasItem(item)) {
            return 0;
        }
        return this.items.get(item.getId()).getValue();
    }
}
