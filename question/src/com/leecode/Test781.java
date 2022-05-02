package com.leecode;

public class Test781 {
    public int numRabbits(int[] answers) {
        int f[] = new int[1010];
        for (int an : answers) {
            f[an]++;
        }
        int ans = 0;
        for (int i = 0; i < 1000; i++) {
            ans += ((f[i] + i)/(i + 1))*(i+1);
        }
        return ans;
    }
}
