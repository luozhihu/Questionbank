package com.leecode;

import java.io.*;


public class Acw842 {
    public static int N = 10;
    public static int n;
    public static int[] path = new int[N];
    public static int[] st = new int[N];
    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        dfs(0);
        writer.close();reader.close();
    }
    public static void dfs(int x) throws IOException{
        if(x == n){
            for (int i = 0; i < n; i++) {
                writer.write(path[i]+" ");
                writer.flush();
            }
            writer.write("\n");
            writer.flush();return;
        }
        for (int i = 1; i <= n; i++){
            if (st[i] == 0) {
                path[x] = i;
                st[i] = 1;
                dfs(x + 1);
                st[i] = 0;
            }
        }
    }

}
