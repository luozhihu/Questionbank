package com.leecode;

import java.util.TreeSet;

public class Test363 {
    public static void main(String[] args) {
        int[][] matrix = {{5,-4,-3,4},{-3,-4,4,5},{5,1,5,-4}};
        System.out.println(maxSumSubmatrix(matrix,10));
    }
    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length,m = matrix[0].length;
        int[][] f = new int[n+1][m+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = f[i-1][j] + f[i][j-1] - f[i-1][j-1] + matrix[i-1][j-1];
            }
        }
            long ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                TreeSet<Integer> treeSet = new TreeSet<>();
                //treeSet.add(0);
                for (int l = 0; l < m; l++) {
                    int right = f[j+1][l+1] - f[i][l+1];
                    Integer left = treeSet.ceiling(right-k);
                    if (left!=null){
                        ans = Math.max(ans,right-left);
                    }
                    treeSet.add(right);
                }
            }
        }
        return (int)ans;
    }
}
