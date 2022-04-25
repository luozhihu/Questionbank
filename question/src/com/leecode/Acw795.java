package com.leecode;

import java.util.Arrays;
import java.util.Scanner;

public class Acw795 {
    public static void main(String[] args) {
        int n,m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        int[] arr = new int[n];
        int[] s = new int[n];
        int t = s[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = scan.nextInt();
        }
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < n; i++) {
            s[i] = t + arr[i];
            t = s[i];
        }
        System.out.println(Arrays.toString(s));
        for (int i = 1; i <= m; i++) {
            int l,r;
            l = scan.nextInt();
            r = scan.nextInt();
            System.out.println(s[r-1]-s[l-1]+arr[l-1]);
        }
    }
}
