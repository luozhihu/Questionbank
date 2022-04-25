package com.leecode;

public class Test485 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(nums));

    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int[] count = new int[n+1];
        int left = 0,max = 0;
        for (int i = 0; i < n; i++) {
            count[i+1] = count[i] +nums[i];
            if (nums[i] == 0){
                max = Math.max(max,count[i]-count[left]);
                left=i;
            }
        }
        if (nums[n-1]==1){
            max = Math.max(max,count[n]-count[left]);
        }
        return max;
    }
}
