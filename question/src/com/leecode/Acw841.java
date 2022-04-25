package com.leecode;

import java.io.*;

public class Acw841 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        int P = 131;
        long[] h = new long[n + 10];
        long[] p = new long[n + 10];
        p[0] = 1;
        h[0] = 0;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i-1] * P;
            h[i] = h[i-1] * P + str[0].charAt(i-1);
        }
        while (m-->0){
            str = reader.readLine().split(" ");
            int l1 = Integer.parseInt(str[0]), r1 = Integer.parseInt(str[1]), l2 = Integer.parseInt(str[2]), r2 = Integer.parseInt(str[3]);
            String out = h[r1] - h[l1 - 1] * p[r1 - l1 + 1] == h[r2] - h[l2 - 1] * p[r2 - l2 + 1] ? "Yes" : "No";
            writer.write(out+"\n");
            writer.flush();
        }
        writer.close();
        reader.close();
    }
}
