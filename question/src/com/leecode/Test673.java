package com.leecode;


public class Test673 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findNumberOfLIS(nums));

    }
    public static int findNumberOfLIS(int[] nums){
        int n = nums.length;
        int[] f = new int[n], g = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            f[i] = g[i] = 1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    if(f[i] < f[j] + 1){
                        f[i] = f[j] + 1;
                        g[i] = g[j];
                    }else if(f[i] == f[j] + 1){
                        g[i] += g[j];
                    }
                }
            }
            max = Math.max(max,f[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(f[i] == max){
                ans += g[i];
            }
        }
        return ans;
    }
}
