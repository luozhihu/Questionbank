package com.leecode;
import java.util.Arrays;
import java.util.Comparator;

public class Test354 {
    public static void main(String[] args) {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(maxEnvelopes(envelopes));
    }
    public static int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int ans = 1;
        int n = envelopes.length;
        //f[i]是以i结尾的最大信封len
        int[] f = new int[n];
        //g[i]是以len为i的最小信封高度
        int[] g = new int[n+1];
        Arrays.fill(g,Integer.MAX_VALUE);
        for (int i = 0,j = 0,len = 1;i<n;i++){
            if (envelopes[i][0]!=envelopes[j][0]){
                while (j<i){
                    int pre = f[j], cur = envelopes[j][1];
                    if (pre == len){
                        g[len++] = cur;
                    }else {
                        g[pre] = Math.min(g[pre],cur);
                    }
                    j++;
                }
            }
            int l = 1,r = n;
            while (l<r){
                int mid = l + r >> 1;
                if (g[mid]>=envelopes[i][1]){
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
            f[i] = l;
            ans = Math.max(ans,f[i]);
        }
        return ans;
    }
}
