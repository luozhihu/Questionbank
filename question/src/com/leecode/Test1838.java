package com.leecode;

import java.util.Arrays;

public class Test1838 {
    public static void main(String[] args) {

    }
    public static int maxFrequency(int[] nums, int k) {
       Arrays.sort(nums);
        int n = nums.length;
        int count = 0,max = 0;
        for (int i = 0,j = 0;j<n;j++){
            if (j>0)
            count = count + (j-i)* (nums[j]-nums[j-1]);
            while (count>k){
                count = count - nums[j]+nums[i++];
            }
            max = Math.max(max,j-i+1);
        }
        return max;
    }
}
