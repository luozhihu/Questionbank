package com.leecode;

import java.util.Arrays;

public class Test395 {
    public static void main(String[] args) {
        String s = "aaabb";
        int k = 3;
        int ans = longestSubstring(s,k);
        System.out.println(ans);
    }
    public static int longestSubstring(String s, int k) {
        int n = s.length();
        char[] str = s.toCharArray();
        int ans = 0;
        int[] idx = new int[26];
        for (int p = 1;p <= 26;p++){
            Arrays.fill(idx,0);
            for (int i = 0,j = 0,num = 0,tot = 0;i<n;i++){
                int x = str[i] - 'a';
                idx[x]++;
                if (idx[x] == 1) tot++;
                if (idx[x] == k) num++;
                while (tot>p){
                    int t = str[j] - 'a';
                    idx[t]--;
                    if (idx[t] == 0) tot--;
                    if (idx[t] == k-1) num--;
                    j++;
                }
                if(tot == num) ans = Math.max(ans,i-j+1);
            }
        }
        return ans;
    }
}
