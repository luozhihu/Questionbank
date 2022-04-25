package com.leecode;

import java.io.*;

public class Acw282 {
    public static int N = 310;
    public static int n;
    public static int[] s = new int[N];
    public static int[][] f = new int[N][N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        str = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            s[i] = Integer.parseInt(str[i-1]);
        }
        for (int i = 1; i <= n; i++) {
            s[i] += s[i-1];
        }
        for (int len = 2;len <= n;len++)
        for (int i = 1; i + len - 1 <= n; i++) {
            int l = i,r = i + len - 1;
            f[l][r] = (int)1e8;
                for (int k = l; k < r; k++) {
                    f[l][r] = Math.min(f[l][r],f[l][k]+f[k+1][r]+s[r]-s[l-1]);
            }
        }
        writer.write(f[1][n]+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
