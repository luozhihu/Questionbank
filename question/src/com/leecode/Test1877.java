package com.leecode;

import java.util.Arrays;

public class Test1877 {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0,j = n - 1; i < j; i++,j--) {
            if (ans<nums[i]+nums[j]) ans = nums[i]+nums[j];
        }
        return ans;
    }
}
