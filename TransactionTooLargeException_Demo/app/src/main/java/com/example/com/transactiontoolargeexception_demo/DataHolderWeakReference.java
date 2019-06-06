package com.example.com.transactiontoolargeexception_demo;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class DataHolderWeakReference {
    Map<String, WeakReference<Object>> data = new HashMap<String, WeakReference<Object>>();

    void save(String id, Object object) {
        data.put(id, new WeakReference<Object>(object));
    }

    Object get(String id) {
        WeakReference<Object> objectWeakReference = data.get(id);
        return objectWeakReference.get();
    }

    private final static DataHolderWeakReference holder = new DataHolderWeakReference();

    public static DataHolderWeakReference getInstance() {
        return holder;
    }
}
