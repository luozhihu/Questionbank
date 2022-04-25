package com.leecode;

import java.io.*;

public class Acw838 {
    public static int[] p = new int[10010];
    public static int size;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(str[i-1]);
        }
        size = n;
        for (int i = n/2; i > 0; i--) {
            down(i);
        }
        while (m -- > 0){
            writer.write(""+p[1]);
            writer.flush();
            p[1] = p[size];
            size--;
            down(1);
        }
        writer.close();
        reader.close();
    }
    public static void down(int u){
        int t = u;
        if(u * 2 <= size && p[u * 2] < p[t]) t = u*2;
        if(u * 2 + 1 <= size && p[u * 2 + 1] < p[t]) t = u* 2 + 1;
        if(u != t)
        {
            p[u] = p[u] + p[t];
            p[t] = p[u] - p[t];
            p[u] = p[u] - p[t];
            down(t);
        }
    }
}
