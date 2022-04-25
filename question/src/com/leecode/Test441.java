package com.leecode;

public class Test441 {
    public static void main(String[] args) {
        int n = 1804289383;
        System.out.println(arrangeCoins(n));
    }
    public static int arrangeCoins(int n) {
        long left=0,right=n,mid;
        mid = (left+right)/2;
        while (left < right) {
            mid = left + right + 1 >> 1;
            if (mid * (mid + 1) / 2 <= n) left = mid;
            else right = mid - 1;
        }
        System.out.println(left);
        if(left*(left+1)/2 <= n)
            return (int)left;
        return (int)left-1;
    }
}
