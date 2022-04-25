package com.leecode;

public class Test29 {
    public static void main(String[] args) {
        System.out.println(divide(-2147483648,-1));
    }
    public static int divide(int dividend, int divisor) {
        long a = dividend,b = divisor;
        int flag = 1;
        if (a * b < 0) flag = -1;
        a = Math.abs(a);
        b = Math.abs(b);
        long left = 0,right = a;
        while (left<right){
            long mid = left + right + 1 >> 1;
            if (mid * b <= a){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        left = flag*left;
        if (left>Integer.MAX_VALUE||left<Integer.MIN_VALUE) return Integer.MAX_VALUE;
        return (int)left;
    }
}
