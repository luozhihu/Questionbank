package com.leecode;

import java.io.*;

public class Acw840 {
    public static int N = 100003,idx;
    public static int[] h = new int[N], e = new int[N], ne = new int [N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        for (int i = 0; i < N; i++) {
            h[i] = -1;
        }
        while (n-->0){
            str = reader.readLine().split(" ");
            if(str[0].equals("I")){
                insert(Integer.parseInt(str[1]));
            }else if (str[0].equals("Q")){
                if (find(Integer.parseInt(str[1]))){
                    writer.write("Yes");
                    writer.write("\n");
                    writer.flush();
                }else {
                    writer.write("No");
                    writer.write("\n");
                    writer.flush();
                }
            }
        }
        writer.close();
        reader.close();
    }
    public static void insert(int x){
        int k = (x % N + N) % N;
        e[idx] = x;
        ne[idx] = h[k];
        h[k] = idx++;
    }
    public static boolean find(int x){
        int k = (x % N + N) % N;
        for (int i = h[k]; i != -1; i = ne[i]) {
            if (e[i] == x) {
                return true;
            }
        }
        return false;
    }
}
