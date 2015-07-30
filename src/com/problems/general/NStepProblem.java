package com.problems.general;

public class NStepProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

//		System.out.println(countWays(35));
		System.out.println(System.currentTimeMillis());
//		System.out.println(countWays(35));
		System.out.println(countWaysDP(35, new int[36]));
		System.out.println(System.currentTimeMillis());
	}

	private static int countWaysDP(int n, int[] map) {

		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else if (map[n] != 0) {
			return map[n];
			}
		else {
			map[n] = countWaysDP(n - 1, map) + countWaysDP(n - 2, map)
					+ countWaysDP(n - 3, map);
			return map[n];
		}
	}

	public static  int countWays(int n) {
		if (n < 0) {
			return 0;
		} else if (n == 0) {
			return 1;
		} else {
			return countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
		}
	}

}
