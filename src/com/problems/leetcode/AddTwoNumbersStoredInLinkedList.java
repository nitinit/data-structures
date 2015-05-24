package com.problems.leetcode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * @author raja
 *
 */
public class AddTwoNumbersStoredInLinkedList {

	public static void main(String[] args) {

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode sol = null;
		ListNode header = null;
		ListNode l1Header = l1;
		ListNode l2Header = l2;
		int carry = 0;

		while (l1Header != null || l2Header != null) {
			if (sol == null) {
				sol = new ListNode(0);
				header = sol;
			} else {
				sol.next = new ListNode(0);
				sol = sol.next;
			}
			sol.val = ((l1Header == null ? 0 : l1Header.val)
					+ (l2Header == null ? 0 : l2Header.val) + carry) % 10;
			carry = ((l1Header == null ? 0 : l1Header.val)
					+ (l2Header == null ? 0 : l2Header.val) + carry) / 10;
			l1Header = l1Header != null ? l1Header.next : null;
			l2Header = l2Header != null ? l2Header.next : null;
		}
		if (carry != 0) {
			sol.next = new ListNode(carry);
		}
		return header;
	}

}

class ListNode {
	int val;
	ListNode next;
	int carry;
	ListNode(int x) {
		val = x;
	}

}
