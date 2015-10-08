package com.interview.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by raja on 04/10/15.
 */
public class Dhoom4 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        String[] keyvalue = bfr.readLine().split(" ");
        int ownerkey = Integer.parseInt(keyvalue[0]);
        int reqKey = Integer.parseInt(keyvalue[1]);
        int T = Integer.parseInt(bfr.readLine());

        String[] keysStringArray = bfr.readLine().split(" ");
        int[] keys = new int[T];
        for (int i = 0; i < T; i++) {
            keys[i] = Integer.parseInt(keysStringArray[i]);
        }

        int[] ans = new int[100005];
        for (int i = 0; i < 100005; i++) {
            ans[i] = -1;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.add(ownerkey);
        ans[ownerkey] = 0;
        while (!queue.isEmpty()) {
            int val = queue.poll();

            if (val == reqKey) {
                break;
            }
            for (int i = 0; i < T; i++) {
                long newKey = keys[i];
                int to = (int) ((newKey * val) % 100000);
                if (ans[to] == -1) {
                    ans[to] = ans[val] + 1;
                    queue.add(to);
                }
            }
        }

        System.out.println(ans[reqKey]);

    }
}
