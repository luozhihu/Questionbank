package com.leecode;

import java.io.*;

public class Acw9 {
    public static int N = 110;
    public static int n,m;
    public static int[] s = new int[N];
    public static int[][] v = new int[N][N],w = new int[N][N];
    public static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 1; i <= n; i++) {
            str = reader.readLine().split(" ");
            s[i] = Integer.parseInt(str[0]);
            for (int j = 1; j <= s[i]; j++) {
                str = reader.readLine().split(" ");
                v[i][j] = Integer.parseInt(str[0]);
                w[i][j] = Integer.parseInt(str[1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= s[i]; k++) {
                    //f[i][j] = f[i-1][j];
                    if (j>=v[i][k])
                    f[i][j] = Math.max(f[i][j],f[i-1][j-v[i][k]] + w[i][k]);
                }
            }
        }
        writer.write(f[n][m]+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
