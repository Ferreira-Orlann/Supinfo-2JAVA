package com.supinfo.store;

import com.supinfo.store.inventory.Inventory;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Store {
    private Inventory inventory;
    private String name;
    private UUID id;
}