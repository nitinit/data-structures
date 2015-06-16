package com.problems.geeksforgeeks.trees;

public class LevelOfANodeInBinaryTree {

	public static void main(String[] args) {
//		  50
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

	System.out.println(findLevel(tree1, 30,1));
	System.out.println(findLevel(tree1, 50,1));
	System.out.println(findLevel(tree1, 7,1));
	System.out.println(findLevel(tree1, 1,1));
	System.out.println(findLevel(tree1, 10,1));
	
	}

	public static int findLevel(TreeNode root, int data, int level) {
		if (root == null) {
			return 0;
		}

		if (data == root.value) {
			return level;
		}
		int dlevel = findLevel(root.left, data, level + 1);
		if (dlevel != 0) {
			return dlevel;
		}
		dlevel = findLevel(root.right, data, level + 1);
		return dlevel;
	}

}
