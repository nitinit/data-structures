package com.problems.leetcode;

public class AddTwoNumbersStoredReverseInLinkedList {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(6);

		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(4);
		l2.next.next = new ListNode(8);
		l2.next.next.next = new ListNode(6);
		
		ListNode result = addTwoNumbers(l1, l2);
		ListNode c = null;
		if(result.carry!=0){
		 c = new ListNode(result.carry);
			c.next = result;
		}else{
			c = result;
		}
		while (c != null) {
			System.out.println(c.val);
			c = c.next;
		}

	}

	@SuppressWarnings("unused")
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sol = null;
		if (l1.next != null || l2.next != null) {
			sol = addTwoNumbers(l1.next, l2.next);
		}

		ListNode header = new ListNode(0);
		
		header.val = ((l1 == null ? 0 : l1.val)
				+ (l2 == null ? 0 : l2.val) + (sol==null ? 0 : sol.carry)) % 10;
		int carry = ((l1 == null ? 0 : l1.val)
				+ (l2 == null ? 0 : l2.val) + (sol==null ? 0 : sol.carry)) / 10;
		header.next = sol;
		header.carry=carry;
		return header;
	}

}
