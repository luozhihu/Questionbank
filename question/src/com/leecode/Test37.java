package com.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test37 {
    Map<Integer,Set<Integer>> xmap = new HashMap<>();
    Map<Integer,Set<Integer>> ymap = new HashMap<>();
    Map<Integer,Set<Integer>> xymap = new HashMap<>();
    public void solveSudoku(char[][] board) {
        int m = board.length,n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]!='.'){

                    Set<Integer> xset = xmap.getOrDefault(i,new HashSet<>());
                    Set<Integer> yset = ymap.getOrDefault(j,new HashSet<>());
                    int idx = (i/3)*3+j/3;
                    Set<Integer> xyset = xymap.getOrDefault(idx,new HashSet<>());
                    char cur = board[i][j];
                    xset.add(cur-'0');
                    yset.add(cur-'0');
                    xyset.add(cur-'0');
                    xmap.put(i,xset);
                    ymap.put(j,yset);
                    xymap.put(idx,xyset);
                }
            }
        }
        dfs(board,0,0);
    }
    boolean dfs(char[][] board,int i,int j){
        if (j==9) {
            return dfs(board,i+1,0);
        }
        if (i==9) return true;
        if (board[i][j] != '.')
        {
            return dfs(board,i,j+1);
        }
        Set<Integer> xset = xmap.getOrDefault(i,new HashSet<>());
        Set<Integer> yset = ymap.getOrDefault(j,new HashSet<>());
        int idx = (i/3)*3+j/3;
        Set<Integer> xyset = xymap.getOrDefault(idx,new HashSet<>());
        for (int k = 1; k <= 9; k++) {
            if (xset.contains(k)) continue;
            if (yset.contains(k)) continue;
            if (xyset.contains(k)) continue;
            board[i][j] = Integer.toString(k).charAt(0);
            xset.add(k);
            yset.add(k);
            xyset.add(k);
            if(dfs(board,i,j+1)){
                break;
            }
            xset.remove(k);
            yset.remove(k);
            xyset.remove(k);
            //board[i][j] = '.';
        }
        return board[i][j] != '.';
    }
}
