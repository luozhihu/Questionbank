package com.leecode;

public class Test430 {
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }
    static Node p = new Node();
    static Node head1 = new Node();
    public static void main(String[] args) {
        head1.val = 1;
        head1.next = new Node();
        head1.next.val = 2;
        flatten(head1);

    }
    public static Node flatten(Node head) {
        Node ans = p;
            linkNode(head);
            return ans.next;
    }
    public static void linkNode(Node head){
        if (head != null) {
            Node value = new Node();
            value.val = head.val;
            p.next = value;
            value.prev = p;
            p = value;
            linkNode(head.child);
            linkNode(head.next);
        }
    }
}
