package com.leecode;

public class Test517 {
    public int findMinMoves(int[] ms) {
        int n = ms.length;
        int sum = 0;
        //计算所有衣服的和
        for (int i : ms) sum += i;
        //不能均分输出-1
        if (sum % n != 0) return -1;
        //t为每台洗衣机应该有的衣服件数
        int t = sum / n;
        //ls表示当前洗衣机左侧的所有洗衣机内衣服的和，rs表示右侧
        int ls = 0, rs = sum;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            rs -= ms[i];
            //a表述左侧需要衣服的件数
            int a = Math.max(t * i - ls, 0);
            //b表述右侧需要衣服的件数
            int b = Math.max((n - i - 1) * t - rs, 0);
            ans = Math.max(ans, a + b);
            ls += ms[i];
        }
        return ans;
    }
}
