package com.problems.geeksforgeeks.trees;

public class CalculateSizeOfTree {

	private static int size;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.right = new TreeNode(7);
		root.left.left = new TreeNode(9);
		calculateSizeOfTree(root);
		System.out.println(size);
		System.out.println(sizeOfTree(root));
	}

	private static void calculateSizeOfTree(TreeNode root) {

		if (root == null) {
			return;
		}

		size++;
		calculateSizeOfTree(root.left);
		calculateSizeOfTree(root.right);

	}

	private static int sizeOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sizeOfTree(root.left) + sizeOfTree(root.right) + 1;
	}

}
