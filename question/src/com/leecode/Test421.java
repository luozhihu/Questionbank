package com.leecode;

import java.util.Arrays;

public class Test421 {
     static int[][] tree = new int[100000*31][2];
     static int idx = 0;
    public Test421() {
        for (int i = 0; i <= idx; i++) {
            Arrays.fill(tree[i], 0);
        }
        idx = 0;
        System.out.println("清理");
    }
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            add(num);
            ans = Math.max(ans,MaxX(num));
        }
        return ans;
    }
    void add(int x){
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1;
            if (tree[p][a] == 0) tree[p][a] = ++idx;
            p=tree[p][a];
        }
    }
    int MaxX(int x){
        int p = 0;
        int ans = 0;
        for (int i = 31; i >=0 ; i--) {
            int a = (x >> i) & 1,b = 1-a;
            if (tree[p][b] != 0) {
                ans += 1 << i;
                p = tree[p][b];
            }else {
                ans += 0<<i;
                p = tree[p][a];
            }
        }
        return ans;
    }
}
