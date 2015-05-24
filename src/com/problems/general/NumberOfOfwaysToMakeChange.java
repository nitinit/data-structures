package com.problems.general;

public class NumberOfOfwaysToMakeChange {

	public static void main(String[] args) {
		System.out.println(makeChange(5, 3));
	}

	public static int makeChange(int n, int denom) {
		int next_denom = 0;
		switch (denom) {
		case 3:
			next_denom = 2;
			break;
		case 2:
			next_denom = 1;
			break;
		case 1:
			return 1;
		}

		int ways = 0;
		for (int i = 0; i * denom <= n; i++) {
			ways += makeChange(n - i * denom, next_denom);
		}

		return ways;
	}

}
