package com.leecode;

import java.util.Arrays;
import java.util.HashMap;

public class Test594 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1};
        System.out.println(findLHS(nums));
    }
    public static int findLHS(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num :
                nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int max = 0;
        for (int n :
                map.keySet()) {
            if (map.containsKey(n - 1))
            max = Math.max(map.get(n)+map.getOrDefault(n-1,0),max);
        }
        return max;
    }
}
