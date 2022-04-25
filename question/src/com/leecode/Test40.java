package com.leecode;

import java.util.*;

public class Test40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
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
        if (i==candidates.length||target<0){
            return;
        }
        int pre = -1;
        for (int j = i; j < candidates.length; j++) {
            if (candidates[j] == pre) continue;
            pre = candidates[j];
            if (candidates[j]>target) break;
            deque.addLast(candidates[j]);
            dfs(candidates,j+1,target-candidates[j],ans,deque);
            deque.pollLast();
        }
    }
}
