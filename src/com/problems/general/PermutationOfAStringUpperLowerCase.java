package com.problems.general;

/**
 * Created by raja on 23/10/15.
 */
public class PermutationOfAStringUpperLowerCase {

    public static void main(String[] args) {
        permute("ABC", 0, 2);
//        permutation("ABC");
    }

    public static void permute(String str, int currentIndex, int size) {
        int i;
        if (currentIndex > size)
            System.out.println(str);
//        else {
        for (i = currentIndex; i <= size; i++) {
            boolean flag = true;
            str = swap(str, currentIndex, i, flag);
            permute(str, currentIndex + 1, size);
            str = swap(str, currentIndex, i); //backtrack
            flag = false;
            str = swap(str, currentIndex, i, flag);
            permute(str, currentIndex + 1, size);
            str = swap(str, currentIndex, i); //backtrack

        }
//        }
    }

    private static String swap(String str, int index1, int index2) {
        StringBuilder sb = new StringBuilder(str);
        char s1 = str.charAt(index1);
        char s2 = str.charAt(index2);
        sb.setCharAt(index1, s2);
        sb.setCharAt(index2, s1);
        return sb.toString();
    }

    private static String swap(String str, int index1, int index2, boolean flag) {
        StringBuilder sb = new StringBuilder(str);
        char s1 = str.charAt(index1);
        char s2 = str.charAt(index2);

        if (flag) {
            sb.setCharAt(index1, s2);
            sb.setCharAt(index2, s1);
        } else {
            sb.setCharAt(index1, s2);
            if (s1 >= 65 && s1 < 92) {
                sb.setCharAt(index2, String.valueOf(s1).toLowerCase().charAt(0));
            } else {
                sb.setCharAt(index2, String.valueOf(s1).toUpperCase().charAt(0));
            }
        }
        return sb.toString();
    }
}
