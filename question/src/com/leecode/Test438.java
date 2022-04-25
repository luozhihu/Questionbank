package com.leecode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test438 {
    public static void main(String[] args) {
        String s = "baa", p = "aa";
        System.out.println(findAnagrams(s,p));
    }

    private static List<Integer> findAnagrams(String s, String p) {
        int m = s.length(),n=p.length();
        int[] idx = new int[26];
        char[] chs = s.toCharArray();
        char[] chp = p.toCharArray();
        for (int i = 0; i < n; i++) {
            int u = chp[i] - 'a';
            idx[u] ++;
        }
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j <= m-n; j+=n) {
                if (check(chs,j,j+n-1,idx)){
                    ans.add(j);
                }
            }
        }
        return ans;
    }

    private static boolean check(char[] chs, int j, int i, int[] idx) {
        int[] count = idx.clone();
        for (int k = j; k <= i; k++) {
            int u = chs[k] - 'a';
            count[u]--;
            if (count[u] == -1) return false;
        }
        return true;
    }


//    public static List<Integer> findAnagrams(String s, String p) {
//        int[] idx = new int[26];
//        char[] chs = s.toCharArray();
//        char[] chp = p.toCharArray();
//        int count = 0;
//        List<Integer> ans = new LinkedList<>();
//        Arrays.fill(idx,0);
//        for (int i = 0; i < s.length()-p.length()+1; i++) {
//            Arrays.fill(idx,0);
//            for (int j = 0; j < p.length(); j++) {
//                int u = chp[j] - 'a';
//                idx[u]++;
//            }
//            for (int j = i; j < p.length()+i; j++) {
//                int u = chs[j] - 'a';
//                if (idx[u] > 0){
//                    count++;
//                    idx[u]--;
//                }else {
//                    break;
//                }
//            }
//            if (count == p.length()){
//                ans.add(i);
//            }
//            count = 0;
//        }
//        return ans;
//    }
}
