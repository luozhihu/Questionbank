package com.leecode;

import java.util.*;

public class Test212 {
    Map<Long,String> wordsMap = new HashMap<>();
    int[][] move = {{0,1},{1,0},{-1,0},{0,-1}};
    long P = 1313;
    public List<String> findWords(char[][] board, String[] words) {
        for (String str : words) {
            long h = 0;
            int n = str.length();
            for (int i = 0; i < n; i++) {
                char an = str.charAt(i);
                h = P*h+an - 96;
            }
            wordsMap.put(h,str);
        }
        Set<String> ans = new HashSet<>();
        int[][] flag = new int[14][14];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag[i][j] = 1;
                dfs(board,i,j,1,board[i][j]-96,ans,flag);
                flag[i][j] = 0;
            }
        }
        List<String> anslist = new ArrayList<>(ans);
        return anslist;

    }
    void dfs(char[][] board,int x,int y,int count,long hash,Set<String> ans,int[][] flag){
        if (count>10) return;
        if (wordsMap.containsKey(hash)){
            String str = wordsMap.get(hash);
            if (!ans.contains(str)) ans.add(str);
            System.out.println(str);
        }
        long sh;
        for (int[] mov : move) {
            int i = x + mov[0],j = y + mov[1];
            if (i<board.length&&j<board[0].length&&i>=0&&j>=0&&flag[i][j]==0){
                flag[i][j] = 1;
                char an  =board[i][j];
                sh = hash * P +an - 96;
                dfs(board,i,j,count+1,sh,ans,flag);
            }else {
                continue;
            }
            flag[i][j] = 0;
        }

    }
}
