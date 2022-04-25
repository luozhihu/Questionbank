package com.leecode;

import java.util.*;

public class Test589 {
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
    }
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> deque = new ArrayDeque<>();
        if (root!=null) deque.offer(root);
        while (!deque.isEmpty()){
            Node node = deque.pollLast();
            list.add(node.val);
            List<Node> son = node.children;
            int n = son.size();
            for (int i = n-1; i >= 0; i--) {
                deque.offer(son.get(i));
            }
        }
        return list;
    }
}
