package com.problems.geeksforgeeks.trees;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.right = new TreeNode(7);
		root.left.left = new TreeNode(9);
		System.out.println("Inorder");
		inorderTraversal(root);
		System.out.println("\nPreorder");
		preorderTraversal(root);
		System.out.println("\nPostorder");
		postOrderTraversal(root);
	}

	public static void inorderTraversal(TreeNode root) {
		if(root==null){
			return;
		}
		inorderTraversal(root.left);
		System.out.print(root.value + ", ");
		inorderTraversal(root.right);
	}
	
	public static void preorderTraversal(TreeNode root) {
		if(root==null){
			return;
		}
		System.out.print(root.value + ", ");
		preorderTraversal(root.left);
		preorderTraversal(root.right);
	}

	public static void postOrderTraversal(TreeNode root) {
		if(root==null){
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.value + ", ");
	}

}
