package com.leecode;

import java.util.*;

public class Test40 {
//    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        List<List<Integer>> ans = new ArrayList<>();
//        Deque<Integer> deque = new ArrayDeque<>();
//        dfs(candidates,0,target,ans,deque);
//        return ans;
//    }
//
//    private void dfs(int[] candidates, int i, int target, List<List<Integer>> ans, Deque<Integer> deque) {
//        if (target==0){
//            ans.add(new ArrayList<>(deque));
//            return;
//        }
//        if (i==candidates.length||target<0){
//            return;
//        }
//        int pre = -1;
//        for (int j = i; j < candidates.length; j++) {
//            if (candidates[j] == pre) continue;
//            pre = candidates[j];
//            if (candidates[j]>target) break;
//            deque.addLast(candidates[j]);
//            dfs(candidates,j+1,target-candidates[j],ans,deque);
//            deque.pollLast();
//        }
//    }
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> an = new ArrayList<>();
    dfs(candidates,target,0,ans,an);
    return ans;
}
    void dfs(int[] candidates,int target,int i,List<List<Integer>> ans,List<Integer> an){
        if (target == 0) {
            ans.add(new ArrayList<>(an));
            return;
        }
        int pre = 0;
        for (int j = i; j < candidates.length; j++) {
            if (pre == candidates[j]) continue;
            pre = candidates[j];
            if(target>=candidates[j]) {
                an.add(candidates[j]);
                dfs(candidates,target-candidates[j],j+1,ans,an);
                an.remove(an.size()-1);
            }else break;
        }

    }
}
