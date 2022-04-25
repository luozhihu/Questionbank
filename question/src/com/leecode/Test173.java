package com.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test173 {
class TreeNode{
    char val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(char val) { this.val = val; }
    TreeNode(char val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
    Deque<TreeNode> deque = new ArrayDeque<>();
    public void BSTIterator(TreeNode _root) {
        find(_root);

        while (_root!=null||!deque.isEmpty()){
            while (_root!=null){
                deque.offer(_root);
                _root=_root.left;
            }
            TreeNode node = deque.pollLast();
            _root = node.right;
        }
    }
    void find(TreeNode root){
        while (root!=null){
            deque.offer(root);
            root=root.left;
        }
    }
    boolean hasNext(){
        if (!deque.isEmpty()){
            return true;
        }else {
            return false;
        }
    }
    int next(){
        TreeNode node = deque.pollLast();
        if(node.right!=null){
            find(node.right);
        }
        return node.val;
    }
}
