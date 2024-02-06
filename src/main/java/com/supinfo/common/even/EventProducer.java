package com.supinfo.common.even;

public interface EventProducer<T> {
    void subscribe(T listener);
    boolean unsubscribe(T listener);
}
