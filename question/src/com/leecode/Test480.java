package com.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test480 {
    public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(medianSlidingWindow(nums,3)));
    }
    public static double[] medianSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> SmallHeap = new PriorityQueue<>();
        PriorityQueue<Integer> BigHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        int n = nums.length;
        double[] ans = new double[n-k+1];
        for (int i = 0; i < k; i++) {
            BigHeap.add(nums[i]);
        }
        for (int i = 0; i < k / 2; i++) {
            Integer poll = BigHeap.poll();
            SmallHeap.add(poll);
        }
        ans[0] = getMid(BigHeap,SmallHeap);
        for (int i = k; i< nums.length ; i++) {
            int add = nums[i], del = nums[i-k];
            if (add>= SmallHeap.peek()){
                SmallHeap.add(add);
            }else {
                BigHeap.add(add);
            }
            if (del >= SmallHeap.peek()){
                SmallHeap.remove(del);
            }else {
                BigHeap.remove(del);
            }
            adjust(BigHeap,SmallHeap);
            ans[i-k+1] = getMid(BigHeap,SmallHeap);


        }
        return ans;
     }
    public static void adjust(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        while (left.size() > right.size()) right.add(left.poll());
        while (right.size() - left.size() > 1) left.add(right.poll());
    }
    public static double getMid(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() == right.size()) {
            return (left.peek() / 2.0) + (right.peek() / 2.0);
        } else {
            return right.peek() * 1.0;
        }
    }

}
