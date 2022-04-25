package com.leecode;

import java.io.*;

public class Acw285 {
public static int[][] dp = new int[2][6010];
public static int[][] f = new int[2][6010];
public static int[] ind = new int[6010];
public static int[] vis = new int[6010];
public static int root;
public static void dfs(int u){
    if(u==0) return;
    vis[u] = 1;
    root = u;
    dp[0][f[0][u]]+=Math.max(dp[1][u]+f[1][u],dp[0][u]);
    dp[1][f[0][u]]+=dp[0][u];
    ind[f[0][u]]--;
    if (ind[f[0][u]]==0) dfs(f[0][u]);
}

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        for (int i = 1; i <= n; i++) {
            str = reader.readLine().split(" ");
            f[1][i] = Integer.parseInt(str[0]);
        }
        int a,b;
        for (int i = 1; i < n; i++) {
            str = reader.readLine().split(" ");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            f[0][a] = b;
            ind[b]++;
        }
        for (int i = 1; i <= n; i++) {
            if (vis[i]==0&&ind[i]==0)
                dfs(i);
        }
        writer.write(Math.max(dp[0][root],dp[1][root]+f[1][root])+"");
        writer.flush();
        writer.close();
        reader.close();
    }


}
