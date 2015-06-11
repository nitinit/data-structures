package com.problems.geeksforgeeks.trees;



public class ConstructTreeFromGivenInorderAndPreorderTraversals {
	
	private static int preOrderIndex = 0;

	public static void main(String[] args) {
		//    		  50
		// 		 7   	    	15
		//	  3     2		10		30
		//		1					40
		
		String[] inOrder = {"3","1","7","2","50","10","15","30","40"};
		String[] preOrder = {"50","7","3","1","2","15","10","30","40"};
		TreeNode root = buildTree(inOrder, preOrder, 0, 8);
		LevelOrderTreeTraversal.levelOrderTraversal(root);
	}

	public static TreeNode buildTree(String[] inOrder, String[] preOrder, int start, int end) {

		if (start > end) {
			return null;
		}

		TreeNode root = new TreeNode(Integer.valueOf(preOrder[preOrderIndex]));
		preOrderIndex++;
		if (start == end) {
			return root;
		}
		int index = 0;
		for (int i = 0; i < inOrder.length; i++) {
			if (Integer.valueOf(inOrder[i]) == root.value) {
				index = i;
				break;
			}
		}

		root.left = buildTree(inOrder, preOrder, start, index - 1);
		root.right = buildTree(inOrder, preOrder, index + 1, end);
		return root;
	}

}