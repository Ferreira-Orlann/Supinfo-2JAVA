package com.supinfo.store.inventory;

import com.supinfo.store.item.Item;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Inventory {
    private Map<Item, Integer> items;
    private UUID id;

    public void forEachItems(BiConsumer<? super Item, ? super Integer> action) {
        this.items.forEach(action);
    }
}
