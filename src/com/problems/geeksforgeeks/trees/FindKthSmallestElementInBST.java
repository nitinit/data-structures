package com.problems.geeksforgeeks.trees;

/**
 * http://www.geeksforgeeks.org/find-k-th-smallest-element-in-bst-order-statistics-in-bst/
 * 
 * @author raja 12-Jun-2015
 *
 */
public class FindKthSmallestElementInBST {

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

		
	}

	public static void find(TreeNode root, int currentRank, int rank) {
		if (root == null) {
			return;
		}
		
		find(root.left, currentRank-1,rank);
		
		find(root.right, currentRank-1,rank);

	}

}