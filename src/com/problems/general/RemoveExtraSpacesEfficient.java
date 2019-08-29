package com.problems.general;

public class RemoveExtraSpacesEfficient {

    public static void main(String[] args) {

        String s = "my    name is    mr    space           . is some         thing          wrong                               ?      no ";

        char[] charArray = s.toCharArray();


        //removing space in-place.
        int j = 0;
        int i = 0;
        for (; i < charArray.length && j < charArray.length; i++) {
            char cur = charArray[j];
            // No need to remove first space, so skipping the same.
            if (cur == ' ') {
                charArray[i] = charArray[j];
                i++;
                j++;
            }
            // check j must be less than size of string
            if (j >= charArray.length) {
                break;
            }
            cur = charArray[j];
            // now skip all continuous space.
            while (cur == ' ' && j + 1 < charArray.length) {
                j++;
                cur = charArray[j];
            }
            // now move the jth character to ith position(skipped all the space between i and j)
            charArray[i] = charArray[j];
            j++;
        }

        for (j = 0; j < i; j++) {
            System.out.print(charArray[j]);
        }
    }
}
