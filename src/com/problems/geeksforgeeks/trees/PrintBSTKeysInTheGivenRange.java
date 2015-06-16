package com.problems.geeksforgeeks.trees;



public class PrintBSTKeysInTheGivenRange {

	public static void main(String[] args) {
		//    		  50
		// 		 7   	    	60
		//	  3     45		55		70
		//		5						80
		
		TreeNode tree1 = new TreeNode(50);
		tree1.left = new TreeNode(7);
		tree1.right = new TreeNode(60);
		
		tree1.right.left = new TreeNode(55);
		tree1.right.right = new TreeNode(70);
		tree1.right.right.right = new TreeNode(80);
		
		tree1.left.left = new TreeNode(3);
		tree1.left.left.right = new TreeNode(5);
		tree1.left.right = new TreeNode(45);

		
		
		TreeNode tree2 = new TreeNode(10);
		tree2.right = new TreeNode(20);
		tree2.right.right = new TreeNode(30);
		tree2.right.right.right = new TreeNode(40);
		tree2.right.right.right.right = new TreeNode(50);

		print(tree1, 0, 70);
		System.out.println();
		print(tree1, 54, 59);
		System.out.println();
		print(tree1, 70, 90);

	}

	public static void print(TreeNode root, int lower, int upper) {
		if (root == null) {
			return ;
		}



		if(root.value>upper || (lower<= root.value && root.value <=upper)){
			print(root.left,lower,upper);
		}
		if(lower<= root.value && root.value <=upper){
			System.out.print(root.value + " ");
		}

		if(root.value<lower || (lower<= root.value && root.value <=upper)){
			print(root.right,lower,upper);
		}

	}

}