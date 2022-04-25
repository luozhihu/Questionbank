package com.leecode;

import java.util.HashSet;
import java.util.Set;

public class Test564 {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long cur = Long.parseLong(n);
        Set<Long> set = new HashSet<>();
        set.add((long)Math.pow(10,len-1)-1);
        set.add((long)Math.pow(10,len)+1);
        long left = Long.parseLong(n.substring(0,len+1 >> 1));
        for (long i = left - 1; i <= left + 1; i++) {
            long temp = getNum(i, len % 2 == 0);
            if (temp != cur) set.add(temp);
        }
        long ans = -1;
        for (long i : set) {
            if (ans == -1) ans = i;
            else if (Math.abs(i - cur) < Math.abs(ans - cur)) ans = i;
            else if (Math.abs(i - cur) == Math.abs(ans - cur) && i < ans) ans = i;
        }
        return String.valueOf(ans);
    }
    long getNum(long k, boolean isEven) {
        StringBuilder sb = new StringBuilder();
        sb.append(k);
        int n = sb.length(), idx = isEven ? n - 1 : n - 2;
        while (idx >= 0) sb.append(sb.charAt(idx--));
        String str = sb.toString();
        return str.length() > 19 ? -1 : Long.parseLong(str);
    }
}
