package com.leecode;

import java.io.*;

public class Test11 {
    public static void main(String[] args) throws IOException{

    }
//    public static int maxArea(int[] height) {
//        int n = height.length;
//        int i = 0,j = n-1;
//        int max = 0;
//        while (i<j){
//            max = Math.max((j-i)*Math.max(height[i],height[j]),max);
//            if (height[i]==height[j]){
//                j++;
//                j++;
//            }else if (height[i]<height[j]){
//                i++;
//            }else {
//                j++;
//            }
//        }
//        return max;
//    }
    public int maxArea(int[] height) {
        int n = height.length;
        //从两端开始遍历
        int i = 0,j = n - 1;
        int ans = 0;
        //两端相遇，退出循环
        while (i<j){
            //ans取当前最大值
            ans = Math.max(ans,(j-i)*Math.min(height[i],height[j]));
            //根据两端的高度来决定下一步操作
            if (height[i]<height[j]){
                i++;
            }else {
                j--;
            }
        }
        return ans;
    }
}
