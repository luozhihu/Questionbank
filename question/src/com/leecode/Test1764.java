package com.leecode;

public class Test1764 {
    public static void main(String[] args) {
        int[][] groups = {{1,-1,-1},{3,-2,0}};
        int[] nums = {1,-1,0,1,-1,-1,3,-2,0};
        System.out.println(canChoose(groups,nums));

    }
    public static boolean canChoose(int[][] groups, int[] nums) {
        int n = nums.length;
        int m = groups.length;
        int k = 0;
        for (int i = 0; i < m; i++) {
            int l = k;
            for (int j = 0; j < groups[i].length; j++) {
                if (k>=n){
                    return false;
                }
                    if (k<n&&nums[k] == groups[i][j]) {
                        k++;
                    }else {
                    l++;
                        k = l;
                        j=-1;
                    }
            }
        }
        return true;
    }
}
