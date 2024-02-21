package com.supinfo.store;

import com.supinfo.store.inventory.Inventory;

import java.util.UUID;

public record StoreT(Inventory inv, String name, UUID id) {
    
}
