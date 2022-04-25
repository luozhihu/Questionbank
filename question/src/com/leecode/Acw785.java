package com.leecode;

import java.util.Scanner;

public class Acw785 {
    static int N = 100000;
    static int[] q= new int[N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = scan.nextInt();
        }
        int l = 0;
        int r = n-1;
        quick_sort(q,l,r);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i]+" ");
        }
    }

    public static void quick_sort(int[] q, int l, int r){
        if(l>=r) return;
        int i = l--, j = r++, x = q[l];
        while (i<j){
            do{
                i++;
            }while (q[i]<x);
            do{
                j--;
            }while (q[j]>x);
            if(i<j){
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
