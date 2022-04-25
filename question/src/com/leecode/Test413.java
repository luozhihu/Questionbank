package com.leecode;

public class Test413 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,8,9,10};
        System.out.println(numberOfArithmeticSlices(nums));
    }
    public static int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2;) {
            int j = i;
            int d = nums[i+1] - nums[i];
            while (j<n-1&&d==nums[j+1] - nums[j]) j++;
            int a = 1,an = j-i+1-3+1;
            ans = ans +(a+an)*an/2;
            i=j;
        }
        return ans;
    }
}
