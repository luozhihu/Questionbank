package com.leecode;

import java.io.*;

public class Test11 {
    public static void main(String[] args) throws IOException{

    }
    public static int maxArea(int[] height) {
        int n = height.length;
        int i = 0,j = n-1;
        int max = 0;
        while (i<j){
            max = Math.max((j-i)*Math.max(height[i],height[j]),max);
            if (height[i]==height[j]){
                j++;
                j++;
            }else if (height[i]<height[j]){
                i++;
            }else {
                j++;
            }
        }
        return max;
    }
}
