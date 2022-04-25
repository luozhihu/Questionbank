package com.leecode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Test373 {
    public static void main(String[] args) {
        int[] nums1 = {1,1,2};
        int[] nums2 = {1,2,3};
        System.out.println(kSmallestPairs(nums1,nums2,10));
    }
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length,n2 = nums2.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < n1; i++) {
            int[] an = new int[3];
            an[0] = nums1[i] + nums2[0];
            an[1] = i;
            an[2] = 0;
            queue.offer(an);
        }
        List<List<Integer>> ans = new LinkedList<>();
        while (ans.size()<k&&!queue.isEmpty()){
            int[] poll = queue.poll();
            if (poll[2]+1<n2)
            queue.offer(new int[] {nums1[poll[1]] + nums2[poll[2]+1],poll[1],poll[2]+1});
            List<Integer> list = new LinkedList<>();
            list.add(nums1[poll[1]]);
            list.add(nums2[poll[2]]);
            ans.add(list);
        }
        return ans;
    }
}
