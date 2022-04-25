package com.leecode;

import java.io.*;
import java.util.Arrays;

public class Test16 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] str = reader.readLine().split(",");
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            nums[i] = Integer.parseInt(str[i]);
        }
        int target;
        target = Integer.parseInt(reader.readLine());
        int ans = threeSumClosest(nums,target);
        writer.write(ans+"");
        writer.flush();
        writer.close();
        reader.close();
    }
    public static int threeSumClosest(int[] nums,int target){
        int i,j,k,ans = 10000;
        i = 0;
        j = nums.length-1;
        k = i+1;
        Arrays.sort(nums);
        for (; i < nums.length; i++) {
            if (i>0&&nums[i] == nums[i-1]) continue;
            k = i+1;j = nums.length-1;
            while (k<j){
                if (Math.abs(target-(nums[i]+nums[j]+nums[k]))<Math.abs(ans-target)){
                    ans=nums[i]+nums[j]+nums[k];
                }
                if (target-(nums[i]+nums[j]+nums[k])==0){
                    return ans;
                }else if (target-(nums[i]+nums[j]+nums[k])<0){
                    j--;
                }else {
                    k++;
                }

            }
        }
        return ans;
    }
}
