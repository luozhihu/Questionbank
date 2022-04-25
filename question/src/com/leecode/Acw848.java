package com.leecode;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Acw848 {
    public static int N = 100010;
    public static int[] h = new int[N];
    public static int[] e = new int[N];
    public static int[] ne = new int[N];
    public static int[] indig = new int[N];
    public static int[] outdig = new int[N];
    public static int[] path = new int[N];
    public static int[] st = new int[N];
    public static int n,m,idx=1,count;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 0; i < m; i++) {
            str = reader.readLine().split(" ");
            int a = Integer.parseInt(str[0]), b = Integer.parseInt(str[1]);
            add(a,b);
            indig[b]++;
        }
        bfs();
        if(count == n){
            for (int i = 0; i < n; i++) {
                writer.write(path[i]+" ");
                writer.flush();
            }
        }else {
            writer.write(""+-1);
            writer.flush();
        }
        writer.close();
        reader.close();

    }
    public static void add(int x,int y){
        e[idx] = y; ne[idx] = h[x]; h[x] = idx++;
    }
    public static void bfs(){
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indig[i] == 0){
                Q.offer(i);
                path[count++] = i;
                st[i] = 1;
            }
        }
        while (!Q.isEmpty()){
            int i = Q.poll();
            st[i] = 1;
            for (int j = h[i]; j!=0;j=ne[j]){
                int k = e[j];
                indig[k]--;
                if(indig[k] == 0&&st[k] == 0){
                    Q.offer(k);
                    path[count++] = k;
                    st[k] = 1;
                }
            }
        }
    }
}
