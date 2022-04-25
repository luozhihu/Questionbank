package com.leecode;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Acw844 {
    public static int[][] path = new int[110][110];
    public static int[][] d = new int[110][110];
    public static int[][] dist = new int[110][110];
    public static int n,m;
    public static Queue<int[]> Q = new LinkedList<>();

    public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        for (int i = 0; i < n; i++) {
            str = reader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                path[i][j] = Integer.parseInt(str[j]);
            }
        }
        int[] arr = {0,0};
        Q.offer(arr);
        bfs();

    }
    public static void bfs() throws IOException{
        int[] add;
        add=Q.poll();
        d[add[0]][add[1]] =1;
        //int[] arr = new int[2];
        if(add[0]==n-1&&add[1]==m-1){
            writer.write(""+dist[add[0]][add[1]]);
            writer.flush();
            return;
        }
        int[] dx = {1,0,-1,0},dy = {0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            int x = add[0] + dx[i], y = add[1] + dy[i];
            if(x>=0&&y>=0&&path[x][y] == 0&&d[x][y] == 0&&x<n&&y<m){
                int[] arr = new int[2];
                arr[0] = x;
                arr[1] = y;
                dist[x][y] = dist[add[0]][add[1]] + 1;
                Q.offer(arr);
            }
        }
        bfs();
    }
}
