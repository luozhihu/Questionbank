package com.leecode;

import java.io.*;

public class Acw901 {
    public static int N = 310;
    public static int[][] dp = new int[N][N];
    public static int[][] a = new int[N][N];
    public static int[]  dx = {0,1,0,-1}, dy = {1,0,-1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int r = Integer.parseInt(str[0]),w = Integer.parseInt(str[1]);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < w; j++) {
                a[i][j] = (int)1e8;
                dp[i][j] = 1;
            }
        }
        for (int i = 0; i < r; i++) {
            str = reader.readLine().split(" ");
            for (int j = 0; j < w; j++) {
                a[i][j] = Integer.parseInt(str[j]);
            }
        }
        int ans = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < w; j++) {
                ans=Math.max(dfs(i,j),ans);
            }
        }
        writer.write(ans+"");
        writer.flush();
        writer.close();
        reader.close();

    }
    public static int dfs(int i,int j){
        if (dp[i][j]>1) return dp[i][j];
        for (int k = 0; k < 4; k++) {
            int x = i + dx[k], y = j + dy[k];
            if (x>=0&&y>=0&&a[x][y]<a[i][j]){
                dp[i][j] = Math.max(dfs(x,y) + 1,dp[i][j]);
            }
        }
        return dp[i][j];
    }
}
