package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class BalancedStringSplit {
    public static int k = 0;
    public static void main(String[] args) {

        TreeNode rootl = new TreeNode(2);
        TreeNode rootr = new TreeNode(3);
        TreeNode root = new TreeNode(1,rootl,rootr);
        int[] voyage = new int[3];
        voyage[0]=1;
        voyage[1]=3;
        voyage[2]=2;
        System.out.println(flipMatchVoyage(root,voyage));

    }
    public static List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        if(dfs(root,voyage,ans)) return ans;
        else {
            ans.clear();
            ans.add(-1);
            return ans;
        }
    }
    public static boolean dfs(TreeNode root, int[] voyage,List<Integer> ans){
        if(root == null){
            return true;
        }
        if(root.val != voyage[k])
        {
            return false;
        }
        k++;
        if(root.left != null && root.left.val != voyage[k]){
            ans.add(root.val);
            return dfs(root.right,voyage,ans) && dfs(root.left,voyage,ans);
        } else {
            return dfs(root.left,voyage,ans) && dfs(root.right,voyage,ans);
        }
    }
}
