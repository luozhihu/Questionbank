package com.leecode;

public class Test1219 {
    int[][] move = {{1,0},{0,1},{-1,0},{0,-1}};
    int[][] flag = new int[15][15];
    int ans = 0;
    public int getMaximumGold(int[][] grid) {
        int m = grid.length,n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]!=0) {
                    flag[i][j] = 1;
                    dfs(grid, i, j, grid[i][j]);
                    flag[i][j] = 0;
                }
            }
        }
        return ans;
    }
    void dfs(int[][] grid,int i,int j,int count){
        if (count>ans){
            ans = count;
        }
        for (int[] mov : move) {
            int x = i + mov[0],y = j + mov[1];
            if (x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]!=0&&flag[x][y]==0){
                flag[x][y] = 1;
                count += grid[x][y];
                dfs(grid,x,y,count);
            }else {
                continue;
            }
            flag[x][y] = 0;
            count -= grid[x][y];
        }
    }
}
