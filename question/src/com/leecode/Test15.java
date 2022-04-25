package com.leecode;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test15 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        List<List<Integer>> ans = threeSum(nums);
        writer.write(ans+"");
        writer.flush();
        writer.close();
        reader.close();
    }
    public static List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;
        int i = 0 , j = n - 1;
        int k = 0;
        int sum = 0;
        List<List<Integer>> ans = new LinkedList<>();
        for (;i<n;i++){
            if (nums[i]>0) break;
            if (i>0&&nums[i-1] == nums[i]) continue;
            k=i+1;
            j=n-1;
            while (k<j){
                while (k>i+1&&nums[k-1] == nums[k]) k++;
                sum = nums[i] + nums[j] + nums[k];
                if (sum == 0){
                    List<Integer> list = new LinkedList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    ans.add(list);
                    k++;
                }else if (sum<0){
                    j--;
                }else {
                    k++;
                }
            }
        }
        return ans;
    }
}
