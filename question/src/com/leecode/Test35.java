package com.leecode;

public class Test35 {
    public static void main(String[] args) {

    }
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int i = 0,j = n - 1;
        while (i<j){
            int mid = (i + j)/2;
            if (nums[mid] < target){
                i = mid + 1;
            }else {
                j = mid;
            }
        }
        if (i == n - 1)
            return n;
        return i;
    }
}
