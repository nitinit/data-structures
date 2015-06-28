package com.problems.geeksforgeeks.arrays;

/**
 * https://owlerscode.wordpress.com/2015/06/19/maximum-sum-such-that-no-two-elements-are-adjacent/
 * <p/>
 * Created by raja on 27/06/15.
 */
public class MaxSumNoTwoElementsAdjacent {

    public static void main(String args[]) {
//        int []a = { 3 ,2 ,5 ,10 ,7};
        int[] a = {3, 2, 7, 10};
        int[] sum = new int[a.length];
        sum[0] = a[0];
        sum[1] = Math.max(a[0], a[1]);

        for (int i = 2; i < a.length; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + a[i]);
            sum[i] = Math.max(sum[i], a[i]);    //if array contains negative element than array[i] is also to be considered
        }
        System.out.println(sum[a.length - 1]);
    }
}
