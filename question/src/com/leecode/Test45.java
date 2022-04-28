package com.leecode;

import java.util.Arrays;

public class Test45 {
    public static void main(String[] args) {
        int[] nums = {2,3,0,1,4};
        //int n = jump(nums);
        //System.out.println(n);
    }
//    public static int jump(int[] nums){
//        int n = nums.length;
//        int[] f = new int[n];
//        Arrays.fill(f,Integer.MAX_VALUE-1);
//        f[0] = 0;
//        int i = 0;
//        int d = nums[0];
//        while (i<n){
//            int cur = d;
//            for (int j = i+1; j <= cur&&j<n; j++) {
//                f[j] = f[i]+1;
//                d = Math.max(d,nums[j]+j);
//            }
//            i=cur;
//        }
//        return f[n-1];
//    }
public int jump(int[] nums) {
    int n = nums.length;
    //n为数组最大长度，1000是最大跳跃距离
    int f[] = new int[n+1000];
    //last当前可达最远距离
    int last = 0;
    //到达n-1退出循环
    for (int i = 0; i < n && last < n - 1; i++) {
        int len = nums[i];
        //当跳远距离超过最远距离是，更新最远距离
        while (last<i+nums[i]){
            last++;
            f[last] = f[i] + 1;
        }
    }
    return f[n-1];
}
}
