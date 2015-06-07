package com.problems.geeksforgeeks.trees;

public class DeleteTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.right = new TreeNode(7);
		root.left.right.right = new TreeNode(9);

		deleteTree(root);
		// delete root node
		System.out.println(root.value + ", " + root.left + ", " + root.right);
	}

	private static void deleteTree(TreeNode root) {
		if (root == null) {
			return;
		}

		deleteTree(root.left);
		deleteTree(root.right);
		if (root.left != null && (root.left.left == null && root.left.right == null)) {
			System.out.println("Deleting node : " + root.left.value);
			root.left = null;
		}

		if (root.right != null && (root.right.left == null && root.right.right == null)) {
			System.out.println("Deleting node : " + root.right.value);
			root.right = null;
		}

	}

}
