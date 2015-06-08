package com.problems.geeksforgeeks.trees;


public class ConvertBinaryTreeWhichHoldsChildrenSumProperty {

	public static void main(String[] args) {
		//    		  50
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

		convert(tree1);
		LevelOrderTreeTraversal.levelOrderTraversal(tree1);
	}

	public static void convert(TreeNode root) {

		if (root == null) {
			return;
		}
		convert(root.left);
		convert(root.right);
		int sum = (root.left == null ? 0 : root.left.value) + (root.right == null ? 0 : root.right.value);
		if (sum != root.value) {
			if (sum < root.value) {
				if (root.left != null) {
					root.left.value = root.left.value + root.value - sum;
				} else if (root.right != null) {
					root.right.value = root.right.value + root.value - sum;
				}
				convert(root.left);

			} else {
				root.value += sum - root.value;
			}

		}
	}

}