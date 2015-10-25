package com.problems.general;

/**
 * Created by raja on 25/10/15.
 */
public class RemoveExtraSpacesEfficient {

    public static void main(String[] args) {

        String s = "my    name is    mr    space           . is there         anything          wrong                               34.      3 ";

        char[] charArray = s.toCharArray();

        int j = 0;
        int i = 0;
        for (; i < charArray.length && j < charArray.length; i++) {
            char cur = charArray[j];
            if (cur == ' ') {
                charArray[i] = charArray[j];
                i++;
                j++;
            }
            if (j >= charArray.length) {
                break;
            }
            cur = charArray[j];
            while (cur == ' ' && j + 1 < charArray.length) {
                j++;
                cur = charArray[j];
            }
            charArray[i] = charArray[j];
            j++;
        }

        for (j = 0; j < i; j++) {
            System.out.print(charArray[j]);
        }
    }
}
