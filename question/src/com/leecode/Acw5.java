package com.leecode;

import java.io.*;

public class Acw5 {
    public static int N = 2010;
    public static int n,m;
    public static int[] v = new int[N],w = new int[N],s = new int[N];
    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int a,b,s;
            str = reader.readLine().split(" ");
            a = Integer.parseInt(str[0]);
            b = Integer.parseInt(str[1]);
            s = Integer.parseInt(str[2]);
            int k = 1;
            while (k <= s){
                cnt ++;
                v[cnt] = a*k;
                w[cnt] = b*k;
                s -= k;
                k *= 2;
            }
            if (s > 0){
                cnt ++;
                v[cnt] = a*s;
                w[cnt] = b*s;
            }
        }
        n = cnt;
        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= v[i] ; j--) {
                f[j] = Math.max(f[j],f[j-v[i]]+w[i]);
            }
        }
        writer.write(f[m]+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
