package com.leecode;

import java.util.*;

public class Test90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(nums,0,ans,deque);
        return ans;
    }

    private void dfs(int[] nums, int i, List<List<Integer>> ans, Deque<Integer> deque) {
        if (nums.length==i){
            ans.add(new ArrayList<>(deque));
            return;
        }
        deque.addLast(nums[i]);
        dfs(nums,i+1,ans,deque);
        deque.pollLast();
        if (i+1<nums.length&&nums[i+1] != nums[i]) {
            dfs(nums, i + 1, ans, deque);
        }
    }
}
