package com.leecode;

import java.util.Arrays;

public class Test1218 {
    public int longestSubsequence(int[] arr, int difference) {
        int longest = 0;
        int n = arr.length;
        int[] f = new int[20010];
        for (int i = 0; i < n; i++) {
            arr[i] += 10000;
        }
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            if(num-difference>=0&&num-difference<=20000)
                f[num] = f[num-difference]+1;
            else
                f[num] = 1;
            longest = Math.max(f[num],longest);
        }
        return longest;
    }
}