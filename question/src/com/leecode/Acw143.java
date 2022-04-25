package com.leecode;

import java.io.*;

public class Acw143 {
    static int N = 100010;
    static int[][] trie = new int[N*32][2];
    static int index = 0;
    static int[] cnt = new int[N*32];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        String[] str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            insert(Integer.parseInt(str[i]));
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,quary(Integer.parseInt(str[i])));
        }
        //System.out.println(max);
        writer.write(max);
    }
    public static void insert(int x){
        int p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if(trie[p][u] == 0){
                trie[p][u] = ++index;
            }
            p = trie[p][u];
        }
        cnt[p]++;
    }
    public static int quary(int x){
        int num = 0, p = 0;
        for (int i = 31; i >= 0; i--) {
            int u = (x >> i) & 1;
            if(trie[p][1 - u] != 0){
                num = 2*num + 1 - u;
                p = trie[p][1 - u];
            }else {
                num = 2*num + u;
                p = trie[p][u];
            }
        }
        return x ^ num;
    }
}
