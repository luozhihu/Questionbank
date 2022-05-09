package com.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test37 {
//    Map<Integer,Set<Integer>> xmap = new HashMap<>();
//    Map<Integer,Set<Integer>> ymap = new HashMap<>();
//    Map<Integer,Set<Integer>> xymap = new HashMap<>();
//    public void solveSudoku(char[][] board) {
//        int m = board.length,n = board[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                if (board[i][j]!='.'){
//
//                    Set<Integer> xset = xmap.getOrDefault(i,new HashSet<>());
//                    Set<Integer> yset = ymap.getOrDefault(j,new HashSet<>());
//                    int idx = (i/3)*3+j/3;
//                    Set<Integer> xyset = xymap.getOrDefault(idx,new HashSet<>());
//                    char cur = board[i][j];
//                    xset.add(cur-'0');
//                    yset.add(cur-'0');
//                    xyset.add(cur-'0');
//                    xmap.put(i,xset);
//                    ymap.put(j,yset);
//                    xymap.put(idx,xyset);
//                }
//            }
//        }
//        dfs(board,0,0);
//    }
//    boolean dfs(char[][] board,int i,int j){
//        if (j==9) {
//            return dfs(board,i+1,0);
//        }
//        if (i==9) return true;
//        if (board[i][j] != '.')
//        {
//            return dfs(board,i,j+1);
//        }
//        Set<Integer> xset = xmap.getOrDefault(i,new HashSet<>());
//        Set<Integer> yset = ymap.getOrDefault(j,new HashSet<>());
//        int idx = (i/3)*3+j/3;
//        Set<Integer> xyset = xymap.getOrDefault(idx,new HashSet<>());
//        for (int k = 1; k <= 9; k++) {
//            if (xset.contains(k)) continue;
//            if (yset.contains(k)) continue;
//            if (xyset.contains(k)) continue;
//            board[i][j] = Integer.toString(k).charAt(0);
//            xset.add(k);
//            yset.add(k);
//            xyset.add(k);
//            if(dfs(board,i,j+1)){
//                break;
//            }
//            xset.remove(k);
//            yset.remove(k);
//            xyset.remove(k);
//            //board[i][j] = '.';
//        }
//        return board[i][j] != '.';
//    }

    //每行的数都有一个集合
    Map<Integer,Set<Integer>> xmap = new HashMap<>();
    //每列的数都有一个集合
    Map<Integer,Set<Integer>> ymap = new HashMap<>();
    //每3*3区域的数都有一个集合
    Map<Integer,Set<Integer>> xymap = new HashMap<>();
    public void solveSudoku(char[][] board) {
        //把初始的数放入到集合中
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch=='.') continue;
                //分别计算行、列和区域坐标
                int xidx = i;
                int yidx = j;
                int xyidx = (i/3)*3+j/3;
                //获得当前坐标下的集合，如果没有则创建一个
                Set xset = xmap.getOrDefault(xidx,new HashSet<>());
                Set yset = ymap.getOrDefault(yidx,new HashSet<>());
                Set xyset = xymap.getOrDefault(xyidx,new HashSet<>());
                xset.add(ch-'0');
                yset.add(ch-'0');
                xyset.add(ch-'0');
                //将创建的集合放到map中
                xmap.put(xidx,xset);
                ymap.put(yidx,yset);
                xymap.put(xyidx,xyset);
            }
        }
        dfs(board,0,0);
    }
    boolean dfs(char[][] board,int i,int j){
        //如果超过了当前列，则进入下一行
        if(j==9) return dfs(board,i+1,0);
        //超过了当前行，则返回true
        if (i==9) return true;
        //如果当前位置有原始的数字，则直接进入下一列
        if (board[i][j] != '.') return dfs(board,i,j+1);
        int xidx = i;
        int yidx = j;
        int xyidx = (i/3)*3+j/3;
        Set xset = xmap.getOrDefault(xidx,new HashSet<>());
        Set yset = ymap.getOrDefault(yidx,new HashSet<>());
        Set xyset = xymap.getOrDefault(xyidx,new HashSet<>());
        for (int k = 1; k <= 9; k++) {
            //如果行、列或者区域包含当前数字，则跳过该数
            if (xset.contains(k)|| yset.contains(k)||xyset.contains(k)) continue;
            board[i][j] = (char)('0'+k);
            xset.add(k);
            yset.add(k);
            xyset.add(k);
            //如果返回值为true，那么找到了解不需要递归了
            if (dfs(board,i,j+1)) break;
            else{
                //如果返回值为false，则继续寻找解
                xset.remove(k);
                yset.remove(k);
                xyset.remove(k);
                board[i][j] = '.';
            }
        }
        //如果前面的递归值填错了，那么这里会返回false
        return board[i][j] != '.';
    }
}
