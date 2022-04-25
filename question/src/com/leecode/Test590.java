package com.leecode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test590 {
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
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Object[]> deque = new ArrayDeque<>();
        if (root!=null) deque.offer(new Object[] {1,root});
        while (!deque.isEmpty()){
            Object[] poll = deque.pollLast();
            int loc = (Integer) poll[0];
            Node node = (Node) poll[1];
            List<Node> son = node.children;
            int n = son.size();
            if (loc == 0){
                deque.offer(new Object[] {1,node});
                for (int i = n-1; i >= 0; i--) {
                    deque.offer(new Object[] {0,son.get(i)});
                }
            }else {
                list.add(node.val);
            }
        }
        return list;
    }
}
