package com.leecode;

import java.io.*;

public class Acw875 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        while (n-->0){
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int p = Integer.parseInt(str[2]);
            writer.write(quick_mi(a,b,p)+"\n");
            writer.flush();
        }
        writer.close();
        reader.close();

    }
    public static long quick_mi(int a,int b,int p){
        long res = 1;
        long x = a;
        while (b > 0){
            if((b & 1) == 1){
                res = res * x % p;
            }
            b >>= 1;
            x = x * x % p;
        }
        return res % p;
    }
}
