package com.leecode;

public class Test81 {
    public static void main(String[] args) {
        int[] nums = {2,2,2,0,2,2};
        System.out.println(search(nums,0));
    }
    public static boolean search(int[] nums, int target) {
        int n = nums.length;
        int i = 0, j = n-1;
        while(i<j&&nums[i] == nums[j]) j--;
        int r = j;
        while (i<j){
            int mid = (i+j+1)/2;
            if (check(nums,target,mid,i,r)){
                i = mid;
            }else {
                j = mid - 1;
            }
        }
        if (nums[i] == target){
            return true;
        }else {
            return false;
        }
    }

    private static boolean check(int[] nums,int target,int mid,int i,int r) {
        if (target>=nums[0]){
            if (nums[mid]<nums[0]){
                return false;
            }else {
                return target>=nums[mid];
            }
        }
        if (target<=nums[r]){
            if (nums[mid]>nums[r]){
                return true;
            }else {
                return target>=nums[mid];
            }
        }
        return false;
    }
}
