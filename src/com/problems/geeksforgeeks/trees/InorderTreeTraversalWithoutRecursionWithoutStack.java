package com.problems.geeksforgeeks.trees;

import java.util.Stack;


public class InorderTreeTraversalWithoutRecursionWithoutStack {

	public static void main(String[] args) {
		//    		  50
		// 		 7   	    	2
		//	  3     2		10		30
		//		1					40
		
		TreeNode tree1 = new TreeNode(50);
		tree1.left = new TreeNode(7);
		tree1.right = new TreeNode(2);
		
		tree1.right.left = new TreeNode(10);
		tree1.right.right = new TreeNode(30);
		tree1.right.right.right = new TreeNode(40);
		
		tree1.left.left = new TreeNode(3);
		tree1.left.left.right = new TreeNode(1);
		tree1.left.right = new TreeNode(2);

		
		
		TreeNode tree2 = new TreeNode(10);
		tree2.right = new TreeNode(20);
		tree2.right.right = new TreeNode(30);
		tree2.right.right.right = new TreeNode(40);
		tree2.right.right.right.right = new TreeNode(50);
		
		inorderTreeTraversalWithoutRecursionWithoutStack(tree2);
		System.out.println();
		inorderTreeTraversalWithoutRecursionWithoutStack(tree1);
	}

	
	
	public static void inorderTreeTraversalWithoutRecursionWithoutStack(TreeNode root) {

		TreeNode current = root;
		TreeNode previous;

		while (current != null) {
			if (current.left == null) {
				System.out.print(current.value + " ");
				current = current.right;
			} else {
				previous = current.left;
				while (previous.right != null && previous.right != current) {
					previous = previous.right;
				}
				if (previous.right == null) {
					previous.right = current;
					current = current.left;
				} else {
					previous.right = null;
					System.out.print(current.value + " ");
					current = current.right;
				}
			}
		}

	}

}