package com.problems.leetcode;

/**
 * Created by raja on 09/08/15.
 */
public class MergeTwoSortedLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);
        ListNode merged = mergeTwoLists(l1,l2);
        while(merged!=null){
            System.out.println(merged.val);
            merged = merged.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;

        if(l1==null || l2==null){
            return l1==null ? l2 : l1;
        }
        ListNode start = null;
        if(l1.val<l2.val){
            head = l1;
            l1 =l1.next;
        }else{
            head = l2;
            l2 =l2.next;
        }
        start=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                head.next = l1;
                l1 =l1.next;
                head =head.next;
            }else{
                head.next = l2;
                l2 =l2.next;
                head =head.next;
            }
        }

        if(l1==null){
            head.next=l2;
        }
        if(l2==null){
            head.next=l1;
        }

        return start;

    }
}
