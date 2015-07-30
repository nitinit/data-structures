package com.problems.general;

import com.problems.geeksforgeeks.trees.*;
import com.problems.geeksforgeeks.trees.TreeNode;

/**
 * Created by raja on 30/06/15.
 */
public class DeleteNodeIfGreaterThanPreviousInLinkedList {

    public static int max = 0;
    public static void main(String [] args){
        com.problems.geeksforgeeks.trees.TreeNode ll = new TreeNode(10);
        ll.next = new TreeNode(30);
        ll.next.next = new TreeNode(9);
        ll.next.next.next = new TreeNode(8);
        ll.next.next.next.next = new TreeNode(20);
        ll.next.next.next.next.next = new TreeNode(16);
        ll.next.next.next.next.next.next = new TreeNode(2);
        TreeNode head = ll;

//        TreeNode result =  delete(ll);
//        while(ll!=null){
//            System.out.print(ll.value + " ");
//            ll=ll.next;
//        }
//        System.out.println();
//
//        while(result!=null){
//            System.out.print(result.value + " ");
//            result=result.next;
//        }

        TreeNode result =  deleteLesserNodes(head);

        while(result!=null){
            System.out.print(result.value + " ");
            result=result.next;
        }
    }

    public static TreeNode delete(TreeNode head){
        if(head.next==null){
            max=head.value;
            return new TreeNode(head.value);
        }

        TreeNode node = delete(head.next);
        if(max<head.value){
            TreeNode result = new TreeNode(head.value);
            max = head.value;
            result.next = node;
            return result;
        }
        return node;
    }

    public static TreeNode  deleteLesserNodes(TreeNode node) {
        if (node == null) return null;

        TreeNode next = deleteLesserNodes(node.next);
        node.next = next;

        if (next != null && node.value < next.value) {
            return next;
        } else {
            return node;
        }
    }

}
