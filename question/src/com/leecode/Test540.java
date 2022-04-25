package com.leecode;

public class Test540 {
    public static void main(String[] args) {

    }
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int l = 0,r = n - 1;
        while (l<r){
            int mid = l + r >> 1;
            if (check(nums,mid)){
                l = mid + 1;
            }else {
                r = mid;
            }
        }
        return l;
    }
    boolean check(int[] nums,int mid){
        if (mid%2 == 0){
            if (nums[mid] == nums[mid+1]){
                return true;
            }else {
                return false;
            }
        }else {
            if (nums[mid] == nums[mid+1]){
                return false;
            }else {
                return true;
            }
        }
    }

}
