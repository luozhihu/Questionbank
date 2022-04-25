package com.leecode;

import java.util.Scanner;

public class Acw786 {
    static int N = 100000;
    static int[] q = new int[N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int i = scan.nextInt();
        for (int j = 0; j < n; j++) {
            q[j] = scan.nextInt();
        }
        quick_sort(q, 0, n - 1);
        System.out.println(q[i-1]);
    }
    static void quick_sort(int[] q,int l,int r){
        if(l>=r) return;
        int i = l - 1,j = r + 1,x = q[l];
        while (i<j) {
            do {
                i++;
            } while (q[i] < x);
            do {
                j--;
            } while (q[j] > x);
            if (i < j) {
                int temp;
                temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q,l,j);
        quick_sort(q,j+1,r);
    }
}
