package org.prog.util;

import java.util.HashMap;
import java.util.Map;

public class DataHolder {

    private final static DataHolder instance = new DataHolder();
    private final Map<String, Object> map;

    private DataHolder() {
        map = new HashMap<>();
    }

    public static DataHolder getInstance() {
        return instance;
    }

    public void put(String key, Object value) {
        if (map.containsKey(key)) {
            throw new RuntimeException("Duplicate key!");
        }
        map.put(key, value);
    }

    public Object get(String key) {
        if (!map.containsKey(key)) {
            throw new RuntimeException("No value with key " + key + " present!");
        }
        return map.get(key);
    }

    public void clear() {
        map.clear();
    }
}
