package com.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(candidates,0,target,ans,deque);
        return ans;
    }

    private void dfs(int[] candidates, int i, int target, List<List<Integer>> ans, Deque<Integer> deque) {
        if (target==0){
            ans.add(new ArrayList<>(deque));
            return;
        }
        if (target<0||i==candidates.length){
            return;
        }
        for (int j = 0; j*candidates[i] <= target; j++) {
            for (int k = 0; k < j; k++) {
                deque.addLast(candidates[i]);
            }
            dfs(candidates,i+1,target-j*candidates[i],ans,deque);
            for (int k = 0; k < j; k++) {
                deque.pollLast();
            }
        }
    }

}
