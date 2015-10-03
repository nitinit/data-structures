package com.problems.general;

/**
 * https://www.hackerrank.com/contests/campus-code-jam/challenges/practice-question-1
 * https://github.com/algorhythms/HackerRankAlgorithms/blob/master/Almost%20Sorted.py
 * Created by raja on 04/09/15.
 */
public class AlmostSorted {

    public static void main(String[] args) {
        System.out.println(sort(new int[]{2, 1, 3}));
    }

    public static String sort(int[] a) {
        // find start
        int start = 0;
        int N = a.length;
        while (start + 1 < N && a[start] <= a[start + 1]) {
            start += 1;
        }


        // find test swap or reverse
        int end = start + 1;
        while (end + 1 < N && a[end] >= a[end + 1]) {
            end += 1;
        }

        int j = 0;
        int i = 0;
        if (end == start + 1) {  // swap
            // find the item to be swapped
            j = start + 1;
            while (j + 1 < N && a[j] < a[j + 1])
                j += 1;

            // not found
            if (j != start + 1 && j + 1 == N)  // test cases: [3, 1], [3, 1, 2]
                return "no";
            // test tailing
            i = j + 1;
            while (i + 1 < N)
                if (!(a[i] < a[i + 1]))
                    return "no";
            i += 1;

            if (j != start + 1) {
                j += 1;
            }
            return "yes\nswap" + start + 1 + " " + j + 1;
        } else {  // reverse
            // test tailing
            i = end + 1;
            while (i + 1 < N)
                if (!(a[i] < a[i + 1])) {
                    return "no";
                }
            i += 1;

            if (end + 1 < N && a[start] > a[end + 1])  // even though reversed
                return "no";

            return "yes\nreverse" + start + 1 + " " + end + 1;
        }
    }

}
