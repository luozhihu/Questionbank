package com.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test630 {
    //   public int scheduleCourse(int[][] courses) {
//        Arrays.sort(courses, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0]-o2[0];
//            }
//        });
//        int n = courses.length;
//        int[] f = new int[n];
//        Arrays.fill(f,Integer.MAX_VALUE-10010);
//        f[0] = 0;
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            int l = 0,r = n-1;
//            while (l<r){
//                int mid = l + r + 1 >> 1;
//                if (f[mid]+courses[i][0]<=courses[i][1]){
//                    l = mid;
//                }else {
//                    r = mid - 1;
//                }
//            }
//                f[l + 1] = Math.min(f[l] + courses[i][0],f[l+1]);
//                ans = Math.max(ans, l + 1);
//
//        }
//        return ans;
//    }
    public int scheduleCourse(int[][] courses) {
        //把课程按照最后结束时间排序
        Arrays.sort(courses, (a,b)->a[1]-b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int sum = 0;
        for (int[] c : courses) {
            int d = c[0], e = c[1];
            sum += d;
            q.add(d);
            //如果超出了当前最后期限则放弃当前学过持续时间最长的一门课
            if (sum > e) sum -= q.poll();
        }
        return q.size();
    }
}
