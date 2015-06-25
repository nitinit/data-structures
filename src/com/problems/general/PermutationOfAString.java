package com.problems.general;

/**
 * Created by raja on 22/06/15.
 */
public class PermutationOfAString {

    public static void main(String[] args){
        permute("ABC",0,2);
//        permutation("ABC");
    }

    public static void permute(String str, int currentIndex, int size) {
        int i;
        if (currentIndex == size)
            System.out.println(str);
        else {
            for (i = currentIndex; i <= size; i++) {

                str = swap(str, currentIndex, i);
                permute(str, currentIndex + 1, size);
                str = swap(str, currentIndex, i); //backtrack
            }
        }
    }

    private static String swap(String str, int index1, int index2) {
        StringBuilder sb = new StringBuilder(str);
        char s1 = str.charAt(index1);
        char s2 = str.charAt(index2);
        sb.setCharAt(index1, s2);
        sb.setCharAt(index2, s1);
        return sb.toString();
    }

    public static void permutation(String str) {
        permutation("", str);
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        else {
            for (int i = 0; i < n; i++)
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

}
