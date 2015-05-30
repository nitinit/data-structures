package com.problems.general;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-
 * subsequence/
 * 
 * @author raja 28-May-2015
 *
 */
public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		System.out.println(lpsCount(new String[] { "G", "E", "E", "K", "S", "F", "O", "R", "K", "E", "E", "G" }, 0, 11));
		System.out.println(lpsCountDynamic(new String[] { "G", "E", "E", "K", "S", "F", "O", "R", "K", "E", "E", "G" }));
	}

	public static int lpsCount(String[] seq, int i, int j) {

		// Base Case 1: If there is only 1 character
		if (i == j)
			return 1;

		// Base Case 2: If there are only 2 characters and both are same
		if (seq[i] == seq[j] && i + 1 == j)
			return 2;

		// If the first and last characters match
		if (seq[i] == seq[j])
			return lpsCount(seq, i + 1, j - 1) + 2;

		// If the first and last characters do not match
		return Math.max(lpsCount(seq, i, j - 1), lpsCount(seq, i + 1, j));
	}

	public static int lpsCountDynamic(String[] str) {
		int n = str.length;
		int i, j, cl;
		int L[][] = new int[n][n]; // Create a table to store results of
									// subproblems

		// Strings of length 1 are palindrome of lentgh 1
		for (i = 0; i < n; i++)
			L[i][i] = 1;

		// Build the table. Note that the lower diagonal values of table are
		// useless and not filled in the process. The values are filled in a
		// manner similar to Matrix Chain Multiplication DP solution (See
		// http://www.geeksforgeeks.org/archives/15553). cl is length of
		// substring
		for (cl = 2; cl <= n; cl++) {
			for (i = 0; i < n - cl + 1; i++) {
				j = i + cl - 1;
				if (str[i] == str[j] && cl == 2)
					L[i][j] = 2;
				else if (str[i] == str[j])
					L[i][j] = L[i + 1][j - 1] + 2;
				else
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
			}
		}

		return L[0][n - 1];
	}

}
