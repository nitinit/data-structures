package com.problems.leetcode;

/**
 * Created by raja on 14/09/15.
 */
public class RemoveElement {

    public static void main(String[] args) {

        System.out.println(removeElement(new int[]{3,4,4},7));
    }

    public static int removeElement(int[] nums, int val) {

        if(nums.length==0){
            return 0;
        }
        int end = nums.length - 1;

        boolean val1 =false;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == val && i <= end) {
                while (nums[end] == val ) {
                    if(i >= end){
                        return i;
                    }
                    end--;
                }
                int temp = nums[i];
                nums[i] = nums[end];
                nums[end] = temp;
                val1 =true;
            }
        }
        return val1  ? end : end+1;
    }
}
