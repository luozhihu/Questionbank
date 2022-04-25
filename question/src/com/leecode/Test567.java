package com.leecode;

public class Test567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidboaoo";
        System.out.println(checkInclusion(s1,s2));
    }
    public static boolean checkInclusion(String s1, String s2) {
        int[] idx = new int[26];
        int m = s1.length(),n = s2.length();
        for (int i = 0; i < m; i++) {
            idx[s1.charAt(i) - 'a']++;
        }
        int[] idx2 = new int[26];
        for (int i = 0; i < n; i++) {
            if (i<m){
                idx2[s2.charAt(i) - 'a']++;
            }else {
                if (check(idx,idx2)){
                    return true;
                }
                idx2[s2.charAt(i) - 'a']++;
                idx2[s2.charAt(i-m) - 'a']--;
            }
        }
        if (check(idx,idx2)){
            return true;
        }
        return false;
    }
    public static boolean check(int[] idx,int[] idx2){
        for (int i = 0; i < 26; i++) {
            if (idx[i] != idx2[i])
                return false;
        }
        return true;
    }
}
