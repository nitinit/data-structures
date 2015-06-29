package com.problems.geeksforgeeks.arrays;

/**
 * http://www.geeksforgeeks.org/find-a-fixed-point-in-a-given-array/
 *
 * Created by raja on 28/06/15.
 */
public class FindAFixedPointInAGivenArray {

    public static void main(String[] args) {
        int arr[] = {-10, -1, 0, 2, 3, 3, 6, 6, 6, 50, 100};
        System.out.println(binarySearch(arr, 0, arr.length));
    }

    public static int binarySearch(int arr[], int low, int high) {
        if (high >= low) {
            int mid = (low + high) / 2;  /*low + (high - low)/2;*/
            if (mid == arr[mid]) {
                return mid;
            } else if (arr[mid] > 0 && arr[mid] < arr.length && arr[arr[mid]] == arr[mid]) {
                return arr[mid];
            } else if (mid > arr[mid]) {
                return binarySearch(arr, (mid + 1), high);
            } else {
                return binarySearch(arr, low, (mid - 1));
            }
        }

    /* Return -1 if there is no Fixed Point */
        return -1;
    }
}
