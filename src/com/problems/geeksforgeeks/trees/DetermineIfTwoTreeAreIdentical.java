package com.problems.geeksforgeeks.trees;

public class DetermineIfTwoTreeAreIdentical {

	public static void main(String[] args) {
		TreeNode tree1 = new TreeNode(10);
		tree1.left = new TreeNode(5);
		tree1.right = new TreeNode(15);
		tree1.left.right = new TreeNode(7);
		tree1.left.left = new TreeNode(9);

		TreeNode tree2 = new TreeNode(10);
		tree2.left = new TreeNode(5);
		tree2.right = new TreeNode(15);
		tree2.left.right = new TreeNode(7);
		tree2.left.right.right = new TreeNode(7);

		System.out.println(check(tree1, tree2));
	}

	public static boolean check(TreeNode tree1, TreeNode tree2) {

		if (tree1 == null && tree2 == null) {
			return true;
		}

		if (tree1 != null && tree2 != null) {
			return tree1.value == tree2.value && check(tree1.left, tree2.left) && check(tree1.right, tree2.right);
		}
		return false;

	}

}
