package com.leecode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Test1609 {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> que = new ArrayDeque<>();
        que.add(root);
        TreeNode pre = root;
        int high = 0;
        int preval = -1000000;
        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node.left!=null){
                que.add(node.left);
            }
            if(node.right!=null){
                que.add(node.right);
            }
            if(high%2==0){
                if(node.val<=preval||node.val%2==0) return false;
            }else{
                if(node.val>=preval||node.val%2==1) return false;
            }
            preval = node.val;
            if(node == pre && !que.isEmpty()) {
                pre = que.getLast();
                high++;
                if(high%2==0) preval = -1000000;
                else preval = 1000000;
            }
        }
        return true;

    }
}
