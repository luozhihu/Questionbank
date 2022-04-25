package com.leecode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test36 {
    public static void main(String[] args) {
        char[][] board = new char[][]{};

    }
    public  static boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Integer>> row = new HashMap<>(), col = new HashMap<>(), area = new HashMap<>();
        for(int i = 0; i < 9; i++){
            row.put(i,new HashSet<>());
            col.put(i,new HashSet<>());
            area.put(i,new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c == '.') continue;
                int u = c-'0';
                int idx = i/3*3 + j /3;
                if (row.get(i).contains(u) || col.get(j).contains(u) || area.get(idx).contains(u)) return false;
                row.get(i).add(u);
                col.get(j).add(u);
                area.get(idx).add(u);
            }
        }
        return true;
    }
}
