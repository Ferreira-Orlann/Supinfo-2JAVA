package com.supinfo.common;

import java.util.Iterator;
import java.util.UUID;

public interface DataModel<T> {
    public T load(UUID id);
    public T create(Object... args);
    public boolean delete(T item);
    public boolean update(T item);
}