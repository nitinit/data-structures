package com.problems.leetcode;

/**
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays-of-different-sizes/
 * 
 * @author raja
 *
 */
public class MedianSortedArrays {

	public static void main(String[] args) {
		int a[] = { 1, 2 };
		int b[] = { 1, 2 };

		System.out.println(findMedianSortedArrays(a, b));
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		if (n == 0) {
			if (m == 0) {
				return 0.0;
			}
			if (m == 1) {
				return nums2[0];
			}
			if (m % 2 == 1) {
				return nums2[m / 2];
			}

			double sol = 0.0;
			for (int i = 0; i < m; i++) {
				sol += nums2[i];
			}
			return sol / m;
		}
		if (m == 0) {
			if (n == 1) {
				return nums1[0];
			}
			if (n % 2 == 1) {
				return nums1[n / 2];
			}
			double sol = 0.0;
			for (int i = 0; i < n; i++) {
				sol += nums1[i];
			}
			return sol / n;
		}
		if (n > m)
			return findMedianSortedArrays(nums2, m, nums1, n);

		return findMedianSortedArrays(nums1, n, nums2, m);
	}

	public static double findMedianSortedArrays(int[] a, int n, int[] b, int m) {
		// If the smaller array has only one element
		if (n == 1) {
			if (m == 1) {
				return mediaOfTwo(a[0], b[0]);
			}
			if (m % 2 == 1) {
				return mediaOfTwo(b[m / 2], mediaOfThree(a[0], b[m / 2 - 1], b[m / 2 + 1]));
			}
			return mediaOfThree(b[m / 2], b[m / 2 - 1], a[0]);
		}
		// If the smaller array has two elements
		if (n == 2) {
			if (m == 2) {
				return mediaOfFour(a[0], a[1], b[0], b[1]);
			}
			if (m % 2 == 1) {
				return mediaOfThree(b[m / 2], Math.max(a[0], b[m / 2 - 1]), Math.min(a[1], b[m / 2 + 1]));
			}
			return mediaOfFour(b[m / 2], b[m / 2 - 1], Math.max(a[0], b[m / 2 - 2]), Math.min(a[1], b[m / 2 + 1]));
		}
		int idxA = (n - 1) / 2;
		int idxB = (m - 1) / 2;

		/*
		 * if A[idxA] <= B[idxB], then median must exist in A[idxA....] and
		 * B[....idxB]
		 */
		if (a[idxA] <= b[idxB]) {
			int a1[] = new int[n - idxA];
			for (int i = idxA; i < n; i++) {
				a1[i - idxA] = a[i];
			}
			return findMedianSortedArrays(a1, n / 2 + 1, b, m - idxA);
		}

		/*
		 * if A[idxA] > B[idxB], then median must exist in A[...idxA] and
		 * B[idxB....]
		 */
		int b1[] = new int[m - idxA];
		for (int i = idxA; i < m; i++) {
			b1[i - idxA] = b[i];
		}
		return findMedianSortedArrays(a, n / 2 + 1, b1, m - idxA);
	}

	public static double mediaOfTwo(int a, int b) {
		return (a + b) / 2.0;
	}

	public static int mediaOfThree(int a, int b, int c) {
		return a + b + c - Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c));
	}

	public static double mediaOfFour(int a, int b, int c, int d) {
		return (a + b + c + d - Math.max(a, Math.max(b, Math.max(d, c))) - Math.min(a, Math.min(b, Math.min(d, c)))) / 2.0;
	}
}
