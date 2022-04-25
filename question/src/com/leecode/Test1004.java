package com.leecode;

public class Test1004 {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(nums,3));
    }
    public static int longestOnes(int[] nums, int k) {
        int ans = 0;
        for(int i = 0,j = 0,tot = 0;i < nums.length;i++){
            tot += nums[i];
            while(i-j+1>k) tot -= nums[j++];
            ans = Math.max(ans,tot);
        }
        return ans;
    }
}
