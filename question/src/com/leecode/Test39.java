package com.leecode;

import java.util.*;

public class Test39 {
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
//        if (target<0||i==candidates.length){
//            return;
//        }
//        for (int j = 0; j*candidates[i] <= target; j++) {
//            for (int k = 0; k < j; k++) {
//                deque.addLast(candidates[i]);
//            }
//            dfs(candidates,i+1,target-j*candidates[i],ans,deque);
//            for (int k = 0; k < j; k++) {
//                deque.pollLast();
//            }
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
        for (int j = i; j < candidates.length; j++) {
            if(target>=candidates[j]) {
                an.add(candidates[j]);
                dfs(candidates,target-candidates[j],j,ans,an);
                an.remove(an.size()-1);
            }else break;
        }

    }

}
