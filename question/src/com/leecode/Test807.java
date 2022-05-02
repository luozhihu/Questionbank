package com.leecode;

public class Test807 {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[50];
        int[] arr = new int[50];
        //遍历整个二维数组，记录当前行列的最大值
        for(int i = 0;i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(grid[i][j] > row[i]) row[i] = grid[i][j];
                if(grid[i][j] > arr[j]) arr[j] = grid[i][j];
            }
        }
        int ans = 0;
        //遍历整个二维数组，在不超过最大行列值的情况下增加高度
        for(int i = 0;i < grid.length; i++){
            for(int j = 0;j < grid[0].length; j++){
                if(grid[i][j] < row[i] && grid[i][j] < arr[j]) ans += Math.min(row[i],arr[j]) - grid[i][j];
            }
        }
        return ans;
    }
}
