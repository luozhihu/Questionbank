package com.leecode;

import java.util.Arrays;

public class Test475 {
    public static void main(String[] args) {
        int[] houses = {1,2,3,4,5,5,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        int[] heater = {1,2,3,4,5,5,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22};
        System.out.println(findRadius(houses,heater));
    }
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        Arrays.sort(houses);
        int n = houses.length, m = heaters.length;
        int d= 0;
        for (int i = 0,j = 0;i<n;i++){
            while (j+1<m&&Math.abs(houses[i]-heaters[j])>=Math.abs(houses[i]-heaters[j+1])){
                j++;
            }
            d = Math.max(d,Math.abs(houses[i]-heaters[j]));
        }
        return d;
    }
}
