package com.interview.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by raja on 04/10/15.
 */
public class PromNight {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bfr.readLine());

        for (int i = 0; i < T; i++) {
            String[] line = bfr.readLine().split(" ");
            String[] boys = bfr.readLine().split(" ");
            int[] boys1 = new int[Integer.parseInt(line[0])];
            for (int j = 0; j < boys.length; j++) {
                boys1[j] = Integer.parseInt(boys[j]);
            }
            int[] girls1 = new int[Integer.parseInt(line[1])];
            String[] girls = bfr.readLine().split(" ");
            for (int j = 0; j < girls.length; j++) {
                girls1[j] = Integer.parseInt(girls[j]);
            }
            Arrays.sort(boys1);
            Arrays.sort(girls1);

            int j = 0;
            boolean flag = false;
            for (int b : boys1) {
                if (b <= girls1[j]) {
                    flag = true;
                    System.out.println("NO");
                    break;
                }
                j++;
            }
            if (!flag) {
                System.out.println("YES");
            }
        }
    }
}
