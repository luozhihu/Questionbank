package com.leecode;

public class Test424 {
    public static void main(String[] args) {
        String s = "aababba";
        int k = 1;
        System.out.println(characterReplacement(s,k));
    }
    public static int characterReplacement(String s, int k) {
        int ans = 0;
        int max = 0;
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] idx = new int[26];
        for (int i = 0,j = 0;j<n;j++){
            int u = chars[j] - 'a';
            idx[u]++;
            max = Math.max(max,idx[u]);
            while (j-i+1-max>k){
                int t = chars[i++] - 'a';
                idx[t]--;
                max = idx[i];
                for (int l = 0; l < 26; l++) {
                    if (idx[l] > max) max = idx[l];
                }
            }
            if (j-i+1-max<=k){
                ans = Math.max(ans,j-i+1);
            }
        }
        return ans;
    }
}
