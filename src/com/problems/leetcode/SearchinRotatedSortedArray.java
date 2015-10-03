package com.problems.leetcode;

/**
 * Created by raja on 27/09/15.
 */
public class SearchinRotatedSortedArray {

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
    }

    public boolean search2(int[] nums, int target) {
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

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid])
                return mid;

            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    public static int search1(int[] nums, int target) {

        int pivot = findPivot(nums, 0, nums.length - 1);

        if (pivot == -1) {
            return binarySearch(nums, 0, nums.length - 1, target);
        }
        if (nums[pivot] == target) {
            return pivot;
        }
        if (nums[0] <= target && target <= nums[pivot]) {
            return binarySearch(nums, 0, pivot, target);
        }
        if (pivot + 1 <= nums.length - 1 && nums[pivot + 1] <= target && target <= nums[nums.length - 1]) {
            return binarySearch(nums, pivot + 1, nums.length, target);
        }
        return -1;
    }


    public static int binarySearch(int arr[], int low, int high, int target) {
        int mid = (low + high) / 2;

        if (low > high) {
            return -1;
        }

        if (arr[mid] == target) {
            return mid;
        }
        if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, high, target);
        } else {
            return binarySearch(arr, low, mid - 1, target);
        }

    }

    public static int findPivot(int arr[], int low, int high) {
        // base cases
        if (high < low) return -1;
        if (high == low) return low;

        int mid = (low + high) / 2;   /*low + (high - low)/2;*/
        if (mid + 1 <= arr.length - 1 && arr[mid] > arr[mid + 1])
            return mid;
        if (mid - 1 >= 0 && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        else
            return findPivot(arr, mid + 1, high);
    }
}
