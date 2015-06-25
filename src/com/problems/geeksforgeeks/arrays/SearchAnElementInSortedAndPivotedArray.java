package com.problems.geeksforgeeks.arrays;

/**
 * Created by raja on 25/06/15.
 */
public class SearchAnElementInSortedAndPivotedArray {


    public static void main(String[] args){
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3 ,4};
        int arr_size = arr1.length;
        int no = 3;
        System.out.println(findPivot(arr1, 0, 8));

        int arr2[] = {2, 3, 4, 5, 6, 7, 8, 9, 10, 1};

        System.out.println(findPivot(arr2, 0, 9));
    }

    /* Function to get pivot. For array 3, 4, 5, 6, 1, 2 it will
   return 3(index 3). If array is not rotated at all, then it returns -1 */
    public static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low) return -1;
        if (high == low) return low;

        int mid = (low + high) / 2;   /*low + (high - low)/2;*/
        if (arr[mid] > arr[mid + 1])
            return mid;
        if (arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        else
            return findPivot(arr, mid + 1, high);
    }

}
