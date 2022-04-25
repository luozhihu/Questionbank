package com.leecode;

import java.io.*;

public class Acw897 {
    public static int N = 1010;
    public static int n,m;
    public static int[] A = new int[N], B = new int[N];
    public static int[][] f = new int[N][N];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            A[i] = str[0].charAt(i-1);
        }
        str = reader.readLine().split(" ");
        for (int i = 1; i <= m; i++) {
            B[i] = str[0].charAt(i-1);;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                f[i][j] = Math.max(f[i-1][j],f[i][j-1]);
                if(A[i] == B[j]){
                    f[i][j] = Math.max(f[i][j],f[i-1][j-1]+1);
                }
            }
        }
        writer.write(f[n][m]+"");
        writer.flush();
        writer.close();
        reader.close();
    }

}
