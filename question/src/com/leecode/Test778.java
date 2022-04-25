package com.leecode;

import java.util.LinkedList;
import java.util.Queue;

public class Test778 {
    public static void main(String[] args) {
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(swimInWater(grid));
    }
    static int[][] dirs = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    public static int swimInWater(int[][] grid) {
//        int n = grid.length, m = grid[0].length;
//        int[][] flag = new int[n][m];
//        Queue<int[]> queue = new LinkedList<>();
        int l = 0,r = 2500;
        while (l<r){
            int mid = l + r >> 1;
            if (check(grid,mid)){
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        return l;
    }
    static boolean check(int[][] grid,int t){
        int n = grid.length, m = grid[0].length;
        int[][] flag = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        if (grid[0][0]<=t){
            queue.offer(new int[] {0,0});
            flag[0][0] = 1;
        }
        while (!queue.isEmpty()){
            int[] address = queue.poll();
            int x = address[0],y = address[1];
            if (x==n-1&&y==m-1) return true;
//            if (x+1<n&&grid[x+1][y]<=t&&flag[x+1][y]==0){
//                queue.offer(new int[] {x+1,y});
//                flag[x+1][y] = 1;
//            }
//            if (x-1>=0&&grid[x-1][y]<=t&&flag[x-1][y]==0){
//                queue.offer(new int[] {x-1,y});
//                flag[x-1][y] = 1;
//            }
//            if (y+1<n&&grid[x][y+1]<=t&&flag[x][y+1]==0){
//                queue.offer(new int[] {x,y+1});
//                flag[x][y+1] = 1;
//            }
//            if (y-1>=0&&grid[x][y-1]<=t&&flag[x][y-1]==0){
//                queue.offer(new int[] {x,y-1});
//                flag[x][y-1] = 1;
//            }
            for (int[] dir : dirs) {
                int x1 = x+dir[0],y1 = y + dir[1];
                if (x1>=0&&x1<n&&y1>=0&&y1<m&&grid[x1][y1]<=t&&flag[x1][y1]==0){
                    queue.offer(new int[] {x1,y1});
                    flag[x1][y1] = 1;
                }
            }
        }
        return false;
    }
}
