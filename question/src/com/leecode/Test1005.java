package com.leecode;

public class Test1005 {
    public static void main(String[] args) {
        System.out.println(0%2);
    }
    public static int largestSumAfterKNegations(int[] nums, int k) {
        int cnts[] = new int[210];
        //+100偏移量，将数组存入cnts中
        for (int an : nums) cnts[an+100]++;
        for (int i = -100; i < 0 && k>0; i++) {
            //从最小值开始翻转数组
            while (cnts[i + 100] != 0 && k-- > 0) {
                cnts[i + 100]--; cnts[-i + 100]++;
            }
        }
        //如果数组中不存在0，且剩余奇数次翻转次数，那么将最小的数翻转过来
        if (k>0&&k%2!=0&&cnts[100]==0){
            int x = 0;
            while (cnts[x+100]==0) {
                x++;
            }
            cnts[-x+100]++;
            cnts[x+100]--;
        }
        int ans = 0;
        //把答案累加
        for (int i = -100; i <= 100; i++) {
            ans += i*cnts[i+100];
        }
        return ans;
    }
}