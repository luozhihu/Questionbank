package com.leecode;

public class Test367 {
    public static void main(String[] args) {

    }
    public boolean isPerfectSquare(int num) {
        long i = 0, j = num;
        while (i<j){
            long mid = (i + j + 1) >> 1;
            if (mid * mid <= num){
                i = mid;
            }else {
                j = mid - 1;
            }
        }
        if (i * i == num){
            return true;
        }else {
            return false;
        }
    }
}



