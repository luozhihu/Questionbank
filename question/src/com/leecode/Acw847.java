package com.leecode;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Acw847 {
    public static int N = 100010;
    public static int[] h = new int[N];
    public static int[] e = new int[2*N];
    public static int[] ne = new int[2*N];
    public static int[] d = new int[N];
    public static boolean[] st = new boolean[N];
    public static int idx = 1;
    public static int m;
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for(int i = 0; i < N; i ++)
        {
            //h[i] = -1;
            d[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
            add(a,b);
        }
        int ans = bfs();
            writer.write("" + ans);
        writer.flush();
        writer.close();
        reader.close();
    }
    public static void add(int x,int y){
        e[idx] = y; ne[idx] = h[x]; h[x] = idx++;
    }
    public static int bfs(){
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(1);
        d[1] = 0;
        st[1] = true;
        while (Q.size() != 0){
            int i = Q.poll();
            st[i] = true;
            for (int j = h[i]; j != 0 ; j = ne[j]) {
                int k = e[j];
                if(st[k] == false){
                    Q.offer(k);
                    d[k] = d[i] + 1;
                    if (k == n){
                        return d[k];
                    }
                }
            }
        }
        return -1;
    }
}
