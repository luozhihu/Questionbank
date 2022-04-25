package com.leecode;

import java.io.*;

public class Acw4 {
    public static int N = 1010;
    public static int n,m;
    public static int[] v = new int[N],w = new int[N],s = new int[N];
    public static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 1; i <= n; i++) {
            str = reader.readLine().split(" ");
            v[i] = Integer.parseInt(str[0]);
            w[i] = Integer.parseInt(str[1]);
            s[i] = Integer.parseInt(str[2]);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= s[i]; k++) {
                    if (j>=v[i]*k)
                    f[i][j] = Math.max(f[i][j],f[i-1][j-v[i]*k]+w[i]*k);
                }
            }
        }
        writer.write(f[n][m]+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
