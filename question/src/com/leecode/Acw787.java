package com.leecode;

import java.util.Scanner;

public class Acw787 {
    static int N = 100000;
    static int[] q= new int[N];
    static int[] tmp= new int[N];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = scan.nextInt();
        }
        int l = 0;
        int r = n-1;
        merge_sort(q,l,r);
        for (int i = 0; i < n; i++) {
            System.out.print(q[i]+" ");
        }
    }

    public static void merge_sort(int[] q, int l, int r){
        if(l>=r)return;
        int mid = (l+r)/2;
        merge_sort(q,l,mid);
        merge_sort(q,mid+1,r);
        int i = l,j = mid + 1, k = 0;
        while (i<=mid&&j<=r)
            if(q[i]<=q[j])
                tmp[k++] = q[i++];
            else
                tmp[k++] = q[j++];
        while (i<=mid) tmp[k++] = q[i++];
        while (j<=r) tmp[k++] = q[j++];
        for(i = l,j = 0; i <= r;i++,j++)
            q[i] = tmp[j];

    }
}
