package com.supinfo.store.item;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Item {
    private String name;
    private int price;
    private UUID id;
}
