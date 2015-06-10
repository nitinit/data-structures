package com.problems.geeksforgeeks.trees;


public class DetermineIfTreeIsBalanced {

	public static void main(String[] args) {
		//    		  50
		// 		 7   	    	2
		//	  3     2		10		30
		//								40
		//									50
		TreeNode tree1 = new TreeNode(50);
		tree1.left = new TreeNode(7);
		tree1.right = new TreeNode(2);
		
		tree1.right.left = new TreeNode(10);
		tree1.right.right = new TreeNode(30);
		tree1.right.right.right = new TreeNode(40);
		tree1.right.right.right.right = new TreeNode(50);
		
		tree1.left.left = new TreeNode(3);
		tree1.left.right = new TreeNode(2);

		System.out.println(isBalanced(tree1)[1]==0);
	}

	public static int[] isBalanced(TreeNode root) {
		int[] arr = new int[] { 0, 0 };
		if (root == null) {
			return arr;
		}
		int[] left = isBalanced(root.left);
		int[] right = isBalanced(root.right);

		int height = Math.max(left[0], right[0]) + 1;
		arr[0] = height;
		if ((left[0] - right[0]) > 1 || (right[0] - left[0]) > 1) {
			arr[1] = 1;
		}
		return arr;
	}
	

}