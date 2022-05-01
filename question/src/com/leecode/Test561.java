package com.leecode;

import java.util.Arrays;

public class Test561 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for(int i = 0;i < n;i+=2){
            ans += nums[i];
        }
        return ans;
    }
}
