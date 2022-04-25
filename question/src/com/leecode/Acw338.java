package com.leecode;

import java.io.*;

public class Acw338 {
    public static int N = (int)1e8;
    public static int[] base= new int[10];
    public static int[][] f= new int[10][10];
    public static int[][] g= new int[10][10];

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(" ");
        init();
        int a,b;
        a = Integer.parseInt(str[0]);
        b = Integer.parseInt(str[1]);
        while (a!=0||b!=0){
            if (a>b){
                a=a+b;
                b=a-b;
                a=a-b;
            }
            int[] t = ask(a,b);
            prin(t);
        }
    }
    public static void init(){
        base[0] = 1;
        for (int i = 1; i < 10; i++) {
            base[i] = base[i-1]*10;
        }
        for (int i = 0; i < 10; i++) {
            f[1][i] = 1;
        }
        for (int i = 2; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                f[i][j] = base[i-1] + f[i-1][j]*10;
            }
        }
        for (int i = 0; i < 10; i++) {
            g[1][i] = 1;
        }
        for (int i = 2; i < 10; i++) {
            g[i][0] = g[i-1][0] + f[i-1][0]*9;
            for (int j = 1; j < 10; j++) {
                g[i][j] = g[i-1][j] + f[i-1][j]*9 + base[i-1];
            }
        }
    }
    public static int[] dp(int n){
        int[] ans = new int[10];
        if(n<=0) return ans;
        int[] nums = new int[10];
        int len = 0;
        for (int i = 0; n>0 ; i++) {
            nums[i] = n%10;
            n/=10;
            len++;
        }
        int[] last = new int[10];
        for (int i = 0; i <= 9; i++) {
            ans[i] = g[len-1][i];
        }
        for (int i = len-1; i >= 0; i--) {
            int x = nums[i];
            for (int j = (i == len-1) ? 0 : 1; j < x; j++) {
                for (int k = 0; k <= 9 ; k++) {
                    ans[k] += last[k] * base[i];
                }
                ans[j] += base[i];
                for (int k = 0; k <= 9; k++) {
                    ans[k] += f[i][k];
                }
                last[x] ++;
                if(i==0){
                    for (int k = 0; k < 10; k++) {
                        ans[k] += last[k];
                    }
                }
            }

        }
        return ans;
    }
    public static int[] ask(int a,int b){
        int[] x = dp(b);
        int[] y = dp(a-1);
        int[] ans = new int[10];
        for (int i = 0; i < 10; i++) {
            ans[i] = x[i] - y[i];
        }
        return ans;
    }
    public static void prin(int[] ans){
        for (int i = 0; i < 10; i++) {
            System.out.print(ans[i]);
        }
        System.out.println("");
    }
}
