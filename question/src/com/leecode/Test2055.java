package com.leecode;

import java.util.Arrays;

public class Test2055 {
    public static void main(String[] args) {
        String s = "***|**|*****|**||**|*";
        int[][] q =  {{2,5},{5,9}};
        System.out.println(Arrays.toString(platesBetweenCandles(s,q)));
    }
    public static int[] platesBetweenCandles(String s, int[][] queries) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] lf = new int[n];
        int[] rf = new int[n];
        int count = 0;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '*'){
                count++;
                if (idx == -1){
                    lf[i] = 0;
                }else {
                    lf[i] = lf[idx];
                }
            }
            if (chars[i] == '|') {
                lf[i] = count;
                rf[i] = count;
                for (int j = i; j > idx; j--) {
                    rf[j] = rf[i];
                }
                idx = i;
            }
        }
        for (int i = idx+1; i < n; i++) {
            rf[i] = Integer.MAX_VALUE;
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            int x= queries[i][0],y = queries[i][1];
            int num = lf[y] - rf[x];
            if (num>=0){
                ans[i] = num;
            }else {
                ans[i] = 0;
            }
            ans[i] = num>0?num:0;
        }
        return ans;
    }
}
