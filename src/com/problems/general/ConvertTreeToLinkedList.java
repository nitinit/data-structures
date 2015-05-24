package com.problems.general;
public class ConvertTreeToLinkedList {

	static Node pre = new Node(0);

	public static void main(String[] args) {

		Node root = new Node(6);
		root.left = new Node(4);
		root.right = new Node(7);
		root.right.right = new Node(10);
		root.right.right.left = new Node(9);
		root.right.right.left.left = new Node(8);

		root.left.right = new Node(5);
		root.left.left = new Node(1);
		root.left.left.right = new Node(2);
		root.left.left.right.right = new Node(3);

//		convert(root);
//		while (pre != null) {
//			System.out.println(pre.value);
//			pre = pre.left;
//		}
		Node[] head = new Node[1];
		convert(root,head);
		Node h = head[0];
		while (h != null) {
			System.out.println(h.value);
			h = h.left;
		}
	}

	public static void convert(Node root, Node[] head) {
		if (root == null) {
			return;
		}
		convert(root.left, head);
		root.left = head[0];
		if(head[0]!=null){
			head[0].right = root;
		}
		head[0] = root;
		convert(root.right, head);

	}

	public static void convert(Node root) {
		if (root == null) {
			return;
		}
		convert(root.left);
		root.left = pre;
		pre.right = root;
		pre = root;
		convert(root.right);

	}

}

class Node {
	Node left;
	Node right;
	int value;

	Node next;

	Node(int val) {
		this.value = val;
	}
}
