package com.leecode;
public class Test995 {
    public static void main(String[] args) {
        int[] nums = {0,1,0};
        System.out.println(minKBitFlips(nums,1));
    }
    public static int minKBitFlips(int[] nums,int k){
        int n = nums.length;
        int[] arr = new int[n+1];
        int ans = 0;
        for (int i = 0, cur = 0; i < n; i++) {
            cur += arr[i];
            if((cur+arr[i]) % 2 == 0){
                if(i+k>n) return -1;
                arr[i+1]++;
                arr[i+k]--;
                ans++;
            }
        }
        return ans;
    }
}
