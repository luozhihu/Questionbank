package com.leecode;

import java.io.*;

public class Acw868 {
    public static int get_prim(int n){
        boolean[] st = new boolean[n+1];
        int count = 0;
        for (int i = 2; i <= n  ; i++) {
            if (st[i] == false){
                count++;
            }
            for (int j = i + i;j <= n; j += i){
                st[j] = true;
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = reader.readLine();
        int n = Integer.parseInt(str);
        writer.write(""+get_prim(n));
        writer.flush();
    }
}
