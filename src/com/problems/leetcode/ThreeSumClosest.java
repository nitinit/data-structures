package com.problems.leetcode;

import java.util.*;

/**
 * Created by raja on 06/08/15.
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] arr = {0, 0, 2};
        System.out.println(find3Numbers(arr, arr.length, 1));
    }

    public int threeSumClosest(int[] nums, int target) {
        int min = Integer.MAX_VALUE;
        int result = 0;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int diff = Math.abs(sum - target);

                if(diff == 0) return sum;

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static int find3Numbers(int arr[], int arr_size, int target) {
        int l, r;
        int min = Integer.MAX_VALUE;
    /* Sort the elements */
        Arrays.sort(arr);

        int diff = 0;
        int sum = 0;
        int result = 0;
    /* Now fix the first element one by one and find the
       other two elements */
        for (int i = 0; i < arr_size - 1; i++) {

            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            l = i + 1; // index of the first element in the remaining elements
            r = arr_size - 1; // index of the last element
            while (l < r) {
                sum = arr[i] + arr[l] + arr[r];
                diff = Math.abs(sum - target);
                if (diff == 0) {
                    return sum;
                }
                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum <= target) {
                    l++;
                } else {
                    r--;
                }

            }
        }
        return result;
    }
}
