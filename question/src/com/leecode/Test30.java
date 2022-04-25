package com.leecode;

import java.util.*;

public class Test30 {
    public static void main(String[] args) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};
        System.out.println(findSubstring(s, words));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new LinkedList<>();
        Map<String,Integer> subStrNumMap = new HashMap<>();
        int subStrNum = words.length,subStrSize = words[0].length();
        int n = s.length();
        for (int i = 0; i < subStrNum; i++) {
            String str = words[i];
            subStrNumMap.put(str,subStrNumMap.getOrDefault(str,0)+1);
        }
        for (int k = 0;k < subStrSize; k++) {
            Map<String,Integer> strCountMap = new HashMap<>();
            for (int i = k; i <= n-subStrSize; i+=subStrSize) {
                String str = s.substring(i,i+subStrSize);
                if (i>=k+(subStrNum*subStrSize)){
                    int idx = i - subStrNum*subStrSize;
                    String s1 = s.substring(idx,idx+subStrSize);
                    if (strCountMap.get(s1) == 1){
                        strCountMap.remove(s1);
                    }else {
                        strCountMap.put(s1,strCountMap.getOrDefault(s1,0)-1);
                    }
                }
                strCountMap.put(str,strCountMap.getOrDefault(str,0)+1);
                if (subStrNumMap.containsKey(str)&&strCountMap.get(str).equals(subStrNumMap.get(str))&&cmp(strCountMap,subStrNumMap)){
                    ans.add(i-(subStrNum-1)*subStrSize);
                }
            }
        }
        return ans;
    }
    public static boolean cmp(Map<String, Integer> m1, Map<String, Integer> m2) {
        if (m1.size() != m2.size()) return false;
        for (String k1 : m1.keySet()) {
            if (!m2.containsKey(k1) || !m1.get(k1).equals(m2.get(k1))) return false;
        }
        for (String k2 : m2.keySet()) {
            if (!m1.containsKey(k2) || !m1.get(k2).equals(m2.get(k2))) return false;
        }
        return true;
    }
}
