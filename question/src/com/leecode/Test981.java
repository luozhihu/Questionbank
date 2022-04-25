package com.leecode;

import com.sun.javafx.collections.ArrayListenerHelper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Test981 {
    Map<String,ArrayList<HashMap<Integer,String>>> map = new HashMap<>();
    public Test981() {

    }
    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)){
            HashMap<Integer,String> an = new HashMap<>();
            an.put(timestamp,value);
            ArrayList<HashMap<Integer,String>> an1 = new ArrayList<>();
            an1.add(an);
            map.put(key,an1);
        }else {
            ArrayList<HashMap<Integer, String>> hashMaps = map.get(key);
            HashMap<Integer,String> an = new HashMap<>();
            an.put(timestamp,value);
            hashMaps.add(an);
            map.put(key,hashMaps);
        }
    }

    public String get(String key, int timestamp) {
        ArrayList<HashMap<Integer, String>> hashMaps = map.get(key);
        int i = 0,j = 100;
        while (i<j){
            int mid = (i + j + 1) >> 1;
            for (Map.Entry < Integer, String > entry: hashMaps.get(mid).entrySet()) {
                if (entry.getKey()<=timestamp){
                    i = mid;
                }else {
                    j = mid - 1;
                }
            }
        }
        for (Map.Entry < Integer, String > entry: hashMaps.get(i).entrySet()) {
            return entry.getValue();
        }
        return null;
    }
}
