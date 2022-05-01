package com.leecode;

public class Test765 {
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int ans = 0;
        int[] cache = new int[n];
        //记录每个数的下标
        for (int i = 0; i < n; i++) cache[row[i]] = i;
        //遍历数组+2
        for (int i = 0; i < n - 1; i += 2) {
            int a = row[i], b = a ^ 1;
            //如果当前数没有和情侣坐一起
            if (row[i + 1] != b) {
                int src = i + 1, tar = cache[b];
                cache[row[tar]] = src;
                cache[row[src]] = tar;
                swap(row, src, tar);
                ans++;
            }
        }
        return ans;
    }
    //交换位置
    void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
