package com.leecode;

import java.util.PriorityQueue;

public class Test1405 {
    public String longestDiverseString(int a, int b, int c) {
        //优先队列实现大根堆
        PriorityQueue<int[]> q = new PriorityQueue<>((x, y)->y[1]-x[1]);
        if (a > 0) q.add(new int[]{0, a});
        if (b > 0) q.add(new int[]{1, b});
        if (c > 0) q.add(new int[]{2, c});
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            //获得当前最长字符串
            int[] cur = q.poll();
            int n = sb.length();
            //如果最长字符串已经重复了两个，则加入第二长的字符串
            if (n >= 2 && sb.charAt(n - 1) - 'a' == cur[0] && sb.charAt(n - 2) - 'a' == cur[0]) {
                if (q.isEmpty()) break;
                int[] next = q.poll();
                sb.append((char)(next[0] + 'a'));
                if (--next[1] != 0) q.add(next);
                q.add(cur);
            } else {
                sb.append((char)(cur[0] + 'a'));
                if (--cur[1] != 0) q.add(cur);
            }
        }
        return sb.toString();
    }
}