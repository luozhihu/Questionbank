package com.leecode;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test18 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int target = Integer.parseInt(reader.readLine());
        List<List<Integer>> ans = fourSum(nums,target);
        writer.write(ans+"");
        writer.flush();
        writer.close();
        reader.close();
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> ans = new LinkedList<>();
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < n; i++) {
            while (i>0&&i<n&&nums[i]==nums[i-1]) i++;
            for (int j = i+1; j < n; j++) {
                while (j>i+1&&j<n&&nums[j]==nums[j-1]) j++;
                int k = j+1;
                int p = n-1;
                while (k<p){
                    while (k<p&&k>j+1&&nums[k]==nums[k-1]) k++;
                    if(k>=p) break;
                    sum = nums[i] + nums[j] + nums[k] + nums[p];
                    if (sum == target){
                        List<Integer> soution = new LinkedList<>();
                        soution.add(nums[i]);
                        soution.add(nums[j]);
                        soution.add(nums[k]);
                        soution.add(nums[p]);
                        ans.add(soution);
                        k++;
                    }else if (sum > target){
                        p--;
                    }else {
                        k++;
                    }
                }
            }
        }
        return ans;
    }
}
