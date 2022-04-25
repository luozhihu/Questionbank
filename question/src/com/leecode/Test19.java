package com.leecode;

public class Test19 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head, pre = head;
        for (int i = 0; i < n; i++) {
            p = p.next;
        }
        while (p.next != null){
            pre = pre.next;
            p = p.next;
        }
        pre.next = pre.next.next;
        return head;
    }
}
