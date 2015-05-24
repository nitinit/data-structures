package com.problems.general;
public class LargestSumContiguousSubarraykadanesAlgo {

	public static void main(String[] args) {

		System.out.println(maxSubArraySum(new int[] { -1, 3, -2, 1, 2, -1, 2 }, 7));
	}

	private static int maxSubArraySum(int a[], int size) {
		int maxSoFar = 0;
		int maxEndingHere = 0;
		int i;
		for (i = 0; i < size; i++) {
			maxEndingHere = maxEndingHere + a[i];
			if (maxEndingHere < 0)
				maxEndingHere = 0;
			if (maxSoFar < maxEndingHere)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}

}
