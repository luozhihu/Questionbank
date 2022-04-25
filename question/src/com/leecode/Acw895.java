package com.leecode;

import java.io.*;

public class Acw895 {
    public static int N = 1010;
    public static int n;
    public static int[] a = new int[N];
    public static int[] f = new int[N];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        str = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(str[i-1]);
        }
        f[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                f[i] = 1;
                if (a[j]<a[i])
                f[i] = Math.max(f[i],f[j]+1);
            }
        }
        int t = 1;
        for(int i = 1;i<=n;i++){
            if(f[i]>f[t])
                t = i;
        }
        writer.write(f[t]+"");
        writer.flush();
        writer.close();
        reader.close();
    }
}
