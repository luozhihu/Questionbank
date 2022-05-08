package com.leecode;

import java.util.*;

public class Test429 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Node> queue = new ArrayDeque<>();
        if(root == null) return ans;
        queue.add(root);
        Node flag;
        flag = root;
        List<Integer> an = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            an.add(node.val);
            for (Node one : node.children) {
                queue.offer(one);
            }
            if (node == flag) {
                if(!queue.isEmpty())
                    flag = queue.getLast();
                ans.add(an);
                an = new ArrayList<>();
            }
        }
        return ans;
    }
}
