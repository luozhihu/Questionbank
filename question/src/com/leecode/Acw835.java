package com.leecode;

import java.io.*;

public class Acw835 {
    static int N = 100000;
    static int[] cnt = new int[N];
    static int[][] trie = new int[N][26];
    static int index = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        while ( n -- > 0 ){
            String[] str = reader.readLine().split(" ");
            if(str[0].equals("I")){
                insert(str[1]);
            }else if(str[0].equals("Q")){
                //writer.write(quary(str[1]));
                System.out.println(quary(str[1]));
            }
        }
    }
    public static void insert(String str){
        int n = str.length();
        int p = 0;
        for (int i = 0; i < n; i++) {
            int u = trie[p][str.charAt(i) - 'a'];
            if(u == 0){
                trie[p][str.charAt(i) - 'a'] = ++index;
            }
            p = trie[p][str.charAt(i) - 'a'];
        }
        cnt[p] ++;
        }
    public static int quary(String str){
        int p = 0;
        for (int i = 0; i < str.length(); i++) {
            int u = trie[p][str.charAt(i) - 'a'];
            if(u == 0) return 0;
            p = u;
        }
        return cnt[p];
    }
}
