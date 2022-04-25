package com.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test1751 {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[][] f = new int[n+1][k+1];
        int i = 1;
        for (int[] event : events) {
            int l = -1,r = n-1;
            while (l<r){
                int mid = l + r + 1 >> 1;
                if (events[mid][1]<event[0]){
                    l = mid;
                }else {
                    r = mid - 1;
                }
            }
            for (int j = 1; j <= k; j++) {
                f[i][j] = Math.max(f[i-1][j],f[l+1][j-1] + event[2]);
            }
            i++;
        }
        return f[n][k];
    }
}
