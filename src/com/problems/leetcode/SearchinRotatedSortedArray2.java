package com.problems.leetcode;

/**
 * Created by raja on 27/09/15.
 */
public class SearchinRotatedSortedArray2 {

    public static void main(String[] args) {

        int[] a = {5, 6, 7, 1, 2, 3, 4};

        System.out.println(search(a, 7));
        int[] b = {7, 1, 2, 3, 4};
        System.out.println(search(b, 1));

        int[] c = {7, 8, 9, 1};

        System.out.println(search(c, 1));

        int[] d = {7, 9, 10, 11, 1, 2, 3, 6};

        System.out.println(search(d, 9));

        int[] e = {7, 8, 9, 1, 6};

        System.out.println(search(e, 6));

        int[] f = {1, 3, 7, 8, 9};
        System.out.println(search(f, 2));

        int[] g = {1, 3};
        System.out.println(search(g, 0));

        int[] h = {1, 1, 3, 1};
        System.out.println(search(h, 3));

    }


    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return true;

            if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[left] > nums[mid]) {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                left++;
            }
        }

        return false;
    }
}
