package com.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Deque<TreeNode> deque1 = new ArrayDeque<>();
        Deque<TreeNode> deque2 = new ArrayDeque<>();
        deque1.offer(root1);
        deque2.offer(root2);
        while (!deque1.isEmpty()){
            TreeNode treeNode = deque1.pollLast();
            if (treeNode.left!=null){
                deque1.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                deque2.offer(treeNode.right);
            }
            if (treeNode.right==null&&treeNode.left==null){
                list1.add(treeNode.val);
            }
        }
        while (!deque2.isEmpty()){
            TreeNode treeNode = deque2.pollLast();
            if (treeNode.left!=null){
                deque1.offer(treeNode.left);
            }
            if(treeNode.right!=null){
                deque2.offer(treeNode.right);
            }
            if (treeNode.right==null&&treeNode.left==null){
                list2.add(treeNode.val);
            }
        }
        if (list1.size()==list2.size()){
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(1)!=list2.get(i)){
                    return false;
                }
            }
        }
        System.out.println();
        return false;
    }
}
