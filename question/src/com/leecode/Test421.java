package com.leecode;

import java.util.Arrays;

public class Test421 {
//     static int[][] tree = new int[100000*31][2];
//     static int idx = 0;
//    public Test421() {
//        for (int i = 0; i <= idx; i++) {
//            Arrays.fill(tree[i], 0);
//        }
//        idx = 0;
//        System.out.println("清理");
//    }
//    public int findMaximumXOR(int[] nums) {
//        int ans = 0;
//        for (int num : nums) {
//            add(num);
//            ans = Math.max(ans,MaxX(num));
//        }
//        return ans;
//    }
//    void add(int x){
//        int p = 0;
//        for (int i = 31; i >= 0; i--) {
//            int a = (x >> i) & 1;
//            if (tree[p][a] == 0) tree[p][a] = ++idx;
//            p=tree[p][a];
//        }
//    }
//    int MaxX(int x){
//        int p = 0;
//        int ans = 0;
//        for (int i = 31; i >=0 ; i--) {
//            int a = (x >> i) & 1,b = 1-a;
//            if (tree[p][b] != 0) {
//                ans += 1 << i;
//                p = tree[p][b];
//            }else {
//                ans += 0<<i;
//                p = tree[p][a];
//            }
//        }
//        return ans;
//    }
static int N = 20000;
    static int idx = 0;
    //使用二维数组tree[i][j]实现字典树，其中tree[i][0]表示下一位的下标。
    static int[][] tree = new int[N*32][2];
    //初始化字典树
    public Test421(){
        for (int i = 0; i <= idx; i++) {
            tree[i][0] = 0;
            tree[i][1] = 0;
        }
        idx = 0;
    }
    //把数加入到字典树中
    public void add(int x){
        //每个数都从下标0开始添加
        int p = 0;
        //从最高位开始
        for (int i = 31; i >= 0; i--) {
            int a = (x >> i) & 1;
            //如果该位不存在，那么给这位赋值，值为下一位的下标。
            if(tree[p][a] == 0) tree[p][a] = ++idx;
            p = tree[p][a];
        }
    }
    public int MaxXor(int x){
        int p = 0;
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            //a表示该位的值0或1，b是对a取反
            int a = (x >> i) & 1,b = 1 - a;
            //如果b存在,那么把b这位加入到答案
            if (tree[p][b] != 0){
                ans += b << i;
                p = tree[p][b];
                //如果该位b不存在，那么只能把自己a加入到答案中,因为每个数都有32位，所以每一位上面不是0就是1。
            }else {
                ans += a << i;
                p = tree[p][a];
            }
        }
        return ans ^ x;
    }
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            add(nums[i]);
            ans = Math.max(ans,MaxXor(nums[i]));
        }
        return ans;
    }
}
