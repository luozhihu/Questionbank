package com.leecode;

public class Test517 {
    public int findMinMoves(int[] machines) {
        int count = 0;
        int n = machines.length;
        for (int i = 0; i < n; i++) {
            count += machines[i];
        }
        if (count%n!=0) return -1;
        int num = count/n;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (machines[i]>num) ans += machines[i] - num;
        }
        return ans;
    }
}
