package com.leecode;

public class Test33 {
    public static void main(String[] args) {
        int[] nums={4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums,target));
    }
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0,r = n - 1;
        while (l<r){
            int mid = l + r + 1 >> 1;
            if (nums[mid] >= nums[0]){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        int d = r;
        int left,right;
        int ans = 0;
        if (target>=nums[0]){
            left = 0;
            right=d;
        }else {
            left = d + 1;
            right = n - 1;
        }
        ans = find(nums,target,left,right);
        if (nums[ans] != target){
            return -1;
        }else {
            return ans;
        }
    }
    static int find(int[] nums, int target, int l, int r){
        while (l<r){
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return r;
    }
}
