package com.interview.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.TreeMap;

/**
 * Created by raja on 02/10/15.
 */
public class LongestIncreasingSubSequence {
    static final int mod = (int) 1e9 + 7;
    private static int solution = 0;

    private static void find(int[] a, int i, int size, int[] sol, int currentSize, TreeMap<Integer, Integer> map) {

        if ((i % mod) < size) {
            if (currentSize % mod == 0) {
                sol[currentSize] = a[i];
                find(a, ++i, size, sol, currentSize + 1, map);
                sol[currentSize] = 0;
                find(a, i, size, sol, currentSize, map);
            } else {

                long lastElem = sol[currentSize - 1];
                long PositiveValueOfLastElem = lastElem < 0 ? -lastElem : lastElem;
                long PositiveValueOfLastArray = a[i] < 0 ? -a[i] : a[i];
                if (lastElem < PositiveValueOfLastArray && (lastElem * a[i] < 0)) {
                    solution++;
                    sol[currentSize] = a[i];
                    find(a, ++i, size, sol, currentSize + 1, map);
                    sol[currentSize] = 0;
                    find(a, i, size, sol, currentSize, map);
                } else {
                    find(a, ++i, size, sol, currentSize, map);
                }
            }

        } else {

            try {
                if (map.containsKey(currentSize)) {
                    map.put(currentSize, map.get(currentSize) + 1);
                } else {
                    map.put(currentSize, 1);
                }
            } catch (StackOverflowError e) {
                System.out.println(e);
            }
        }
    }


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

        LinkedList<Long> ll = new LinkedList<>();


        TreeMap<Integer, Integer> map = new TreeMap<>();
        find(arr, 0, arr.length, new int[N], 0, map);
        System.out.println(map.lastEntry() != null ? map.lastEntry().getKey() + " " + map.lastEntry().getValue() % mod : "0 0");

    }


}
