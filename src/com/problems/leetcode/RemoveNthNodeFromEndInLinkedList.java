package com.problems.leetcode;

import java.util.List;

/**
 * Created by raja on 09/08/15.
 */
public class RemoveNthNodeFromEndInLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode node = removeNthFromEnd(head, 5);
        while (node != null) {
            System.out.println(node.val);
            node = node.next;

        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node = head;
        ListNode start = head;
        while (count < n) {
            count++;
            node = node.next;
        }
        if (node == null) {
            return head.next;
        }
        while (node.next != null) {
            node = node.next;
            start = start.next;
        }
        start.next = start.next.next;
        return head;
    }
}
