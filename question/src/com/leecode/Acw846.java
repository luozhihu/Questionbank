package com.leecode;

import java.io.*;

public class Acw846 {
    public static int N = 100010;
    public static int[] h = new int[N];
    public static int[] e = new int[2*N];
    public static int[] ne = new int[2*N];
    public static int idx;
    public static int n;
    public static int ans = N;

    public static boolean[] st = new boolean[N];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        for (int i = 0; i < N; i++) {
            h[i] = -1;
        }
        for (int i = 0; i < n - 1; i++) {
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
            add(a,b);
            add(b,a);

        }
        dfs(1);
        writer.write(""+ans);
        writer.flush();
        writer.close();
        reader.close();
    }
    public static void add(int x,int y){
        e[idx] = y;
        ne[idx] = h[x];
        h[x] = idx++;
    }
    public static int dfs(int x){
        int res = 0;
        int sum = 1;
        st[x] = true;
        for(int i = h[x];i != -1;i = ne[i]){
            int j = e[i];
            if(st[j] == false){
                int s = dfs(j);
                res = Math.max(res, s);
                sum += s;
            }
        }
        res = Math.max(res, n - sum);
        ans = Math.min(res, ans);
        return sum;
    }
}
