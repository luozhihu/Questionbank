package com.leecode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test1705 {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int[] f = new int[40000];
        int max = n;
        int num = 0;
        int ans = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0;i < max; i++) {
            int cnt=0;
            int d = 0;
            if (i<n) {
                cnt = apples[i];
                d = days[i];
            }
            f[i+d] += cnt;
            num += cnt;
            if(i+d>max) max = i+d;
            if (!queue.contains(i+d)&&cnt>0)
                queue.add(i+d);
            if(!queue.isEmpty()&&i==queue.peek()) {
                num -= f[queue.poll()];
            }
            if (num>0){
                ans++;
                num--;
                if(--f[queue.peek()] == 0) queue.poll();
            }
        }
        return ans;
    }
}
