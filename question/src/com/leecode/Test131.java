package com.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test131 {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> ans = new ArrayList<>();
        Deque<String> an = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            dfs(s,n,0,i,ans,an);
        }
        return ans;
    }
    void dfs(String str,int n, int idx, int i, List<List<String>> ans, Deque<String> an){
        if (i==0&&idx==n){
            ans.add(new ArrayList<>(an));
            return;
        }
        if (i==0||idx==n) return;
        for (int j = 1; j+idx <= n; j++) {
            String sub = str.substring(idx,idx+j);
            if (check(sub)){
                an.addLast(sub);
            }else {
                continue;
            }
            dfs(str,n,idx+j,i-1,ans,an);
            an.pollLast();
        }
    }

    private boolean check(String sub) {
        int i = 0,j = sub.length()-1;
        while (i<j){
            if (sub.charAt(i) != sub.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }
}
