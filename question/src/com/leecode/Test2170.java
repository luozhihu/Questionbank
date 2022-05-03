package com.leecode;

import java.util.Arrays;

public class Test2170 {
    static int N = 100010;
    static int[] m1 = new int[N], m2 = new int[N];
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        Arrays.fill(m1, 0);
        Arrays.fill(m2, 0);
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = 0; i < n; i++) {
            int t = nums[i];
            //偶数数组
            if (i % 2 == 0) {
                m1[t]++;
                //记录最大值重复值的下标
                if (a == 0 || m1[t] > m1[a]) {
                    b = a; a = t;
                } else if (t != a && (b == 0 || m1[t] > m1[b])) {//记录次大重复值的下标
                    b = t;
                }
            } else {//奇数数组
                m2[t]++;
                //记录最大值重复值的下标
                if (c == 0 || m2[t] > m2[c]) {
                    d = c; c = t;
                } else if (t != c && (d == 0 || m2[t] > m2[d])) {//记录次大重复值的下标
                    d = t;
                }
            }
        }
        //如果两组数不重复则直接使用，否则使用较长的那组
        if (a != c) return n - m1[a] - m2[c];
        else return n - Math.max(m1[a] + m2[d], m1[b] + m2[c]);
    }
}
