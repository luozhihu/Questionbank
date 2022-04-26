package com.leecode;

public class Test1005 {
    public static void main(String[] args) {
        int[] nums = {-3,-1,2,3};
        System.out.println(largestSumAfterKNegations(nums,3));
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int[] cnts = new int[210];
        for (int i : nums) cnts[i + 100]++;
        for (int i = -100; i < 0 && k > 0; i++) {
            while (cnts[i + 100] != 0 && k-- > 0) {
                cnts[i + 100]--; cnts[-i + 100]++;
            }
        }
        if (cnts[0 + 100] == 0 && k > 0 && k % 2 != 0) {
            int val = 1;
            while (cnts[val + 100] == 0) val++;
            cnts[val + 100]--; cnts[-val + 100]++;
        }
        int ans = 0;
        for (int i = -100; i <= 100; i++) ans += i * cnts[i + 100];
        return ans;
    }
}