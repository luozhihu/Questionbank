package com.leecode;

import java.io.*;

public class Acw91 {
    public static int N = 20,M = 1<<N;
    public static int[][] f = new int[M][N],w = new int[N][N];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        for (int i = 0; i < n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                w[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j] = (int)1e8;
            }
        }
        f[1][0] = 0;
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                if((i>>j&1)==1)
                    for (int k = 0; k < n; k++) {
                        if ((i>>k&1)==1)
                            f[i][j] = Math.min(f[i][j],f[i-(1<<j)][k]+w[k][j]);
                    }
            }
        }
        writer.write(f[(1<<n)-1][n-1]+"");
        writer.flush();
        writer.close();
        reader.close();

    }
}
