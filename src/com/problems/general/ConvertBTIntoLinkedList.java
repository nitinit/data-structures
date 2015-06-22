package com.problems.general;
public class ConvertBTIntoLinkedList {
	public static void main(String[] args) {

		// TreeNode root = new TreeNode(10);
		// root.left = new TreeNode(12);
		// root.right = new TreeNode(15);
		// root.left.left = new TreeNode(25);
		// root.left.right = new TreeNode(30);
		// root.right.left = new TreeNode(36);

		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(4);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(10);
		root.right.right.left = new TreeNode(9);
		root.right.right.left.left = new TreeNode(8);

		root.left.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.left.right = new TreeNode(2);
		root.left.left.right.right = new TreeNode(3);

		TreeNode head = createDLL(root);
		printDLL(head);
	}

	public static void printDLL(TreeNode root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.right;
		}
	}

	private static void createDLL(TreeNode root, TreeNode[] head) {
		if (root == null)
			return;
		createDLL(root.right, head);
		root.right = head[0];
		if (head[0] != null)
			head[0].left = root;
		head[0] = root;
		createDLL(root.left, head);
	}

	public static TreeNode createDLL(TreeNode root) {
		if (root == null)
			return null;
		TreeNode[] head = new TreeNode[1];
		createDLL(root, head);
		return head[0];
	}

}

class TreeNode {
	public int data;
	public TreeNode left;
	public TreeNode right;
	public TreeNode next;

	public TreeNode(){

	}

	public TreeNode(int data) {
		this.data = data;
	}
}
