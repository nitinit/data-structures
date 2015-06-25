package com.problems.geeksforgeeks.arrays;

/**
 * Created by raja on 25/06/15.
 */
public class MaximumAndMinimumInArray {

    public static void main(String[] args){
        int arr[] = {1000, 11, 445, 1, 3300, 3000};
        PairMinMax sol = find(arr,0,arr.length);
        System.out.println("Min : " + sol.min);
        System.out.println("Max : " + sol.max);

    }

    public static PairMinMax find(int arr[], int low, int high) {

        PairMinMax minMax = new PairMinMax();
        /* If there is only on element */
        if (low == high) {
            minMax.min = low;
            minMax.max = high;
            return minMax;
        }

         /* If there are two elements */
        if(high == low + 1){
            if (arr[low] > arr[high])
            {
                minMax.max = arr[low];
                minMax.min = arr[high];
            }
            else
            {
                minMax.max = arr[high];
                minMax.min = arr[low];
            }
            return minMax;
        }
        int mid = (low + high)/2;
        PairMinMax left = find(arr,low,mid);
        PairMinMax right = find(arr,mid+1, high);

        if(left.min < right.min){
            minMax.min = left.min;

        }else{
            minMax.min = right.min;
        }

        if(left.max >right.max){
            minMax.max = left.max;
        }else{
            minMax.max = right.max;
        }
        return minMax;
    }
}

class PairMinMax{
    int min;
    int max;
}
