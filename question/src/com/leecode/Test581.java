package com.leecode;

public class Test581 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,10,1,2,3,4,5};
        System.out.println(findUnsortedSubarray(nums));
    }
    public static int  MIN = -100005, MAX = 100005;
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int i = 0, j = n - 1;
        while (i < j && nums[i] <= nums[i + 1]) i++;
        while (i < j && nums[j] >= nums[j - 1]) j--;
        int l = i, r = j;
        int min = nums[i], max = nums[j];
        for (int u = l; u <= r; u++) {
            if (nums[u] < min) {
                while (i >= 0 && nums[i] > nums[u]) i--;
                min = i >= 0 ? nums[i] : MIN;
            }
            if (nums[u] > max) {
                while (j < n && nums[j] < nums[u]) j++;
                max = j < n ? nums[j] : MAX;
            }
        }
        return j == i ? 0 : (j - 1) - (i + 1) + 1;
    }
}
