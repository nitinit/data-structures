package com.problems.geeksforgeeks.trees;

import java.util.Stack;


public class InorderTreeTraversalWithoutRecursion {

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

		inorderTreeTraversalWithoutRecursion(tree1);
		
		
		TreeNode tree2 = new TreeNode(10);
		tree2.right = new TreeNode(20);
		tree2.right.right = new TreeNode(30);
		tree2.right.right.right = new TreeNode(40);
		tree2.right.right.right.right = new TreeNode(50);
		
		
		System.out.println();
		inorderTreeTraversalWithoutRecursion(tree2);
	}

	
	
	public static void inorderTreeTraversalWithoutRecursion(TreeNode root) {

		Stack<TreeNode> stack = new Stack<TreeNode>();
		boolean flag = true;
		TreeNode current = root;
		
		while (flag) {

			while (current.left != null) {
				stack.push(current);
				current = current.left;
			}

			while (current.right == null) {
				System.out.print(current.value + " ");
				if (stack.isEmpty()) {
					flag = false;
					break;
				}
				current = stack.pop();
			}

			if (flag) {
				System.out.print(current.value + " ");
				current = current.right;
			}

		}
		

	}

}