package com.leecode;

import java.io.*;

public class Acw798 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n,m,q;
        String[] str1 = reader.readLine().split(" ");
        n = Integer.parseInt(str1[0]);
        m = Integer.parseInt(str1[1]);
        q = Integer.parseInt(str1[2]);
        int[][] a = new int[n+1][m+1];
        int[][] b = new int[n+10][m+10];
        for (int i = 1; i <= n; i++) {
            String[] str2 = reader.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                a[i][j] = Integer.parseInt(str2[j-1]);
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                insert(b,i,j,i,j,a[i][j]);
            }
        }
        for (int i = 0; i < q; i++) {
            String[] address = reader.readLine().split(" ");
            insert(b,Integer.parseInt(address[0]),Integer.parseInt(address[1]),Integer.parseInt(address[2]),Integer.parseInt(address[3]),Integer.parseInt(address[4]));
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = a[i-1][j] + a[i][j-1] - a[i-1][j-1] + b[i][j];
                writer.write(a[i][j] + " ");
            }
            writer.write("\n");
        }
        writer.flush();
        reader.close();
        writer.close();
    }
    public static void insert(int[][] b,int x1,int y1,int x2,int y2,int c){
        b[x1][y1] += c;
        b[x1][y2+1] -= c;
        b[x2+1][y1] -= c;
        b[x2+1][y2+1] += c;
    }
}
