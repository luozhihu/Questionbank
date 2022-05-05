package com.leecode;

import java.util.ArrayDeque;
import java.util.Queue;

public class Test297 {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        String ans = "";
        //如果根节点为空返回""字符串
        if(root == null) return ans;
        //如果根节点不为空，则将根节点入队
        queue.offer(root);
        //进行层序遍历
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            //把节点的值使用“,”号分割
            ans = ans + node.val + ",";
            //如果字节点为空，则用值为1001的节点占位
            if (node.left!=null) queue.offer(node.left);
            else if (node.val != 1001)queue.offer(new TreeNode(1001));
            if (node.right!=null) queue.offer(node.right);
            else if (node.val != 1001)queue.offer(new TreeNode(1001));
        }
        //返回值去除最后一个“,”
        return ans.substring(0,ans.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] strs = data.split(",");
        //如果字符串为""，则返回null
        if(data.length()==0) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        //将根节点入队
        queue.offer(root);
        int n = strs.length;
        //按照层序序列构造数
        for (int i = 1; i < n;) {
            int val1 = Integer.parseInt(strs[i++]);
            int val2 = Integer.parseInt(strs[i++]);
            TreeNode node = queue.poll();
            TreeNode node1;
            TreeNode node2;
            //如果不是是占位符则new一个新的节点
            if (val1!=1001)
                node.left = new TreeNode(val1);
            if (val2!=1001)
                node.right = new TreeNode(val2);

            if (node.left!=null)
                queue.offer(node.left);
            if (node.right!=null)
                queue.offer(node.right);
        }
        return root;
    }
}
