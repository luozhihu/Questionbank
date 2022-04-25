package com.leecode;

import java.util.ArrayList;
import java.util.List;

public class Text725 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {

    }
    public ListNode[] splitListToParts(ListNode head, int k) {
        int count = 0;
        ListNode p = head;
        while (p != null){
            count++;
            p = p.next;
        }
        int num = count % k;
        int v = count / k;
        p = head;
        ListNode pro;
        ListNode pre = head;
        ListNode[] ansList = new ListNode[k];
        int ansi = 0;
        while (k -- > 0){
            if(num -- > 0){
                for (int i = 0; i < v; i++) {
                    pre = pre.next;
                }
                pro = pre.next;
                pre.next = null;
                ansList[ansi] = p;
                p = pro;
                pre = pro;
            }else {
                for (int i = 0; i < v - 1; i++) {
                    pre = pre.next;
                }
                if(pre == null){
                    ansList[ansi] = p;
            }else{
                pro = pre.next;
                pre.next = null;
                ansList[ansi] = p;
                p = pro;
                pre = pro;
            }
            }
            ansi++;
        }
        return ansList;
    }
}
