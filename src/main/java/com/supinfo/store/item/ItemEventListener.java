package com.supinfo.store.item;

import com.supinfo.common.event.EventListener;

public interface ItemEventListener extends EventListener {
    void onNameChanged(Item old, Item current);
    void onPriceChanged(Item old, Item current);
    void onItemCreated(Item item);
    void onItemDeleted(Item item);
}
