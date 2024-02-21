package com.supinfo.common.event;

public interface EventProducer<T> {
    void subscribe(T listener);
    boolean unsubscribe(T listener);
}
