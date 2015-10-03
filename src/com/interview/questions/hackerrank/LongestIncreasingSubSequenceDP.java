package com.interview.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by raja on 02/10/15.
 */
public class LongestIncreasingSubSequenceDP {
    static final int mod = (int) 1e9 + 7;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int N = 0;
        try {
            line = br.readLine();
            N = Integer.parseInt(line);
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] arr1 = line.split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = Integer.parseInt(arr1[i]);
        }
        System.out.println(lis(arr, arr.length));

    }

    public static int lis(int arr[], int n) {

        int[] lis = new int[arr.length];

        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(arr[j]) <= Math.abs(arr[i]) && arr[j] * arr[i] < 0) {//&& lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    if (map.containsKey(lis[i])) {
                        map.put(lis[i], map.get(lis[i]) + 1);
                    } else {
                        map.put(lis[i], 1);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < lis[i])
                max = lis[i];
        }

        System.out.println(map.lastEntry() != null ? map.lastEntry().getKey() + " " + map.lastEntry().getValue() % mod : "0 0");
        return max;
    }

}
