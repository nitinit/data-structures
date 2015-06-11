package com.problems.geeksforgeeks.trees;



public class PrintNodesAtKdistanceFromRoot {

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
		
		printNodesAtKdistanceFromRoot(tree2,3);
		System.out.println();
		printNodesAtKdistanceFromRoot(tree1,2);
		System.out.println();
		printNodesAtKdistanceFromRoot(tree1,3);
		System.out.println();
		printNodesAtKdistanceFromRoot(tree1,1);
		System.out.println();
		
	}

	public static void printNodesAtKdistanceFromRoot(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		if(depth==0){
			System.out.print(root.value + " ");
		}
		printNodesAtKdistanceFromRoot(root.left, depth-1);
		printNodesAtKdistanceFromRoot(root.right, depth-1);
	}

}