package com.problems.geeksforgeeks.trees;

public class LowestCommonAncestor {

	public static void main(String[] args) {
		//    		  14
		// 		 5   	    15
		//	  4     7
	//			  6	   12
		//           8	  13
		
		TreeNode tree1 = new TreeNode(14);
		tree1.left = new TreeNode(5);
		tree1.right = new TreeNode(15);
		tree1.left.left = new TreeNode(4);
		tree1.left.right = new TreeNode(7);
		tree1.left.right.left = new TreeNode(6);
		tree1.left.right.right = new TreeNode(12);
		tree1.left.right.right.left = new TreeNode(8);
		tree1.left.right.right.right = new TreeNode(13);

		System.out.println(lca(tree1, 13, 15));
	}

	/**
	 * assuming node1 value is always less than node2
	 */
	public static int lca(TreeNode root, int node1, int node2) {
		if (root == null) {
			return 0;

		}
		if (node1 <= root.value && node2 >= root.value) {
			return root.value;
		}

		if (node1 <= root.value) {
			return lca(root.left, node1, node2);
		} else {
			return lca(root.right, node1, node2);
		}

	}

}
