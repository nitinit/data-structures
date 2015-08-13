package com.problems.general;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/
 *
 * Created by raja on 13/08/15.
 */
public class SubsetSumProblem {

    public static int[] sol = new int[5];
    public static int len = 0;

    public static void main(String[] args) {

        findSubSet(new int[]{7, 2, 8, -3, 5}, 4, 5);
    }

    public static void findSubSet(int a[], int size, int sum) {

        if (sum == 0) {
            for (int i = 0; i < len; i++) {
                System.out.print(" " + sol[i]);
            }
            System.out.println();
            return;
        }

        if (size < 0) {
            return;
        }
        if (sum < a[size]) {
            findSubSet(a, size - 1, sum);
        } else {
            sol[len++] = a[size];
            findSubSet(a, size - 1, sum - a[size]);
            len--;
            findSubSet(a, size - 1, sum);
        }
    }
}
