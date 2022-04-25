package com.leecode;

public class Test1894 {
    public static void main(String[] args) {
        int[] chalk = new int[]{3,4,1,2};
        int k = 25;
        System.out.println(chalkReplacer(chalk, k));
    }
    public static int chalkReplacer(int[] chalk, int k) {
        long count = 0;
        int n = chalk.length;
        for (int i = 0; i < n; i++) {
            count += chalk[i];
        }
        count = k % count;
        int i;
        for (i = 0; i < n; i++) {
            count -= chalk[i];
            if (count<0) break;
        }
        return i;
    }
}
