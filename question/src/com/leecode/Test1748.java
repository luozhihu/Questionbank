package com.leecode;

import java.util.Arrays;

public class Test1748 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,2};
        System.out.println(sumOfUnique(nums));
    }
    public static int sumOfUnique(int[] nums) {
//        int n = nums.length;
//        int[] mark = new int[101];
//        int ans = 0;
//        for (int i = 0; i < n; i++) {
//            if (mark[nums[i]] == 0){
//                mark[nums[i]] = 1;
//            }else {
//                mark[nums[i]]++;
//            }
//        }
//        for (int i = 0; i < 101; i++) {
//            if (mark[i] == 1){
//                ans += i;
//            }
//        }
//        return ans;
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        for (int i = 0,j = 0; i < n; i=j) {
            j=i+1;
            if (j>=n||nums[j]!=nums[i]){
                ans += nums[i];
            }else {
                while (nums[j]==nums[i]&&j<n) j++;

            }
        }
        return ans;
    }
}
