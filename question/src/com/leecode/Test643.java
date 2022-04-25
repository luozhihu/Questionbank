package com.leecode;

public class Test643 {
    public static void main(String[] args) {
        int[] nums = {0,4,0,3,2};
        System.out.println(findMaxAverage(nums,1));
    }
    public static double findMaxAverage(int[] nums, int k) {
        int n = nums.length,i=0,j=k;
        double sum = 0,ans = 0;
        for (int l = 0; l < k; l++) {
            sum += nums[l];
        }
        ans = sum;
        while (j<n){
            sum = sum+nums[j]-nums[i];
            ans=Math.max(ans,sum);
            j++;
            i++;
        }
       ans = ans/k;
        return ans;
    }
}
