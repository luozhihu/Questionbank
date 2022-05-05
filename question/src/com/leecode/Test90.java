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
        //每遍历到一个节点都是答案
        ans.add(new ArrayList<>(deque));
        //重复值跳过
        int pre = 100000;
        //遍历坐标i后的每个值
        while (i<nums.length){
            //重复值跳过
            if (nums[i] != pre) {
                pre = nums[i];
                deque.addLast(nums[i]);
                dfs(nums, i + 1, ans, deque);
                deque.pollLast();
            }
            i++;
        }
    }
}
