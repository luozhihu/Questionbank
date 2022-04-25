package com.leecode;

import java.util.Arrays;

public class Test825 {
    public static void main(String[] args) {
        int[] ages = {108,115,5,24,82};
        System.out.println(numFriendRequests(ages));
    }
    public static int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int n = ages.length;
        int ans = 0;
        for (int k = 0; k < n; k++) {
            int j = k;
            while (j+1<n&&ages[j] == ages[j+1])j++;
            int age = ages[j]/2 +7;
            if (age>=ages[j]){

            }else {
                for (int i = 0; i < j; i++) {
                    if (ages[i]>age){
                        ans = ans + j-i;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
