package com.interview.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by raja on 04/10/15.
 */
public class NumberOfRs {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            int maxSoFar = 0;
            int curr_max = 0;
            int start = 0, end = 0;
            int sol = 0;
            int carry = -1;
            for (int j = 0; j < s.length(); j++) {
                int c = 0;
                if ((s.charAt(j) + "").equals("K")) {
                    carry = 0;
                    curr_max += 1;
                    c = 1;
                } else {
                    sol++;
                    curr_max -= 1;
                    c = -1;
                }
                curr_max = Math.max(c, curr_max);
                if (curr_max == c) {
                    start = j;
                    end = j;
                }
                maxSoFar = Math.max(maxSoFar, curr_max);
                if (maxSoFar == curr_max) {
                    end = j;
                }

            }
//            System.out.println(start);
//            System.out.println(end);
//            System.out.println(maxSoFar);
            System.out.println(maxSoFar + sol + carry);
        }

    }
}
