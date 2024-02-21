package com.supinfo.common.event;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class DefaultEventProducer<T extends EventListener> implements EventProducer<T> {
    private final List<T> listeners = new ArrayList<>();
    @Override
    public void subscribe(T listener) {
        if (listener == this || this.listeners.contains(listener)) {
            return;
        }
        this.listeners.add(listener);
    }

    @Override
    public boolean unsubscribe(T listener) {
        return this.listeners.remove(listener);
    }

}