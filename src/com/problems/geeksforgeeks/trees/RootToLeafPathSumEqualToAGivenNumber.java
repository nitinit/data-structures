package com.problems.geeksforgeeks.trees;



public class RootToLeafPathSumEqualToAGivenNumber {

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
		
		inorderTreeTraversalWithoutRecursionWithoutStack(tree2,"",150);
		System.out.println();
		inorderTreeTraversalWithoutRecursionWithoutStack(tree1,"",61);
		System.out.println();
		inorderTreeTraversalWithoutRecursionWithoutStack(tree1,"",62);
		System.out.println();
		inorderTreeTraversalWithoutRecursionWithoutStack(tree1,"",122);
		System.out.println();
		
	}

	public static void inorderTreeTraversalWithoutRecursionWithoutStack(TreeNode root, String path, int num) {
		if (root == null) {
			return;
		}
		if (num == root.value && root.left == null && root.right == null) {
			System.out.println(path +" , "+ root.value);
		} else if (num - root.value < 0) {
			return;
		}
		inorderTreeTraversalWithoutRecursionWithoutStack(root.left, path +" , "+ root.value, num - root.value);
		inorderTreeTraversalWithoutRecursionWithoutStack(root.right, path +" , "+ root.value, num - root.value);

	}

}