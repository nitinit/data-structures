package com.problems.general;

public class MinimumCoinsToMakeChange {

	public static void main(String[] args) {

		System.out.println(numberOfCoinsToMakeChangeP(17, new int[] { 1, 2, 5 }));
		System.out.println(count(new int[] { 1, 2, 3 }, 3, 5));

	}
	
	public static int count(int S[], int size, int sum) {
		int i, j, x, y;

		// We need n+1 rows as the table is consturcted in bottom up manner
		// using
		// the base case 0 value case (n = 0)
		int[][] table = new int[sum + 1][size];

		// Fill the enteries for 0 value case (n = 0)
		for (i = 0; i < size; i++)
			table[0][i] = 1;

		// Fill rest of the table enteries in bottom up manner
		for (i = 1; i < sum + 1; i++) {
			for (j = 0; j < size; j++) {
				// Count of solutions including S[j]
				x = (i - S[j] >= 0) ? table[i - S[j]][j] : 0;

				// Count of solutions excluding S[j]
				y = (j >= 1) ? table[i][j - 1] : 0;

				// total count
				table[i][j] = x + y;
			}
		}
		return table[sum][size - 1];
	}

	public static int numberOfCoinsToMakeChangeP(int sum, int[] coins) {
		if (sum == 0) {
			return 0;
		}
		if (sum < 0) {
			return Integer.MAX_VALUE;
		}
		int n = min(numberOfCoinsToMakeChangeP(sum - coins[0], coins), numberOfCoinsToMakeChangeP(sum - coins[1], coins), numberOfCoinsToMakeChangeP(sum - coins[2], coins)) + 1;
		return n;
	}

	private static int min(int numberOfCoinsToMakeChangeP, int numberOfCoinsToMakeChangeP2, int numberOfCoinsToMakeChangeP3) {
		return Math.min(numberOfCoinsToMakeChangeP2, Math.min(numberOfCoinsToMakeChangeP, numberOfCoinsToMakeChangeP3));
	}

}
