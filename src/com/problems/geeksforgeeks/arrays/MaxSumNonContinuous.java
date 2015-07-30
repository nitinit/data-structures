package com.problems.geeksforgeeks.arrays;

/**
 * Created by raja on 13/07/15.
 */
public class MaxSumNonContinuous {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 17, 3, 12, 29, 0, -25, 25, 28, 16, 16, 16, 11, -10};
        System.out.println(dp(arr));

    }

    public static int dp(int arr[]) {

        int maxArr[] = new int[arr.length];
        maxArr[0] = arr[0];
        maxArr[1] = Math.max(arr[0], arr[1]);

        int max = maxArr[1];
        for (int i = 2; i < arr.length; i++) {
            maxArr[i] = Math.max(maxArr[i - 1], maxArr[i - 2] + arr[i]);
            if (max < maxArr[i]) {
                max = maxArr[i];
            }
        }

        return max;
    }
}
