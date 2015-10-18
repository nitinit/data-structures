package com.problems.geeksforgeeks.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raja on 09/10/15.
 */
public class MinimumJumpRequiredToReachAtEndOfArray {

    public static void main(String[] args) {

        int[] a = {6, 0, 0, 2, 5, 2, 1, 0, 6};
//        int[] a = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};

//        int[] a = {1, 2, 3, 4, 5, 6};
//        int[] a = {1, 1, 1, 1, 1};
        int size = 0;
        System.out.println(minJumps(a, 0, a.length - 1));

        System.out.println(minJumps(a, a.length));


    }

    // Returns minimum number of jumps to reach arr[h] from arr[l]
    public static int minJumps(int arr[], int l, int length) {
        // Base case: when source and destination are same
        if (length == l)
            return 0;

        // When nothing is reachable from the given source
        if (arr[l] == 0)
            return Integer.MAX_VALUE;

        // Traverse through all the points reachable from arr[l]. Recursively
        // get the minimum number of jumps needed to reach arr[h] from these
        // reachable points.
        int min = Integer.MAX_VALUE;
        for (int i = l + 1; i <= length && i - l <= arr[l]; i++) {
            int jumps = minJumps(arr, i, length);
            if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
                min = jumps + 1;
            }
        }

        return min;
    }

    // Returns minimum number of jumps to reach arr[n-1] from arr[0]
    public static int minJumps(int arr[], int n) {
        int[] jumps = new int[n];  // jumps[n-1] will hold the result
        int i, j;

        if (n == 0 || arr[0] == 0)
            return Integer.MAX_VALUE;

        jumps[0] = 0;

        // Find the minimum number of jumps to reach arr[i]
        // from arr[0], and assign this value to jumps[i]
        for (i = 1; i < n; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (j = 0; j < i; j++) {
                if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
                    jumps[i] = Math.min(jumps[i], jumps[j] + 1);
                    break;
                }
            }
        }
        return jumps[n - 1];
    }
}
