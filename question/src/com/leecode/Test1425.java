package com.leecode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Test1425 {
    public static void main(String[] args) {
        int[] nums = new int[]{10,2,-10,5,20};
        int k = 2;
        System.out.println(constrainedSubsetSum(nums, k));

    }
    public static int constrainedSubsetSum(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->x-y);
        int i = 0, n = nums.length,count = 0,j = 0;
        while (i<n){
            count += nums[i];
            if(nums[i]<0){
                pq.add(nums[i]);
            }else if(!pq.isEmpty()){
                for (int l = 1; l < k; l++) {
                    if(!pq.isEmpty()) {
                        count -= pq.poll();
                    }else {
                        break;
                    }
                }
                pq.clear();
            }
            i++;
        }
        return count;
    }
}
