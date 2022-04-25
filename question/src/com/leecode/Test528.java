package com.leecode;

import java.util.Random;

public class Test528 {
    long[] f = new long[10010];
    int len = 0;
    public Test528(int[] w) {
        len = w.length;
        long count = 0;
        for (int i = 0; i < len; i++) {
            if (i>0) {
                f[i] = f[i - 1] + w[i];
            }else {
                f[i] = w[i];
            }
        }
    }

    public int pickIndex() {
        double  r = Math.random();
        r=f[len-1]*r;
        int i = -1,j = len-1;
        while (i<j){
            int mid = i + j + 1 >> 1;
            if (f[mid]<r){
                i = mid;
            }else {
                j = mid - 1;
            }
        }
            return i + 1;
    }
}
