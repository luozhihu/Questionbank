package com.leecode;

import java.util.Arrays;

public class Test45 {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        int n = jump(nums);
        System.out.println(n);
    }
    public static int jump(int[] nums){
        int n = nums.length;
        int[] f = new int[n];
        Arrays.fill(f,Integer.MAX_VALUE-1);
        f[0] = 0;
        int i = 0;
        int d = nums[0];
        while (i<n){
            int cur = d;
            for (int j = i+1; j <= cur&&j<n; j++) {
                f[j] = f[i]+1;
                d = Math.max(d,nums[j]+j);
            }
            i=cur;
        }
        return f[n-1];
    }
}
