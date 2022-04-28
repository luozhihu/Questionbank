package com.leecode;

import java.util.Arrays;
import java.util.Stack;

public class Test334 {
//    public static boolean increasingTriplet(int[] nums) {
//        int n = nums.length;
//        int[] f = new int[n+1];
//        Arrays.fill(f,Integer.MAX_VALUE);
//        f[0] = 0;
//        for (int i = 0; i < n; i++) {
//            int l = 0,r = 3;
//            while (l<r){
//                int mid = l + r + 1 >> 1;
//                if (nums[i]>f[mid])
//                    l = mid;
//                else
//                    r = mid - 1;
//            }
//            f[l+1] = Math.min(f[l+1],nums[i]);
//            if (l+1==3) return true;
//        }
//        return false;
//    }
public boolean increasingTriplet(int[] nums) {
    int n = nums.length;
    //定长子序列的长度为3
    int f[] = new int[4];
    //初始化状态数组
    Arrays.fill(f,Integer.MAX_VALUE);
    for (int i = 0; i < n; i++) {
        if (nums[i]<f[1]) f[1] = nums[i];
        else if(nums[i]<f[2]) f[2] = nums[i];
        else if (nums[i]<f[3]) return true;
    }
    return false;
}
}
