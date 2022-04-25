package com.leecode;

import java.util.HashSet;
import java.util.Set;

public class Test1044 {
    public static void main(String[] args) {

    }
    int P = 1313131;
    long[] hash;
    long[] p;
    public String longestDupSubstring(String s) {
        int n = s.length();
         hash = new long[n+1];
         p = new long[n];
        p[0] = 1;
        //hash[0] = s.charAt(0) - 0;
        for (int i = 0; i < n; i++) {
            p[i+1] = P*p[i-1];
            hash[i+1] = hash[i] * P + s.charAt(i) - 0;
        }
        int l = 0,r = n;
        String ans = "";
        while (l<r){
            int mid = l + r + 1 >> 1;
            String sub =check(s,mid);
            if (sub.length()>0){
                ans = sub;
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return ans;
    }
    String check(String s,int mid){
        int i = 0,j = mid;
        int n = s.length();
        Set<Long> set = new HashSet<>();
        while(j<=n){
            long subs = hash[j]-hash[i]*p[j-i];
            if (set.contains(subs)){
                return s.substring(i,j);
            }
            set.add(subs);
            j++;i++;
        }
        return "";
    }
}
