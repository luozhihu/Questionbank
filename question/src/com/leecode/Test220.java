package com.leecode;

import java.util.*;

public class Test220 {
    public static void main(String[] args) {
        int[] nums = {1,5,9,1,5,9};
        System.out.println(containsNearbyAlmostDuplicate(nums,2,3));
    }
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        long size = t;
        Map<Long,Long> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long idx = find(nums[i],size);
            if (map.containsKey(idx)) return true;
            if (map.containsKey(idx+1)){
                if (map.get(idx+1) - nums[i] <=t) return true;
            }
            if (map.containsKey(idx-1)){
                if (nums[i] - map.get(idx-1) <=t) return true;
            }
            map.put(idx,(long)nums[i]);
            if (i>=k){
                map.remove(find(nums[i-k],size));
            }
        }
        return false;
    }
    static long find(long num,long size){
        if(size == 0){
            return num;
        }
        if (num>=0){
        return (int)(num / size);
        } else {
            return (int)((num+1) / size - 1);
        }
    }
}
