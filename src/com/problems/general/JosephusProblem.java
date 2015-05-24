package com.problems.general;

/**
 * http://www.geeksforgeeks.org/josephus-problem-set-1-a-on-solution/
 * 
 * @author raja
 *
 */
public class JosephusProblem {

	public static void main(String[] args) {

		System.out.println(josephusRecursion(14, 2));
		System.out.println(josephusIteration(14, 2));

	}

	private static int josephusRecursion(int n, int k) {
		if (n == 1) return 1;
		return (josephusRecursion(n - 1, k) + k - 1) % n + 1;
	}

	private static int josephusIteration(int n, int k) {
		int a = 1;
		for (int i = 1; i <= n; i++) {
			a = (a + k - 1) % i + 1;
		}
		return a;
	}

}
