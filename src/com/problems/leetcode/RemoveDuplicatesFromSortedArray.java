package com.problems.leetcode;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * <p/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p/>
 * For example,
 * Given input array nums = [1,1,2],
 * <p/>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 * <p/>
 * Created by raja on 09/08/15.
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        System.out.println(removeDuplicates(new int[]{1, 1, 3, 4, 4, 4, 5}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int n = 1;
        for (int i = 1; i < nums.length; i++) {
            if (!(nums[i - 1] == nums[i])) {
                nums[n] = nums[i];
                n++;
            }
        }

        return n;
    }
}
