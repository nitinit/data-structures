package com.problems.leetcode;

/**
 * Created by raja on 13/09/15.
 */
public class SwapKNodes {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(5);
        l1.next.next = new ListNode(12);
//        l1.next.next.next = new ListNode(15);
//        l1.next.next.next.next = new ListNode(20);
//        l1.next.next.next.next.next = new ListNode(25);
//        l1.next.next.next.next.next.next = new ListNode(27);

        ListNode head = null;
        ListNode h = l1;
        int size=0;
        while (h != null) {
            h = h.next;
            size++;
        }
        h= swapNodes(l1, 2,size );

        while (h != null) {
            System.out.println(h.val);
            h = h.next;
        }
    }

    public static ListNode swapNodes(ListNode head, int k, int size) {

        ListNode current = head;
        ListNode next = null;
        ListNode prev = null;
        int count = 0;


        size = size -k;
        while (current != null && count < k && size>=0) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        if (next != null) {
            head.next = swapNodes(next, k,size);
        }

        return prev==null ? head : prev;
    }

    public static ListNode reverse(ListNode curr, ListNode prev, ListNode head) {

        if (curr.next == null) {
            curr.next = prev;
            return curr;
        }
        ListNode next = curr.next;
        curr.next = prev;
        return reverse(next, curr, head);

    }
}
