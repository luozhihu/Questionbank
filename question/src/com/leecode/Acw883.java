package com.leecode;

import java.io.*;

public class Acw883 {
    public static double eps = 1e-6;
    public static double[][] a = new double[100+10][100+10];
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        //double[][] a = new double[n+10][n+10];
        int i = 1;
        while (i<=n){
            str = reader.readLine().split(" ");
            for (int j = 1; j <= n+1 ; j++) {
                a[i][j] = Double.parseDouble(str[j-1]);
            }
            i++;
        }
        for (int j = 1; j <= n ; j++) {
            writer.write(a[j][n+1]+"\n");
        }
        writer.flush();
        int t = gauss(n);
        if(t==2){
            writer.write("No solution");
        }else if (t==1){
            writer.write("Infinite group solution");
        }else if(t==0){
            for (int j = 1; j <= n ; j++) {
                writer.write(a[j][n+1]+"\n");
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }
    public static int gauss(int n){
        int r,c;
        for(r=1,c=1;r<=n;c++){
            int t = r;
            for (int i = t; i <= n ; i++) {
                if(Math.abs(a[t][c]) < Math.abs(a[i][c])){
                    t = i;
                }
            }
            if (Math.abs(a[t][c]) < eps) continue;
            for (int i = 1; i <= n+1 ; i++) {
                a[t][i] = a[t][i] + a[r][i];
                a[r][i] = a[t][i] - a[r][i];
                a[t][i] = a[t][i] - a[r][i];
            }
            for (int i = r; i <= n+1 ; i++) {
                a[r][i] = a[r][i] / a[r][c];
            }
            for (int i = r + 1; i <= n ; i++) {
                if(a[i][c] < eps){
                    continue;
                }else {
                    for (int j = c; j <= n+1 ; j++) {
                       a[i][j] = a[i][j] - a[i][c]*a[r][j];
                    }
                }
            }
            r++;
        }
        if (r<=n){
            for (int i = r; i <= n ; i++) {
                if (Math.abs(a[i][n+1]) > eps){
                    return 2;
                }
            }
            return 1;
        }
        for (int i = n; i > 0 ; i--) {
            for (int j = i-1; j >= 1 ; j--) {
                //double d = a[j][i] / a[i][i];
                a[j][n+1] = a[j][n+1] - a[j][i]*a[i][n+1];
            }
        }
        return 0;
    }
}
