package com.problems.geeksforgeeks.trees;

public class PrintAllRootToLeafPaths {

	public static void main(String[] args) {
		//    		  10
		// 		 5   	    15
		//	  9     7
	//			  6	   12
		//           8	  13
		
		TreeNode tree1 = new TreeNode(10);
		tree1.left = new TreeNode(5);
		tree1.right = new TreeNode(15);
		tree1.left.left = new TreeNode(9);
		tree1.left.right = new TreeNode(7);
		tree1.left.right.left = new TreeNode(6);
		tree1.left.right.right = new TreeNode(12);
		tree1.left.right.right.left = new TreeNode(8);
		tree1.left.right.right.right = new TreeNode(13);

		printAllRootToLeafPaths(tree1, "");
	}

	public static void printAllRootToLeafPaths(TreeNode root, String path) {
		if (root.left == null && root.right == null) {
			System.out.println("Path : " + path + " "+ root.value);
			return;
		}
		if (root.left == null) {
			return;
		}
		if (root.right == null) {
			return;
		}
		path = path + " " + root.value;
		printAllRootToLeafPaths(root.left, path );
		printAllRootToLeafPaths(root.right, path );

	}

}
