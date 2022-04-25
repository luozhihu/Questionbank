package com.leecode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test1438 {
    public static void main(String[] args) {
        int[] nums = {8,2,4,7};
        System.out.println(longestSubarray(nums,4));
    }
    public static int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        Deque<Integer> BigQue = new ArrayDeque<>();
        Deque<Integer> SmallQue = new ArrayDeque<>();
        int ans = 0;
        for (int i = 0,j=0; i < n; i++) {
            int num = nums[i];
            while (!BigQue.isEmpty()&&nums[BigQue.pollLast()]<=num) BigQue.pollLast();
            while (!SmallQue.isEmpty()&&nums[SmallQue.pollLast()]>=num) SmallQue.pollLast();
            BigQue.offer(i);
            SmallQue.offer(i);
                while (nums[BigQue.peekFirst()]-nums[SmallQue.peekFirst()]>limit) {
                    j++;
                    if (j > BigQue.peekFirst()) {
                        BigQue.pollFirst();
                    }
                    if (j > SmallQue.peekFirst()) {
                        SmallQue.pollFirst();
                    }
                }
                ans = Math.max(ans,i-j+1);

        }
        return ans;
    }
}
