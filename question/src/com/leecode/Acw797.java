package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

public class Acw797 {
    public static void main(String[] args) throws IOException{
        //Scanner scan = new Scanner(System.in);
        StreamTokenizer in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        //int n = scan.nextInt(),m = scan.nextInt();
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            in.nextToken();
            arr[i] = (int) in.nval;
        }
        int[] a = new int[n];
        int t = 0;
        for (int i = 0; i < n; i++) {
            a[i] = arr[i] - t;
            t = arr[i];
        }
        for (int i = 0; i < m; i++) {
            int[] act = new int[3];
            for (int j = 0; j < 3; j++) {
                in.nextToken();
                act[j] = (int) in.nval;
            }
            a[act[0] - 1] += act[2];
            if(act[1]<n)
            a[act[1]] -= act[2];
        }
        t = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = a[i] + t;
            t = arr[i];
            System.out.print(arr[i]+" ");
        }
    }
}
