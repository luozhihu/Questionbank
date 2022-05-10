package com.leecode;

import java.util.Arrays;

public class Test211 {
    int[][] tree = new int[250000][26];
    int idx = 0;
    boolean[] isWord = new boolean[250000];
    public Test211() {
        for (int i = 0; i < idx; i++) {
            Arrays.fill(tree[i], 0);
        }
        Arrays.fill(isWord, false);
        idx = 0;
    }
    public void addWord(String s) {
        char[] chars = s.toCharArray();
        int p = 0;
        for (int i = 0; i < chars.length; i++) {
            int ch = chars[i] - 'a';
            if(tree[p][ch] == 0) tree[p][ch] = ++idx;
            p = tree[p][ch];
        }
        isWord[p] = true;
    }
    public boolean search(String s) {
        return dfs(s,0,0);
    }
    public boolean dfs(String s,int u,int p){
        if (s.length() == u) return isWord[p];
        char[] chars = s.toCharArray();
        int ch = chars[u] - 'a';
        if(chars[u] != '.'){
            if (tree[p][ch] == 0) return false;
            else return dfs(s,u+1,tree[p][ch]);
        }else {
            for (int j = 0; j < 26; j++) {
                if (tree[p][j] == 0) continue;
                if (dfs(s,u+1,tree[p][j])) return true;
            }
            return false;
        }
    }
}
