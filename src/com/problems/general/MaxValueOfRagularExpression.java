package com.problems.general;

/**
 * Created by raja on 13/09/15.
 */
public class MaxValueOfRagularExpression {

    public static void main(String[] args) {
        int size=6;
        int arr[] = new int[size];

        arr[0]=2;
        arr[1]=1;
        arr[2]=1;
        arr[3]=1;
        arr[4]=1;
        arr[5]=2;

        // array elements are as follows :
        // A0     A1    A2      A3   A4      A5
        // 2      1      1       1     1      2

        int sol[] = new int[size];
        sol[0]=arr[0];
        for(int i = 1;i<size;i++){
            // sol[i] would contain the optimized value so far calculated.
            for(int k = 0;k<i ;k++) {
                // for each k , find sum of all array elements  i.e. k+1<=j<=i
                // and then calculate max of (sol[k] + sum or sum[k] * k )
                int sum =0;
                for (int j = k+1; j <= i; j++) {
                    sum += arr[j];
                }
                sol[i] = Math.max(Math.max(sol[i],(sol[k] + sum)), sol[k]*sum);
            }
        }
        // after processing above block , the sol array will look like :
        //SOL[0]  SOL[2]   SOL[2]   SOL[3]   SOL[4]   SOL[5]
        // 2        3       4        6          9     18
        System.out.println(sol[size-1]);
    }
}
