package com.problems.geeksforgeeks.trees;

public class HeightOfTree {

	public static void main(String[] args) {
		TreeNode tree2 = new TreeNode(10);
		tree2.left = new TreeNode(5);
		tree2.right = new TreeNode(15);
		tree2.left.right = new TreeNode(7);
		tree2.left.right.right = new TreeNode(7);

		System.out.println(heightOfTree(tree2));
	}

	private static int heightOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;

	}

}
