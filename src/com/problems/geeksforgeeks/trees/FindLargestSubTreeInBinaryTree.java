package com.problems.geeksforgeeks.trees;



public class FindLargestSubTreeInBinaryTree {

	public static void main(String[] args) {
		//    		  61
		// 		 7   	    	60
		//	  3     10		55		70
		//		4					80
		//        5
		TreeNode tree1 = new TreeNode(61);
		tree1.left = new TreeNode(7);
		tree1.right = new TreeNode(60);
		
		tree1.right.left = new TreeNode(55);
		tree1.right.right = new TreeNode(70);
		tree1.right.right.right = new TreeNode(80);
		
		tree1.left.left = new TreeNode(3);
		tree1.left.left.right = new TreeNode(4);
		tree1.left.left.right.right = new TreeNode(5);
		tree1.left.right = new TreeNode(10);

		
		
		TreeNode tree2 = new TreeNode(10);
		tree2.right = new TreeNode(20);
		tree2.right.right = new TreeNode(30);
		tree2.right.right.right = new TreeNode(40);
		tree2.right.right.right.right = new TreeNode(50);
		
		System.out.println(find(tree1)[1]);

	}

	public static int[] find(TreeNode root) {
		int[] arr = new int[]{0, 0, 0, 0}; // true/false , size . min , max
		if (root == null) {
			return arr;
		}

		int[] left = find(root.left);
		int[] right = find(root.right);

		if (left[0] == 1 && right[0] == 1) {
			if (left[3] <= root.value && right[2] >= root.value) {
				arr[0] = 1;
				arr[1] = left[1] + right[1] + 1;
				arr[2] = left[2];
				arr[3] = right[3];
			} else {
				arr[0] = 0;
				arr[1] = Math.max(left[1], right[1]);
				arr[2] = 0;
				arr[3] = 0;
			}
		} else {
			if (root.left == null && root.right == null) {
				arr[0] = 1;
				arr[1] = 1;
				arr[2] = root.value;
				arr[3] = root.value;
			} else if (root.left == null && right[2] >= root.value) {
				arr[0] = right[0];
				arr[1] = right[1] + 1;
				arr[2] = root.value;
				arr[3] = right[3];
			} else if (root.right == null && left[3] <= root.value) {
				arr[0] = left[0];
				arr[1] = left[1] + 1;
				arr[2] = left[2];
				arr[3] = root.value;
			} else {

				arr[0] = 0;
				arr[1] = Math.max(left[1], right[1]);
				arr[2] = 0;
				arr[3] = 0;
			}

		}
		return arr;


	}

}