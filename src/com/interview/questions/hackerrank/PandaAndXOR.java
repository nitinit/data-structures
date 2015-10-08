package com.interview.questions.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by raja on 03/10/15.
 */
public class PandaAndXOR {

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bfr.readLine());
        String[] data = new String[T];

        for (int i = 0; i < T; i++) {
            String line = bfr.readLine();
            data[i] = line;
        }

        int[] freq = new int[128];
        int[] temp;

//        for (int i = 0; i < T; i++) {
//            freq[Integer.parseInt(data[i])] = 1;
//        }

        for (int i = 0; i < T; i++) {

            temp = new int[128];
            for (int j = 0; j < 128; j++) {
                if (freq[j] != 0) {
                    temp[j ^ Integer.parseInt(data[i])] = (temp[j ^ Integer.parseInt(data[i])] % (int) (Math.pow(10, 9) + 7) + freq[j] % (int) (Math.pow(10, 9) + 7)) % (int) (Math.pow(10, 9) + 7);
                }

            }
            for (int j = 0; j < 128; j++) {
                freq[j] = (freq[j] % (int) (Math.pow(10, 9) + 7) + temp[j] % (int) (Math.pow(10, 9) + 7)) % (int) (Math.pow(10, 9) + 7);
            }
            freq[Integer.parseInt(data[i])] = (freq[Integer.parseInt(data[i])] + 1) % (int) (Math.pow(10, 9) + 7);

        }

        double ans = 0;
        for (int j = 0; j < 128; j++) {
            ans = (ans % (Math.pow(10, 9) + 7) + ((freq[j] % (Math.pow(10, 9) + 7) * ((freq[j] % (Math.pow(10, 9) + 7) - 1))) / 2)) % (Math.pow(10, 9) + 7);
        }
//        for (int j = 0; j < 128; j++) {
//            ans = ans + ((freq[j] * (freq[j] - 1)) / 2.0);
//        }
        int j = (int) ans;
        System.out.println(j);
    }


}
