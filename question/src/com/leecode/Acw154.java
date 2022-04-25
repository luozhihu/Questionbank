package com.leecode;

import java.io.*;

public class Acw154 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = 1000010;
        int[] arr = new int[N], q = new int[N];
        int n,k;
        String[] str = reader.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);
        str = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str[i]);
        }
        int hh = 0,tt = -1;
        for (int i = 0; i < n; i++) {
            if(hh <= tt && q[hh] < i - k + 1) hh++;
            while (hh <= tt && arr[q[tt]] >= arr[i]) tt--;
            q[++tt] = i;
            if(i >= k - 1) //System.out.print(arr[q[hh]]+" ");
                writer.write(arr[q[hh]] + " ");
        }
        writer.write("\n");
        hh = 0;tt = -1;
        for (int i = 0; i < n; i++) {
            if(hh <= tt && q[hh] < i - k + 1) hh++;
            while (hh <= tt && arr[q[tt]] <= arr[i]) tt--;
            q[++tt] = i;
            if(i >= k - 1) //System.out.print(arr[q[hh]]+" ");
            writer.write(arr[q[hh]]+" ");
        }
        writer.flush();
        reader.close();
        writer.close();
    }
}
