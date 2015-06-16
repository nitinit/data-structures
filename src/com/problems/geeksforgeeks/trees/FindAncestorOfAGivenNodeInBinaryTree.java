package com.problems.geeksforgeeks.trees;



public class FindAncestorOfAGivenNodeInBinaryTree {

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

		
		
		TreeNode tree2 = new TreeNode(10);
		tree2.right = new TreeNode(20);
		tree2.right.right = new TreeNode(30);
		tree2.right.right.right = new TreeNode(40);
		tree2.right.right.right.right = new TreeNode(50);
		
		find(tree1, 3);
		System.out.println();

	}

	public static boolean find(TreeNode root, int node) {
		if (root == null) {
			return false;
		}
		if(node==root.value){
			return true;
		}
		if(find(root.left, node) || find(root.right, node)){
			System.out.print(root.value + " ");
			return true;
		}
		return false;
	}

}