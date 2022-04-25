package com.leecode;

import java.util.*;

public class Test786 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5};
        int k = 3;
        System.out.println(Arrays.toString(kthSmallestPrimeFraction(arr,k)));
    }
    public static int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int n = arr.length;
        //int[] f = new int[n];
        //Arrays.fill(f,n-1);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                double i1 = arr[a[0]] * 1.0 / arr[a[1]], i2 = arr[b[0]] * 1.0 / arr[b[1]];
                return Double.compare(i1, i2);
            }
        });
        for (int i = 0; i < n; i++) {
            queue.offer(new int[] {i,n-1});
        }
        for (int i = 0; i < k-1; i++) {
            int[] an = queue.poll();
            int x = an[0],y = an[1]-1;
            if (x<y){
                queue.offer(new int[] {x,y});
            }
        }
        int[] addr = queue.poll();
        return new int[] {arr[addr[0]],arr[addr[1]]};
    }

}
