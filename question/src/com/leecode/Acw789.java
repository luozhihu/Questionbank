package com.leecode;

import java.util.Scanner;

public class Acw789 {
static int N = 100000;
static int n,m;
static int[] q= new int[N];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            q[i] = scan.nextInt();
        }
        while (m-->0){

            int x=scan.nextInt();
            int l = 0,r = n-1;
            while (l<r){
                int mid = (l+r)/2;
                if(q[mid]>=x) r= mid;
                else l = mid + 1;
            }
            if(q[l] != x) System.out.println("-1 -1");
            else {
                System.out.print(l+" ");
                l = 0; r = n - 1;
                while (l<r){
                    int mid = (l + r + 1)/2;
                    if(q[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(l);
            }

        }

    }
}
