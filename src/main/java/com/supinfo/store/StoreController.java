package com.supinfo.store;

import com.supinfo.common.event.DefaultEventProducer;
import com.supinfo.store.inventory.Inventory;
import com.supinfo.store.inventory.InventoryEventListener;
import com.supinfo.store.item.Item;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class StoreController extends DefaultEventProducer<StoreEventListener> implements InventoryEventListener {
    private final StoreModel model;

    @Override
    public void onItemNameChanged(Inventory inventory, Item old, Item newItem) {

    }

    @Override
    public void onItemPriceChanged(Inventory inventory, Item old, Item newItem) {

    }

    @Override
    public void onItemQuantityChanged(Inventory inventory, Item item, int old, int newQuantity) {

    }

    @Override
    public void onInventoryCreated(Inventory inventory) {

    }

    @Override
    public void onInventoryDeleted(Inventory inventory) {

    }
}
