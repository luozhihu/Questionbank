package com.leecode;

public class Test911 {
    int[] f = new int[5010];
    int[] time = new int[5010];
    int[] ti;
    public Test911(int[] persons, int[] times) {
        int n = persons.length,m = times.length;
        int max = 0;
        ti =times;
        for (int i = 0; i < m; i++) {
            int pers = persons[i];
            f[pers]++;
            if (f[pers]>=max){
                max = f[pers];
                time[i] = pers;
            }else {
                time[i] = time[i-1];
            }
        }
    }
    int q(int t) {
        int l = 0,r = ti.length-1;
        while (l<r){
            int mid = l + r + 1 >> 1;
            if (ti[mid]<=t){
                l = mid;
            }else {
                r = mid - 1;
            }
        }
        return time[l];
    }
}
