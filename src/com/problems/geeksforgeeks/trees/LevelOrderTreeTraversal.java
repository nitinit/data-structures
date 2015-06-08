package com.problems.geeksforgeeks.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class LevelOrderTreeTraversal {

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

		lotHeightApproach(tree1);
		lotQueueApproach(tree1);
		levelOrderTraversal(tree1);
	}

	public static void lotHeightApproach(TreeNode root) {
		if (root == null) {
			return;
		}
		
		int height = HeightOfTree.heightOfTree(root);
		for(int i=1;i<=height;i++){
			lotHeightApproach(root,i);
			System.out.println();
		}
		
	}

	public static void lotHeightApproach(TreeNode root, int i) {
		if(root==null){
			return ;
		}
		if(i==1){
			System.out.print(root.value + " ");
		}
		lotHeightApproach(root.left,i-1);
		lotHeightApproach(root.right,i-1);
	}
	
	public static void lotQueueApproach(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(CalculateSizeOfTree.sizeOfTree(root));
		queue.add(root);
		System.out.print(root.value + " ");
		System.out.println();
		while (!queue.isEmpty()) {
			TreeNode node = queue.element();
			System.out.print(node.value + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
			queue.remove(node);
			System.out.println();
		}
	}
	
	 public static void levelOrderTraversal(TreeNode startNode) {  
	        Queue<TreeNode> queue=new LinkedList<TreeNode>();  
	        queue.add(startNode);  
	        while(!queue.isEmpty())  
	        {  
	            TreeNode tempNode=queue.poll();  
	            System.out.printf("%d ",tempNode.value);  
	            if(tempNode.left!=null)  
	                queue.add(tempNode.left);  
	            if(tempNode.right!=null)  
	                queue.add(tempNode.right);  
	        }  
	    } 
	 
	 public static boolean levelOrderTraversal1(TreeNode root) {
		 
		 if(root==null){
			 return true;
		 }
		 
		 if(root.left.value + root.right.value == root.value){
			 return levelOrderTraversal1(root.left) && levelOrderTraversal1(root.right);
		 }
		 
		 return false;
		 
	 }

}