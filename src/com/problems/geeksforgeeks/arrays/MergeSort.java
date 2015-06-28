/**
 * 
 */
package com.problems.geeksforgeeks.arrays;

/**
 * @author Raja Jain
 * 
 */
public class MergeSort {

	public static void mergeSort(int[] arr, int startIndex, int lastIndex) {

		if (startIndex < lastIndex) {

			int middleIndex = (startIndex + lastIndex) / 2;
			mergeSort(arr, startIndex, middleIndex);
			mergeSort(arr, middleIndex + 1, lastIndex);
			merge(arr, startIndex, middleIndex, lastIndex);
		}
	}

	private static void merge(int[] arr, int startIndex, int middleIndex,
			int lastIndex) {

		int leftArrSize = middleIndex - startIndex + 1;
		int rightArrSize = lastIndex - middleIndex;
		int[] left = new int[leftArrSize+1];
		int[] right = new int[rightArrSize+1];
		for (int i = 0; i < leftArrSize; i++) {
			left[i] = arr[startIndex + i];
		}

		for (int i = 0; i < rightArrSize; i++) {
			right[i] = arr[middleIndex + i + 1];
		}
		left[leftArrSize] = 111111;
		right[rightArrSize]=111111;

		int i = 0, j = 0;

		for (int k = startIndex; k <= lastIndex; k++) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[10];

		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 2;
		arr[3] = 3;
		arr[4] = 8;
		arr[5] = 45;
		arr[6] = 7;
		arr[7] = 9;
		arr[8] = 40;
		arr[9] = 10;
		mergeSort(arr, 0, 9);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}
