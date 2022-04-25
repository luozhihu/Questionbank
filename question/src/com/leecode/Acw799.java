package com.leecode;

import java.io.*;

public class Acw799 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int[] temp = new int[100010];
        String[] str1 = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(str1[i]);
        }
        int max = 0;
        for (int i = 0,j = 0; i < n; i++) {
            temp[arr[i]]++;
            while (temp[arr[i]]>1){
                temp[arr[j]]--;
                j++;
            }
            if(i - j + 1> max){
                max = i - j + 1;
            }
        }
        System.out.println(max);
    }
}
