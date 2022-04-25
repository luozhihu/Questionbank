package com.leecode;

import java.util.HashMap;

public class Test219 {
    public static void main(String[] args) {
    int[] nums = {1,2};
        System.out.println(containsNearbyDuplicate(nums,2));
    }
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0,j = k+1;
        int n = nums.length;
        for (int l = 0; l<n&&l <= k; l++) {
            int count =map.getOrDefault(nums[l],0);
            if (count==1) return true;
            map.put(nums[l],map.getOrDefault(nums[l],0)+1);
        }
        while (j<n){
            map.remove(nums[i]);
            int count =map.getOrDefault(nums[j],0);
            if (count==1) return true;
            map.put(nums[j],count+1);
            i++;
            j++;
        }
        return false;
    }
}
