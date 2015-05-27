package com.problems.general;

/**
 * http://www.geeksforgeeks.org/print-all-interleavings-of-given-two-strings/
 * 
 * @author raja 27-May-2015
 *
 */
public class InterleavingsOfTwoStrings {

	public static void main(String[] args) {

		printAllInterleavingsOfTwoStrings("ABC", 0, "DE", 0, 3, 2, new String[5], 0);
		System.out.println(count(3, 2));
	}

	private static int count(int m, int n) {

		if (m < 0 || n < 0) {
			return 0;
		}

		if (m == 0 && n == 1) {
			return 1;
		}

		if (n == 0 && m == 1) {
			return 1;
		}

		return count(m - 1, n) + count(m, n - 1);
	}

	private static void printAllInterleavingsOfTwoStrings(String s1, int s1Index, String s2, int s2Index, int sizeS1, int sizeS2, String[] s3, int sizeS3) {

		if (sizeS1 == 0 && sizeS2 == 0) {
			System.out.println(s3[0] + s3[1] + s3[2] + s3[3] +s3[4]);
		}

		if (sizeS1 != 0) {
			s3[sizeS3] = s1.charAt(s1Index) + "";
			printAllInterleavingsOfTwoStrings(s1, s1Index + 1, s2, s2Index, sizeS1 - 1, sizeS2, s3, sizeS3 + 1);
		}

		if (sizeS2 != 0) {
			s3[sizeS3] = s2.charAt(s2Index) + "";
			printAllInterleavingsOfTwoStrings(s1, s1Index, s2, s2Index + 1, sizeS1, sizeS2 - 1, s3, sizeS3 + 1);
		}
	}
}
