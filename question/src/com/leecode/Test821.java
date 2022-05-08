package com.leecode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test821 {
    public int[] shortestToChar(String s, char c) {
        List<Integer> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (c == chars[i]){
                list.add(i);
            }
        }
        int[] ans = new int[n];
        for (int i = 0,j = 0; i < n; i++) {
            int a = Math.abs(list.get(j)-i);
            int b = 10000;
            if (j+1<list.size())
            b = Math.abs(list.get(j+1)-i);
            if (b<a) j++;
            ans[i] = Math.min(a,b);
        }
        return ans;
    }
}
