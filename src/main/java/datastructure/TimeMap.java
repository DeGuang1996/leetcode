package datastructure;

import java.util.HashMap;
import java.util.TreeMap;

public class TimeMap {

    private HashMap<String, TreeMap<Integer, String>> hashMap;

    /** Initialize your data structure here. */
    public TimeMap() {
        hashMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> treeMap = hashMap.getOrDefault(key, new TreeMap<>());
        treeMap.put(timestamp, value);
        hashMap.put(key, treeMap);
    }

    public String get(String key, int timestamp) {
        TreeMap<Integer, String> treeMap = hashMap.get(key);
        if (treeMap == null) {
            return "";
        }
        if (treeMap.floorKey(timestamp) == null) {
            return "";
        }
        return treeMap.get(treeMap.floorKey(timestamp));
    }
}
