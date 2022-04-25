package com.leecode;

import java.util.HashMap;
import java.util.Map;

public class Test992 {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(nums,2));
    }
    public static int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int[] lower = new int[n],upper = new int[n];
        find(lower,nums,k);
        find(upper,nums,k-1);
        int ans = 0;
        for (int i = 0;i < n;i++) ans += upper[i] - lower[i];
        return ans;
    }
    public static void find(int[] arr, int[] num,int k){
        int n = num.length;
        int[] cnt = new int[n+1];
        for (int i = 0,j = 0,sum = 0;i < n;i++){
            int right = num[i];
            if (cnt[right]==0) sum++;
            cnt[right]++;
            while (sum > k){
                int left = num[j++];
                cnt[left]--;
                if (cnt[left] == 0) sum--;
            }
            arr[i] = j;
        }
    }
}
