package com.problems.geeksforgeeks.trees;


public class CheckIfABinaryTreeIsBST {

	public static void main(String[] args) {
		//    		  14
		// 		 5   	    				20
		//	  4     7			15
	//			  6	   12		  16
		//           8	  13		17
		//								18
		
		TreeNode tree1 = new TreeNode(14);
		tree1.left = new TreeNode(5);
		tree1.right = new TreeNode(20);
		
		tree1.right.left = new TreeNode(15);
		tree1.right.left.right = new TreeNode(16);
		tree1.right.left.right.right = new TreeNode(17);
		tree1.right.left.right.right.right = new TreeNode(18);
		
		
		tree1.left.left = new TreeNode(4);
		tree1.left.right = new TreeNode(7);
		tree1.left.right.left = new TreeNode(6);
		tree1.left.right.right = new TreeNode(12);
		tree1.left.right.right.left = new TreeNode(8);
		tree1.left.right.right.right = new TreeNode(13);

		System.out.println(checkIfABinaryTreeIsBST(tree1,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

	public static boolean checkIfABinaryTreeIsBST(TreeNode root, int minValue, int maxValue) {
		if (root == null) {
			return true;
		}
		if (root.value > maxValue || root.value < minValue) {
			return false;
		}

		return checkIfABinaryTreeIsBST(root.left, minValue, root.value) && checkIfABinaryTreeIsBST(root.right, root.value, maxValue);
	}

}