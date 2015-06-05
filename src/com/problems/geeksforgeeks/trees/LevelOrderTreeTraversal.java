package com.problems.geeksforgeeks.trees;

/**
 * 
 * @author raja 01-Jun-2015
 *
 */
public class LevelOrderTreeTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.right = new TreeNode(7);
		root.left.left = new TreeNode(9);
		System.out.println(countLeafNode(root));

	}

	private static int countLeafNode(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		return countLeafNode(root.left) + countLeafNode(root.right);
	}

}
