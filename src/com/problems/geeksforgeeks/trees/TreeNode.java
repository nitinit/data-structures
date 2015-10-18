package com.problems.geeksforgeeks.trees;

public class TreeNode {

	public TreeNode left;
	public TreeNode right;
	public int value;
	public TreeNode next;
	public TreeNode previous;
	public int height;
	public TreeNode down;
	public boolean deleted;

	public TreeNode(int value) {
		this.value = value;
	}

}
