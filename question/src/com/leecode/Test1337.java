package com.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Test1337 {
    public static void main(String[] args) {

    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length,m = mat[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]>o2[0]){
                    return 1;
                }else if (o1[0] < o2[0]){
                    return -1;
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0;j < m&&mat[i][j]>0;j++){
                count++;
            }
            queue.offer(new int[] {count,i});
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll()[1];
        }
        return ans;
    }
}
