package com.leecode;

import java.io.*;

public class Acw898 {
    public static int N = 510;
    public static int n;
    public static int[][] a = new int[N][N];
    public static int[][] f = new int[N][N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        for (int i = 1; i <= n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 1; j <=  i; j++) {
                a[i][j] = Integer.parseInt(str[j-1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j>1&&j<i)
                f[i][j] = Math.max(f[i-1][j-1],f[i-1][j]) + a[i][j];
                else if(j==1)
                    f[i][j] = f[i-1][j] + a[i][j];
                else if (j==i)
                    f[i][j] = f[i-1][j-1] + a[i][j];
            }
        }
        int t=1;
        for (int i = 1; i <= n; i++) {
            if (f[n][i]>f[n][t]){
                t=i;
            }
        }
        writer.write(f[n][t]+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
