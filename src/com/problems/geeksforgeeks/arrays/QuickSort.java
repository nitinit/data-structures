/**
 * 
 */
package com.problems.geeksforgeeks.arrays;

/**
 * @author Raja Jain
 * 
 */
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 int[] arr = { 4, 1, 3, 2, 16, 9, 7, 14,  10,8 };
//		int[] arr = { 2, 8, 7, 1, 3, 5, 6, 4 };

		quickSort(arr, 0, arr.length-1);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}

	}

	private static void quickSort(int[] arr, int p, int length) {
		if (p < length) {
			int q = partition(arr, p, length);
			quickSort(arr, p, q - 1);
			quickSort(arr, q + 1, length);
		}

	}

	private static int partition(int[] arr, int p, int length) {
		int pivot = arr[length];
		int i = p - 1;

		for (int j = p; j < length; j++) {
			if (arr[j] <= pivot) {
				i++;
				int temp = arr[j];
				arr[j] = arr[i];
				arr[i] = temp;
			}
		}
		int temp = arr[i + 1];
		arr[i + 1] = arr[length];
		arr[length] = temp;
		return i + 1;
	}

}
