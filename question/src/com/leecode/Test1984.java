package com.leecode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Test1984 {
    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        System.out.println(minimumDifference(nums,2));
    }
    public static int minimumDifference(int[] nums, int k) {
        Deque<Integer> max = new ArrayDeque<>(),min = new ArrayDeque<>();
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 100000;
        for (int i = 0,j = 0;j<n;j++){
            while (!max.isEmpty()&&nums[j]>=nums[max.peekLast()]) max.pollLast();
            while (!min.isEmpty()&&nums[j]<=nums[min.peekLast()]) min.pollLast();
            max.addLast(j);
            min.addLast(j);
            while (j-i+1>k){
                i++;
                if (i>max.peekFirst()) max.pollFirst();
                if (i>min.peekFirst()) min.pollFirst();
            }
            if (j>=k-1) {
                ans = Math.min(ans, nums[max.peekFirst()] - nums[min.peekFirst()]);
            }
        }
        return ans;
    }
}
