package com.problems.leetcode;

import java.util.*;

/**
 * Created by raja on 02/08/15.
 */
public class ThreeSum {

    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        System.out.println("Start at : " + time + "ms");
//        int[] arr = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        int[] arr = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        List<List<Integer>> sol = threeSum(arr);

        for (List l : sol) {
            System.out.println(l.get(0) + " , " + l.get(1) + " , " + l.get(2));
        }
        System.out.println("Ends at : "+ (System.currentTimeMillis() - time) +"ms");
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        return find3Numbers(nums, nums.length, 0);
    }

    public static List<List<Integer>> find3Numbers(int arr[], int arr_size, int sum) {
        Set<List<Integer>> sol = new HashSet<List<Integer>>();
        int l, r;

    /* Sort the elements */
        Arrays.sort(arr);

    /* Now fix the first element one by one and find the
       other two elements */
        for (int i = 0; i < arr_size - 2; i++) {

            // To find the other two elements, start two index variables
            // from two corners of the array and move them toward each
            // other
            l = i + 1; // index of the first element in the remaining elements
            r = arr_size - 1; // index of the last element
            while (l < r) {
                if (arr[i] + arr[l] + arr[r] == sum) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(arr[i]);
                    list.add(arr[l]);
                    list.add(arr[r]);
                    sol.add(list);
                    System.out.println("Triplet is :" + arr[i] + " , " + arr[l] + " , " + arr[r]);
                    l++;
                    r--;
                } else if (arr[i] + arr[l] + arr[r] < sum) {
                    l++;
                } else {
                    // A[i] + A[l] + A[r] > sum
                    r--;
                }
            }
        }
        List<List<Integer>> solution = new ArrayList<List<Integer>>();
        for(List<Integer> s1 : sol){
                solution.add(s1);
        }
        // If we reach here, then no triplet was found
        return solution;
    }
}
