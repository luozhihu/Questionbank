package com.leecode;

import java.util.Arrays;

public class Test274 {
    public static void main(String[] args) {

    }
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int l = 0,r = n - 1;
        while (l<r){
            int mid = l + r + 1 >> 1;
            if (citations[mid]<=n-mid){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return Math.min(n-l,citations[l]);
    }
}
