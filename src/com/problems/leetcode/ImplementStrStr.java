package com.problems.leetcode;

/**
 * Created by raja on 15/09/15.
 */
public class ImplementStrStr {

    public static void main(String[] args) {

        System.out.println(strStr("ABC", "B"));
    }

    /**
     * SubString search
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if ((haystack == null && needle == null) || haystack.equals(needle)) {
            return 0;
        }

        StringBuilder sb =new StringBuilder(haystack);
        return sb.indexOf(needle);

    }



}

