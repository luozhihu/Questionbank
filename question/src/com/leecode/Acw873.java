package com.leecode;

import java.io.*;

public class Acw873 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        while ( n -- > 0){
            str = reader.readLine().split(" ");
            writer.write(gtc(Integer.parseInt(str[0]))+"\n");
            writer.flush();
        }
        writer.close();
        reader.close();
    }
    public static int gtc(int n){
        int[] prim = new int[n];
        int t = 0;
        int N = n;
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) prim[t++] = i;
            while (n % i == 0){
                n /= i;
            }
        }
        if(n > 1) prim[t++] = n;
        while (t -- > 0){
            N = N-N/prim[t];
        }
        return N;
    }
}
