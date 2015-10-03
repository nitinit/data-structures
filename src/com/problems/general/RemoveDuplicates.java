package com.problems.general;

/**
 * Created by raja on 26/09/15.
 */
public class RemoveDuplicates {

    public static void main(String[] args) {

        int a[] = new int[]{1, 1, 1, 2, 3, 3, 3, 3, 4, 5, 5, 6, 6, 7};
        System.out.println(removeDuplicates2(a));
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static int removeDuplicates(int[] A) {
        if (A.length <= 2)
            return A.length;

        int prev = 0; // point to previous
        int curr = 1; // point to current

        while (curr < A.length) {
            if (A[curr] == A[prev]) {//&& A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }

        return prev + 1;
    }

    public static int removeDuplicates2(int[] A) {
        if (A.length <= 2)
            return A.length;

        int prev = 1; // point to previous
        int curr = 2; // point to current

        while (curr < A.length) {
            if (A[curr] == A[prev] && A[curr] == A[prev - 1]) {
                curr++;
            } else {
                prev++;
                A[prev] = A[curr];
                curr++;
            }
        }

        return prev + 1;
    }
}
