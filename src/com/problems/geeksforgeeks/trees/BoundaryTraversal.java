package com.problems.geeksforgeeks.trees;

/**
 * Created by raja on 17/10/15.
 */
public class BoundaryTraversal {

    public static void main(String[] args) {

        TreeNode bt = new TreeNode(20);
        bt.left = new TreeNode(8);
        bt.right = new TreeNode(22);

//        bt.right.right = new TreeNode(25);
        bt.left.right = new TreeNode(12);
        bt.left.right.left = new TreeNode(10);
        bt.left.right.left.left = new TreeNode(9);
        bt.left.right.right = new TreeNode(14);

        bt.left.left = new TreeNode(4);
        System.out.print(bt.value + " ");
        leftBoundary(bt.left);
        printLeaves(bt);
        rightBoundary(bt.right);

    }


    //print only left part
    public static void leftBoundary(TreeNode root) {

        if (root != null) {

            if (root.left != null) {
                System.out.print(root.value + " ");
                leftBoundary(root.left);
            } else if (root.right != null) {
                System.out.print(root.value + " ");
                leftBoundary(root.right);
            }

        }
    }

    public static void printLeaves(TreeNode root) {

        if (root != null) {

            printLeaves(root.left);

            if (root.right == null && root.left == null) {
                System.out.print(root.value + " ");
            }

            printLeaves(root.right);

        }

    }

    public static void rightBoundary(TreeNode root) {

        if (root != null) {

            if (root.right != null) {
                rightBoundary(root.right);
                System.out.print(root.value + " ");
            } else if (root.left != null) {
                rightBoundary(root.left);
                System.out.print(root.value + " ");
            }

        }

    }
}
