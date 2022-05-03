package com.leecode;

import java.util.*;

public class Test1713 {
//    public int minOperations(int[] target, int[] arr) {
//        Map<Integer,Integer> map = new HashMap<>();
//        int n = target.length,m = arr.length;
//        for (int i = 0; i < n; i++) {
//            map.put(target[i],i);
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            if (map.containsKey(arr[i])){
//                list.add(arr[i]);
//            }
//        }
//        int[] f = new int[m];
//        Arrays.fill(f,Integer.MAX_VALUE);
//        f[0] = 0;
//        int ans = 0;
//        for (int i = 0; i < list.size(); i++) {
//            int a = list.get(i);
//            int idx = map.get(a);
//            int l = 0,r = list.size();
//            while (l<r){
//                int mid = l + r >> 1;
//                if (f[mid]>=idx){
//                    r = mid;
//                }else {
//                    l = mid + 1;
//                }
//            }
//            f[l] = idx;
//            ans = Math.max(ans,l);
//        }
//        return n - ans;
//    }
public int minOperations(int[] target, int[] arr) {
    Map<Integer,Integer> map = new HashMap<>();
    int n = target.length,m = arr.length;
    //使用HashMap来存储target的上升顺序
    for (int i = 0; i < n; i++) {
        map.put(target[i],i);
    }
    int f[] = new int[n];
    Arrays.fill(f,Integer.MAX_VALUE);
    f[0] = 0;
    int len = 1;
    //求最长上升子序列
    for (int i = 0; i < m; i++) {
        int x = arr[i];
        if (map.containsKey(x)){
            int idx = map.get(x);
            int l = 0,r = len;
            while (l<r){
                int mid = l + r + 1 >> 1;
                if(f[mid]<idx){
                    l = mid;
                }else {
                    r = mid - 1;
                }
            }
            f[l+1] = idx;
            len = Math.max(len,l+1);
        }
    }
    return n-len;
}
}
