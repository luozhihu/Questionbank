package com.leecode;

public class Test633 {
    public static void main(String[] args) {
        int c = 2147483642;
        System.out.println(judgeSquareSum(c));
    }
    public static boolean judgeSquareSum(int c) {
        int max = (int)Math.sqrt(c);
        for (int a = 0; a <= max; a++) {
            int b = (int)Math.sqrt(c - a * a);
            if (a * a + b * b == c) return true;
        }
        return false;
    }
}
