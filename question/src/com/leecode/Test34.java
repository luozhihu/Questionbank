package com.leecode;

public class Test34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(searchRange(nums,target));
    }
    public static int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int i = 0,j = n-1;
        int[] ans = {-1,-1};
        while (i<j){
            int mid = (i + j + 1)/2;
            if (nums[mid]<=target){
                i = mid;
            }else {
                j = mid - 1;
            }
        }
        if (nums[i]!=target)return ans;
        ans[0] = i;
        i = 0;
        j = n - 1;
        while (i<j) {
            int mid = (i + j) / 2;
            if (nums[mid] >= target) {
                j = mid;
            } else {
                i = mid + 1;
            }
        }
        ans[1] = i;
        return ans;
    }
}
