/**
 * 
 */
package com.problems.geeksforgeeks.arrays;

/**
 * http://www.geeksforgeeks.org/counting-inversions/
 * @author Raja Jain
 * 
 */
public class MergeSort {

	public static int mergeSort(int[] arr, int startIndex, int lastIndex) {
		int count=0;
		if (startIndex < lastIndex) {

			int middleIndex = (startIndex + lastIndex) / 2;
			count = mergeSort(arr, startIndex, middleIndex);
			count += mergeSort(arr, middleIndex + 1, lastIndex);
			count +=merge(arr, startIndex, middleIndex, lastIndex);
		}
		return count;
	}

	private static int merge(int[] arr, int startIndex, int middleIndex,
			int lastIndex) {
		int count=0;
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
				count =count + leftArrSize - i;
			}
		}
		return count;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[5];

		arr[0] = 2;
		arr[1] = 4;
		arr[2] = 1;
		arr[3] = 3;
		arr[4] = 5;
		System.out.println(mergeSort(arr, 0, 4));

//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
	}

}
