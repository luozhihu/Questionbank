package com.leecode;

public class Test1414 {
    static long[] f = new long[93];
    static {
        f[1] = 1;
        f[2] = 1;
        for (int i = 3; i <= 92; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
    }
    public static void main(String[] args) {
        System.out.println(f[92]);
    }
    public static int findMinFibonacciNumbers(int k) {
        int a=1,b=1;
        while (b<=k){
            int c = a + b;
            a = b;
            b = c;
        }
        int ans = 0;
        while (k>0){
            while (k>=b){
                k -= b;
                ans++;
            }
            int c = b - a;
            b = a;
            a = c;
        }
        return ans;
    }
}
