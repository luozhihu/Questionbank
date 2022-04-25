package com.leecode;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Acw803 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n;
        n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] str1 = reader.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                arr[i][j] = Integer.parseInt(str1[j]);
            }
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        int[] temp = new int[2];
        temp[0] = arr[0][0];
        temp[1]=arr[0][1];
        for (int i = 1; i < n; i++) {
            if(temp[1] >= arr[i][0]){
                if(temp[1] < arr[i][1]){
                    temp[1] = arr[i][1];
                }
            }else {
                ans.add(temp);
                temp[0] = arr[i][0];
                temp[1] = arr[i][1];
            }
        }
        ans.add(temp);
        System.out.println(ans.size());
    }
}
