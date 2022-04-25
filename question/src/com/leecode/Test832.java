package com.leecode;

import java.util.Arrays;

public class Test832 {
    public static void main(String[] args) {
        int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
        for (int i = 0; i < image.length; i++) {
            System.out.println(Arrays.toString(flipAndInvertImage(image)[i]));
        }
    }
    public static int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = image[i][n-1-j];
                ans[i][j] = Math.abs(ans[i][j]-1);
            }
        }
        return ans;
    }
}
