package com.problems.leetcode;

/**
 * http://www.geeksforgeeks.org/trapping-rain-water/
 * https://leetcode.com/problems/container-with-most-water/
 * Created by raja on 14/09/15.
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

        System.out.println(maxArea(new int[]{0,5,6,1,0,2}));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return max;
    }
}
