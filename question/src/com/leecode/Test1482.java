package com.leecode;

public class Test1482 {
    public static void main(String[] args) {
        int[] bloomDay = {1,10,3,10,2};
        System.out.println(minDays(bloomDay,3,2));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
       int n = bloomDay.length;
       int l = 1,r = 1000000000;
       if (m*n>n) return -1;
       while (l<r){
           int mid = l + r >> 1;
           if (check(mid,bloomDay,m,k)){
               r = mid;
           }else {
               l = mid + 1;
           }
       }
       return l;
    }
    public static boolean check(long mid,int[] bloomDay,int m,int k){
        int count = 0;
        int ans = 0;
        int n = bloomDay.length;
        for (int i = 0; i < n; i++) {
            if (bloomDay[i] <= mid){
                count++;
                if (count>=k) {
                    ans++;
                    count=0;
                }
            }else {
                count=0;
            }
        }
        if (ans>=m){
            return true;
        }else {
            return false;
        }
    }
}
