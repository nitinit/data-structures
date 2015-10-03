package com.interview.questions.hackerrank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by raja on 02/10/15.
 */
public class Solution1 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        String[] arr = new String[N];
        for (int i = 0; i < N; i++) {
            String l = br.readLine();
            if (l != null) {
                char[] chars = l.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                arr[i] = sorted.trim();
            }
        }

        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String a : arr) {
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + 1);
            } else {
                char[] chars = a.toCharArray();
                Arrays.sort(chars);
                String sorted = new String(chars);
                map.put(sorted, 1);
            }
        }
        int max = 0;
        int current = 0;
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            current = e.getValue();
            if (max < current) {
                max = current;
            }
        }

        System.out.println(max);

        switch (line){
            case "" :
                System.out.println();
        }


    }

    public static void method1() {

    }


}
