package com.leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Test1707 {
    int[][] f = new int[32*100000][2];
    int count = 0;

    public Test1707(){
        for (int i = 0; i <= count; i++) {
            Arrays.fill(f[i],0);
        }
        count = 0;
    }
    void add(int x){
    int p = 0;
        for (int i = 31; i >= 0 ; i--) {
            int a = (x >> i) & 1;
            if (f[p][a] == 0) f[p][a] = ++count;
            p = f[p][a];
        }
    }
    int get(int x){
        int p =0;
        int ans = 0;
        for (int i = 31; i >= 0 ; i++) {
            int a = (x >> i) & 1,b = 1 - a;
            if (f[p][b] != 0){
                ans = ans | b << i;
                p = f[p][b];
            }else {
                ans = ans | a << i;
                p = f[p][a];
            }
        }
        return ans ^ x;
    }
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int m = nums.length, n = queries.length;

        // 使用哈希表将原本的顺序保存下来
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(queries[i], i);
        Arrays.sort(nums);
        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int i = 0;
        int[] ans = new int[n];
        for (int[] arr : queries) {
            int x = nums[i];
            if (x <= arr[1]){
                add(x);
                i++;
            }

            if (i==0) {
                ans[map.get(arr)] = -1;
            }else {
                ans[map.get(arr)] = get(arr[0]);
            }

        }
        return ans;
    }
}