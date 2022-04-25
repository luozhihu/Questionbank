package com.leecode;

import java.util.Arrays;
import java.util.Scanner;

public class Acw796 {
    public static void main(String[] args) {
        int n,m,q;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        q = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int[][] s = new int[n+10][m+10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                s[i][j] = s[i-1][j] + s[i][j-1] - s[i-1][j-1] + arr[i-1][j-1];
            }
        }
        for (int i = 0; i < q; i++) {
                int x1,x2,y1,y2;
                x1 = scanner.nextInt();
                y1 = scanner.nextInt();
                x2 = scanner.nextInt();
                y2 = scanner.nextInt();
            int ans = s[x2][y2] + s[x1-1][y1-1] - s[x1-1][y2] -s[x2][y1-1];
            System.out.println(ans);
        }
    }
}
