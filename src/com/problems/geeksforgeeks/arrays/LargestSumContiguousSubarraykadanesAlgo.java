package com.problems.geeksforgeeks.arrays;

public class LargestSumContiguousSubarraykadanesAlgo {

    public static void main(String[] args) {

        System.out.println(maxSubArraySum(new int[]{-1, 3, -3, 1, 2, -1, 2}, 7));
        System.out.println(maxSubArraySum(new int[]{-1, -3, -3, -11, -2, -1, -2}, 7));
        System.out.println(maxSubArraySum2(new int[]{-1, -3, -3, -11, -2, -1, -2}, 7));

        System.out.println(findIndexMaxSubArraySum(new int[]{1, 3, -3, 1, 2, -1, 2}, 7));
        System.out.println(findIndexMaxSubArraySum(new int[]{-1, 3, -3, 1, 2, -1, 2}, 7));
        System.out.println(findIndexMaxSubArraySum(new int[]{-1, -3, -3, -11, -2, -1, -2}, 7));
    }

    private static int maxSubArraySum(int a[], int size) {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        int i;
        for (i = 0; i < size; i++) {
            maxEndingHere = maxEndingHere + a[i];
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }
        }
        return maxSoFar;
    }

    private static int maxSubArraySum2(int a[], int size)
    {
        int maxSoFar = a[0], i;
        int curr_max = a[0];

        for (i = 1; i < size; i++)
        {
            curr_max = Math.max(a[i], curr_max + a[i]);
            maxSoFar = Math.max(maxSoFar, curr_max);
        }
        return maxSoFar;
    }

    /**
     * -1, 3, -3, 1, 2, -1, 2
     *
     * @param a
     * @param size
     * @return
     */
    private static int findIndexMaxSubArraySum(int a[], int size)
    {
        int maxSoFar = a[0], i;
        int curr_max = a[0];
        int start =0, end=0;

        for (i = 1; i < size; i++)
        {
            curr_max = Math.max(a[i], curr_max + a[i]);
            if(curr_max == a[i]){
                start = i;
                end = i;
            }
            maxSoFar = Math.max(maxSoFar, curr_max);
            if(maxSoFar == curr_max){
                end = i;
            }

        }
        System.out.println("Start Index: " + start + " , End Index : " + end);
        return maxSoFar;
    }

}
