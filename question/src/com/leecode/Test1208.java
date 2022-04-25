package com.leecode;

public class Test1208 {
    public static void main(String[] args) {

    }
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int[] arrd = new int[n];
        int l =0;
        int count = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            arrd[i] = Math.abs(s.charAt(i) - t.charAt(i));
            count += arrd[i];
            while (count>maxCost){
                count -= arrd[l++];
            }
            ans = Math.max(ans,i-l+1);
        }
        return ans;

    }
}
