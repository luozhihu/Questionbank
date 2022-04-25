package com.leecode;

public class Test162 {
    public static void main(String[] args) {
        int[] nums = new int[]{-2147483648};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0,r = n - 1;
        while (l<r){
            int mid = l + r >> 1;
            if (nums[mid] < nums[mid+1]){
                l = mid+1;
            }else {
                r = mid;
            }
        }
        return r;
    }
}
