package com.problems.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by raja on 11/09/15.
 */
public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode l1 =new ListNode(1);
//        l1.next = new ListNode(5);
//        l1.next.next = new ListNode(12);

        ListNode l2 =new ListNode(10);
//        l2.next = new ListNode(11);
//        l2.next.next = new ListNode(30);

        ListNode l3 =new ListNode(20);
//        l3.next = new ListNode(21);
//        l3.next.next = new ListNode(23);

        ListNode[] lists = new ListNode[3];
        lists[0]=null;
        lists[1]=null;
        lists[2]=null;

//        ListNode sol =  mergeKLists(new ListNode[]{});
        ListNode sol =  mergeKLists(lists);

        System.out.println(sol);
        while(sol!=null){
            System.out.println(sol.val);
            sol = sol.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if(lists.length==0){
            return null;
        }

        PriorityQueue<PriorityQueueNode> q = new PriorityQueue<PriorityQueueNode>(lists.length,new PriorityQueueNode());
        for (int i = 0;i<lists.length;i++){
            if(lists[i]!=null){
                PriorityQueueNode p = new PriorityQueueNode(lists[i].val,i);
                p.next=lists[i].next;
                q.add(p);
            }
        }

        if(q.size()==0){
            return null;
        }
        PriorityQueueNode node = q.remove();
        ListNode finalList = new ListNode(node.i);
        ListNode finalList1 = finalList;
        if(node.next!=null){
            PriorityQueueNode p = new PriorityQueueNode(node.next.val,node.index);
            p.next=node.next.next;
            q.add(p);

        }
        while(q.size()!=0){
            PriorityQueueNode node1 = q.remove();
            finalList.next = new ListNode(node1.i);
            if(node1.next!=null){
                PriorityQueueNode p1 = new PriorityQueueNode(node1.next.val,node1.index);
                p1.next=node1.next.next;
                q.add(p1);
            }
            finalList = finalList.next;
        }
        return finalList1;
    }


    static class PriorityQueueNode implements Comparator {
        public Integer i;
        public ListNode next;
        public int index;
        PriorityQueueNode(int i, int index){
            this.i=i;
            this.index=index;
        }

        PriorityQueueNode(){

        }


        @Override
        public int compare(Object o1, Object o2) {
            PriorityQueueNode obj1 = (PriorityQueueNode) o1;
            PriorityQueueNode obj2 = (PriorityQueueNode) o2;

            return obj1.i.compareTo(obj2.i);
        }
    }
}
