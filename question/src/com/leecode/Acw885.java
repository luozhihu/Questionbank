package com.leecode;

import java.io.*;

public class Acw885 {
    public static int mod = 1000000007;
    public static int[][] a = new int[2010][2010];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < 2010; i++) {
            for (int j = 0; j <= i; j++) {
                if(j == 0) a[i][j] = 1;
                else {
                    a[i][j] = (a[i-1][j] + a[i-1][j-1])%mod;
                }
            }
        }
        int n = Integer.parseInt(str[0]);
        while (n-->0){
            str = reader.readLine().split(" ");
            int x = Integer.parseInt(str[0]), y = Integer.parseInt(str[1]);
            writer.write(a[x][y]+"\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }
}
