package com.problems.general;

import com.problems.geeksforgeeks.trees.*;
import com.problems.geeksforgeeks.trees.TreeNode;

/**
 * Created by raja on 23/07/15.
 */
public class LinkedListDownAndNextPointer {


    public static void main(String[] args){
        TreeNode head = new TreeNode(1);
        head.down=new TreeNode(7);
        head.down.next=new TreeNode(8);
        head.down.down=new TreeNode(14);
        head.down.down.next=new TreeNode(15);
        head.down.down.next.down=new TreeNode(20);
        head.down.down.next.down.next=new TreeNode(21);
        head.down.down.next.next=new TreeNode(16);
        head.next=new TreeNode(2);
        head.next.next=new TreeNode(3);
        head.next.next.down=new TreeNode(10);
        head.next.next.down.next=new TreeNode(11);
        head.next.next.next=new TreeNode(4);
        head.next.next.next.next=new TreeNode(5);

        convert(head);

        // 1 -> 7 -> 14 -> 15 -> 20 -> 21 -> 16 -> 8 -> 2 -> 3 -> 10 -> 11 -> 4 ->5
        while(head!=null){
            System.out.print(head.value + " -> ");
            head = head.next;
        }
    }

    // 1 -> 2 -> 3 -> 4 ->5
    // |         |
    // V         V
    // 7 -> 8    10 -> 11
    // |
    // V
    // 14 -> 15 -> 16
    //      |
    //      V
    //      20 -> 21
    public static void convert(com.problems.geeksforgeeks.trees.TreeNode head) {
        if (head == null) {
            return;
        }
        TreeNode tempNext = head.next;
        if (head.down != null) {
            TreeNode tempDown = head.down;
            head.next = tempDown;
            convert(tempDown);
        }

        convert(tempNext);
        if (head.next != null && head.next != tempNext) {
                while (head.next != null) {
                    head = head.next;
                }
                head.next = tempNext;
            }
        }

}
