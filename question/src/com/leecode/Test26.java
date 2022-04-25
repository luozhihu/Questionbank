package com.leecode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test26 {
    public static int[] nums = new int[100000];
    public static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] str = reader.readLine().split(" ");
        n = str.length;
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int answer = removeDuplicates(nums);
        System.out.println(answer);
    }
    public static int removeDuplicates(int[] nums) {
        int i = 0,k = 0;
        for (int j = i+1; j < n; j++) {
            if (nums[i] == nums[j]){
                k++;
                continue;
            }
            nums[j-k] = nums[j];
            i=j;
        }
        return n-k;
    }
}
