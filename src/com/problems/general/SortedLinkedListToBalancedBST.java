package com.problems.general;

import com.problems.geeksforgeeks.trees.*;
import com.problems.geeksforgeeks.trees.TreeNode;

/**
 * Created by raja on 21/06/15.
 */
public class SortedLinkedListToBalancedBST {

    public static void main(String[] args){
        com.problems.geeksforgeeks.trees.TreeNode ll = new com.problems.geeksforgeeks.trees.TreeNode(1);

        ll.next = new com.problems.geeksforgeeks.trees.TreeNode(2);
        ll.next.next = new com.problems.geeksforgeeks.trees.TreeNode(3);
        ll.next.next.next = new com.problems.geeksforgeeks.trees.TreeNode(4);
        ll.next.next.next.next = new com.problems.geeksforgeeks.trees.TreeNode(5);
        ll.next.next.next.next.next = new com.problems.geeksforgeeks.trees.TreeNode(6);
        ll.next.next.next.next.next.next = new com.problems.geeksforgeeks.trees.TreeNode(7);
//        ll.next.next.next.next.next.next.next = new com.problems.geeksforgeeks.trees.TreeNode(8);

//        InorderTreeTraversalWithoutRecursion.inorderTreeTraversalWithoutRecursion(convert(ll,1,7));
        System.out.println();
        InorderTreeTraversalWithoutRecursion.inorderTreeTraversalWithoutRecursion(convert(ll,7));
    }

    public static com.problems.geeksforgeeks.trees.TreeNode convert(com.problems.geeksforgeeks.trees.TreeNode ll, int start, int end) {

        com.problems.geeksforgeeks.trees.TreeNode root = new com.problems.geeksforgeeks.trees.TreeNode(0);
        if (start==end) {
            int j = 1;
            com.problems.geeksforgeeks.trees.TreeNode ls = ll;
            while (ls.next != null && j < start) {
                j++;
                ls = ls.next;
            }
            root.value=ls.value;
            return root;
        }
        int i = 1;
        com.problems.geeksforgeeks.trees.TreeNode l = ll;
        while (l.next != null && i < start) {
            i++;
            l = l.next;
        }
        int mid = (start + end) / 2;
        while (l.next != null && i < mid) {
            i++;
            l = l.next;
        }
        root.value=l.value;
        root.left = convert(ll, start, mid - 1);
        root.right = convert(ll, mid + 1, end);

        return root;
    }

    public static com.problems.geeksforgeeks.trees.TreeNode convert(com.problems.geeksforgeeks.trees.TreeNode ll, int size) {

        if (size <= 0) {
            return null;
        }

        com.problems.geeksforgeeks.trees.TreeNode left = convert(ll, size / 2);

        com.problems.geeksforgeeks.trees.TreeNode root = new TreeNode(ll.value);
        root.left = left;
        ll = ll.next;

        root.right = convert(ll, size - size / 2 - 1);
        return root;
    }

}
