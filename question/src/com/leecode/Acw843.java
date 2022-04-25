package com.leecode;

import java.io.*;

public class Acw843 {
    public static int N = 10;
    public static int n;
    public static int[][] path = new int[N][N];
    public static int[] row = new int[2*N],lie = new int[2*N], dg = new int[2*N], udg = new int[2*N];
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        dfs(1);
        reader.close();
        writer.close();
    }
    public static void dfs(int x)throws IOException{
        if (x == n+1){
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (path[i][j] == 1) {
                        writer.write("Q");
                        writer.flush();
                    }
                    else {
                        writer.write(".");
                        writer.flush();
                    }
                }
                writer.write("\n");
                writer.flush();
            }
            writer.write("\n");
            writer.flush();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (row[i] == 0){
                for (int j = 1; j <= n; j++) {
                    if (dg[i + j] == 0 && udg[n+i-j] == 0 && lie[j] == 0) {
                        path[i][j] = 1;
                        row[i] = 1;
                        dg[i + j] = 1;
                        udg[n+i-j] = 1;
                        lie[j] = 1;
                        dfs(x + 1);
                        path[i][j] = 0;
                        row[i] = 0;
                        dg[i + j] = 0;
                        udg[n+i-j] = 0;
                        lie[j] = 0;

                    }
                }
            }
        }
    }

}
