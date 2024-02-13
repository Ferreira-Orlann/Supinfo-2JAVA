package com.supinfo.store.inventory;

import com.supinfo.common.event.EventListener;
import com.supinfo.store.item.Item;

public interface InventoryEventListener extends EventListener {
    void onItemNameChanged(Inventory inventory, Item old, Item newItem);
    void onItemPriceChanged(Inventory inventory, Item old, Item newItem);
    void onItemQuantityChanged(Inventory inventory, Item item, int old, int newQuantity);
    void onInventoryCreated(Inventory inventory);
    void onInventoryDeleted(Inventory inventory);
}
