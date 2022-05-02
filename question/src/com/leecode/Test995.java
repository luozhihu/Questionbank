package com.leecode;
public class Test995 {
    public static void main(String[] args) {
        int[] nums = {0,1,1};
        System.out.println(minKBitFlips(nums,2));
    }
    public static int minKBitFlips(int[] nums,int k){
        int n = nums.length;
        int f[] = new int[n+k];
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            cnt += f[i];
            if ((x + cnt) % 2 == 0){
                if (i+k>n) return -1;
                f[i+1]++;
                f[i+k]--;
                ans++;
            }
            //cnt += f[i];
        }
        return ans;
    }
}
