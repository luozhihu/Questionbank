package com.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class Test1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        TreeSet<int[]> treeSet = new TreeSet<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int n = nums1.length,m = nums2.length;
        for (int i = 0; i < n; i++) {
            treeSet.add(new int[] {nums1[i],i});
        }
        treeSet.add(new int[] {-100000,0});
        treeSet.add(new int[] {Integer.MAX_VALUE,0});
        long ans = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums2[i] - nums1[i]);
            int[] node1 = treeSet.ceiling(new int[] {nums2[i],i});
            int[] node2 = treeSet.floor(new int[] {nums2[i],i});
            int del1 = node1[0] - nums2[i];
            int del2 = nums2[i] - node2[0];
            int d = Math.min(del1,del2);
            int r = Math.abs(nums2[i] - nums1[i]);
            max = Math.max(max,r - d);

        }
        return (int) ((ans - max) % (int)(1e9 + 7));
    }
}
