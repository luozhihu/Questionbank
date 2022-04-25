package com.leecode;

import java.util.*;

public class Test187 {
    public static int P = 131313;
    public static void main(String[] args) {
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }
    public static List<String> findRepeatedDnaSequences(String s) {
        List<String> ans = new ArrayList<>();
        int n = s.length();
        int[] p = new int[n+1];
        int[] h = new int[n+1];
        p[0] = 1;
        for (int i = 1; i <= n; i++) {
            h[i] = h[i-1]*P+s.charAt(i-1);
            p[i] = p[i-1]*P;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 1; i <= n - 9; i++) {
            String str = s.substring(i-1,i+10-1);
            int hash = h[i+10-1]-h[i-1]*p[10];
            int cnt = map.getOrDefault(hash,0);
            if(cnt == 1) ans.add(str);
            map.put(hash,cnt+1);
        }
        return ans;
    }
}
