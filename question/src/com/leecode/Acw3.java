package com.leecode;

import java.io.*;

public class Acw3 {
    public static int N = 1010;
    public static int n,m;
    public static int[] v = new int[N],w = new int[N];
    public static int[] f = new int[N];

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
        }
        for (int i = 1; i <= n; i++) {
            for (int j = v[i]; j <= m; j++) {
                    f[j] = Math.max(f[j],f[j-v[i]]+w[i]);
            }
        }
        writer.write(f[m]+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
