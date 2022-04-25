package com.leecode;

import java.util.Arrays;

public class Test611 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 2,k = 0; i < n; i++) {
            k = 0;
            for (int l = i-1; l > 0&&l>k ; l--) {
                int left = k,right = l;
                while (left<right){
                    int mid = left + right >> 1;
                    if (nums[mid] + nums[l] <= nums[i]){
                        left = mid + 1;
                    }else {
                        right = mid;
                    }
                }
                k = left;
                ans += l - left;
            }

        }
        return ans;
    }
}
