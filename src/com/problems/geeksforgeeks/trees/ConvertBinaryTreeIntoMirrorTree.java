package com.problems.geeksforgeeks.trees;

public class ConvertBinaryTreeIntoMirrorTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.right = new TreeNode(7);
		root.left.right.right = new TreeNode(9);

		preorderTraversal(root);
		TreeNode mirror = mirror(root);
		// delete root node
		preorderTraversal(mirror);

		TreeNode mirrorOfMirror = mirror(mirror);
		System.out.println(DetermineIfTwoTreeAreIdentical.check(root, mirrorOfMirror));

		mirror2(root);
		preorderTraversal(root);
	}

	private static void preorderTraversal(TreeNode root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + ", ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	private static TreeNode mirror(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode node = new TreeNode(root.value);
		node.left = mirror(root.right);
		node.right = mirror(root.left);
		return node;
	}

	private static void mirror2(TreeNode root) {
		if (root == null) {
			return;
		}

		mirror(root.right);
		mirror(root.left);
		TreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;
	}

}
