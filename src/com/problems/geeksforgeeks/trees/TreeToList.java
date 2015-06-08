package com.problems.geeksforgeeks.trees;

public class TreeToList {

	public static void main(String[] args) {
		//    		  14
		// 		 5   	    				20
		//	  4     7			15
	//			  6	   12		  16
		//           8	  13		17
		//								18
		
		TreeNode tree1 = new TreeNode(14);
		tree1.left = new TreeNode(5);
		tree1.right = new TreeNode(20);
		
		tree1.right.left = new TreeNode(15);
		tree1.right.left.right = new TreeNode(16);
		tree1.right.left.right.right = new TreeNode(17);
		tree1.right.left.right.right.right = new TreeNode(18);
		
		
		tree1.left.left = new TreeNode(4);
		tree1.left.right = new TreeNode(7);
		tree1.left.right.left = new TreeNode(6);
		tree1.left.right.right = new TreeNode(12);
		tree1.left.right.right.left = new TreeNode(8);
		tree1.left.right.right.right = new TreeNode(13);

		TreeNode head1 = treeToList(tree1);
		
		while (head1.next!=null){
			System.out.print(head1.value + " ");
			head1 = head1.next;
		}
		System.out.print(head1.value + " ");
		System.out.println();
		while (head1.previous!=null){
			System.out.print(head1.value + " ");
			head1 = head1.previous;
		}
		System.out.print(head1.value + " ");
	}

	public static TreeNode treeToList(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode left = treeToList(root.left);

		TreeNode list = left;
		while (left != null && left.next != null) {
			left = left.next;
		}
		if (left == null) {
			left = new TreeNode(root.value);
			list = left;
		} else {
			left.next = new TreeNode(root.value);
			left.next.previous = left;
			left = left.next;
		}

		TreeNode right = treeToList(root.right);
		if (right != null) {
			left.next = right;
			while (left.next != null) {
				left.next.previous = left;
				left = left.next;
			}
		}
		return list;
	}

}
