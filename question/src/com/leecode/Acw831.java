package com.leecode;

import java.io.*;

public class Acw831 {
    public static void main(String[] args) throws IOException{
        int N = 100000;
        int[] a = new int[N],p = new int[N],next = new int[N];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String str = reader.readLine();
        for (int i = 1; i <= n; i++) {
            p[i] = str.charAt(i-1);
        }
        int m = Integer.parseInt(reader.readLine());
        str = reader.readLine();
        for (int i = 1; i <= m; i++) {
            a[i] = str.charAt(i-1);
        }
        for (int i = 2,j = 0; i <= n; i++) {
            while (j > 0 && p[i] != p[j+1]){
                j = next[j];
            }
            if(p[i] == p[j+1]) j++;
            next[i] = j;
        }
        for (int i = 1,j = 0; i <= m; i++) {
            while (j > 0 && a[i] != p[j+1]){
                j = next[j];
            }
            if(a[i] == p[j+1])
            j++;
            if(j == n){
                writer.write(i - n + " ");
                j = next[j];
            }
        }
        reader.close();
        writer.close();
    }
}
