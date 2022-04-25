package com.leecode;

public class Test1011 {
    public static void main(String[] args) {
        int[] weights = {10,50,100,100,50,100,100,100};
        System.out.println(shipWithinDays(weights,5));
    }
    public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int l = 0,r = 30;
        while(l<r){
            int mid = l + r >> 1;
            if (check(weights,mid,days)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    public static boolean check(int[] weights,int w,int days){
        int n = weights.length;
        int count = 0;
        int day = 0;
        for (int i = 0; i < n; i++) {
            if (weights[i]>w){
                return false;
            }
            count += weights[i];
            if (count>w){
                day++;
                count = weights[i];
            }
        }
        day++;
        return day<=days;
    }
}
