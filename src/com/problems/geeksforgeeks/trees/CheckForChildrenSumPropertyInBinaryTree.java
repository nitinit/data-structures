package com.problems.geeksforgeeks.trees;


public class CheckForChildrenSumPropertyInBinaryTree {

	public static void main(String[] args) {
		//    		  14
		// 		 5   	    	9
		//	  4     1		9
		
		TreeNode tree1 = new TreeNode(14);
		tree1.left = new TreeNode(5);
		tree1.right = new TreeNode(9);
		
		tree1.right.left = new TreeNode(9);
		
		tree1.left.left = new TreeNode(4);
		tree1.left.right = new TreeNode(1);

		System.out.println(check(tree1));
	}

	 public static boolean check(TreeNode root) {
		 
		 if(root==null || (root.left ==null && root.right==null)){
			 return true;
		 }
		 
		 if((root.left==null ? 0 : root.left.value )+ (root.right==null ? 0 :root.right.value )== root.value){
			 return check(root.left) && check(root.right);
		 }
		 
		 return false;
		 
	 }

}