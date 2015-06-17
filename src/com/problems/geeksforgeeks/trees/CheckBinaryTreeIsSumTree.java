package com.problems.geeksforgeeks.trees;



public class CheckBinaryTreeIsSumTree {

	public static void main(String[] args) {
		//    		  80
		// 		 30   	    	10
		//	  10     10		4		6
		//		10
		
		TreeNode tree1 = new TreeNode(80);
		tree1.left = new TreeNode(30);
		tree1.right = new TreeNode(10);
		
		tree1.right.left = new TreeNode(4);
		tree1.right.right = new TreeNode(6);

		tree1.left.left = new TreeNode(10);
		tree1.left.left.right = new TreeNode(10);
		tree1.left.right = new TreeNode(10);

		
		
		TreeNode tree2 = new TreeNode(10);
		tree2.right = new TreeNode(20);
		tree2.right.right = new TreeNode(30);
		tree2.right.right.right = new TreeNode(40);
		tree2.right.right.right.right = new TreeNode(50);

		System.out.println(check(tree1)[0]);

	}

	public static int[] check(TreeNode root) {

		int[] arr = new int[]{0, 0};
		if (root == null) {
			return arr;
		}
		if(arr[0]==1){
			return arr;
		}
		int[] left = check(root.left);
		int[] right = check(root.right);

		if (left[1] + right[1] == root.value) {
			int sum = left[1] + right[1] + root.value;
			arr[1] = sum;
		} else if(left[1]==0 && right[0]==0){
			arr[1] = root.value;
		}
		else {
			arr[0] = 1;
		}
		return arr;
	}

}