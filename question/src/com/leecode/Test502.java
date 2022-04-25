package com.leecode;

import java.util.*;

public class Test502 {
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = capital.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[] {capital[i],profits[i]});
        }
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]){
                    return 1;
                }else if(o1[0] < o2[0]){
                    return -1;
                }else {
                    return o1[1]-o2[1];
                }
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int count = 0;
        int i = 0;
        while(count<k){
            while (i<n&&list.get(i)[0]<=w) queue.offer(list.get(i++)[1]);
            w = w + queue.poll();
            count ++;
        }
        return w;
    }
}
