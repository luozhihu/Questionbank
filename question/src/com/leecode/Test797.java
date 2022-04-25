package com.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        dfs(graph,0,n-1,ans,deque);
        return ans;
    }
    void dfs(int[][] graph,int i,int t, List<List<Integer>> ans,Deque<Integer> deque){
        if (i == t){
            ans.add(new ArrayList<>(deque));
            return;
        }
        for (int j = 0; j < graph[i].length; j++){
            int point = graph[i][j];
            deque.addLast(point);
            dfs(graph,point,t,ans,deque);
            deque.pollLast();
        }
    }
}
