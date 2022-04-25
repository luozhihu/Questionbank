package com.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class Test930 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums,2));
    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int[] index = new int[nums.length];
        int n = nums.length;
        int j = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1){
                index[j++] = i;
            }
        }
        if (goal == 0){
            int a = 0,b = 0;
            while (a<n){
                if (nums[a]==1 && 0==nums[b]){
                    ans = ans + (1 + a-b)*(a-b)/2;
                    b=a;
                }
                if (nums[a]==1 && 1==nums[b]){
                    ans = ans + (1 + a-b - 1)*(a-b-1)/2;
                    b=a;
                }
                a++;
            }
            if (0==nums[b]){
                ans = ans + (1 + a-b)*(a-b)/2;
            }else {
                ans = ans + (1 + a - b - 1) * (a - b - 1) / 2;
            }
            return ans;
        }
        if (goal>j) return 0;
        int i =0,k = goal-1;
        while (k<j){
            int x,y;
            if (i==0){
                x = index[i];
            }else {
                x = index[i] - index[i-1] - 1;
            }
            if (k == j-1){
                y = n-index[k]-1;
            }else {
                y = index[k+1] - index[k] - 1;
            }
            ans = ans + (x+1)*(y+1);
            i++;
            k++;
        }
        return ans;
    }
}
