package com.problems.leetcode;

/**
 * Created by raja on 05/08/15.
 */
public class LongestPrefixMatching {

    public static void main(String[] args) {

        PrefixTrie dict = new PrefixTrie();

        dict.insert("are");
        dict.insert("area");
        dict.insert("base");
        dict.insert("cat");
        dict.insert("cater");
        dict.insert("basement");

        String input = "caterer";
        System.out.print(input + ":   ");
        System.out.println(dict.longestPrefixMatching(input));

        input = "basement";
        System.out.print(input + ":   ");
        System.out.println(dict.longestPrefixMatching(input));

        input = "are";
        System.out.print(input + ":   ");
        System.out.println(dict.longestPrefixMatching(input));

        input = "arex";
        System.out.print(input + ":   ");
        System.out.println(dict.longestPrefixMatching(input));

        input = "basemexz";
        System.out.print(input + ":   ");
        System.out.println(dict.longestPrefixMatching(input));

        input = "xyz";
        System.out.print(input + ":   ");
        System.out.println(dict.longestPrefixMatching(input));

    }


}
