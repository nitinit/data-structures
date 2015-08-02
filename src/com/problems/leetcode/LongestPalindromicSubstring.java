package com.problems.leetcode;

import com.sun.deploy.util.StringUtils;

/**
 * https://leetcode.com/problems/longest-palindromic-substring/
 * <p/>
 * Created by raja on 01/08/15.
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.out.println("Start at : " + time + "ms");
        System.out.println(longestPalindromicSubstring("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
        System.out.println("Ends at : "+ (System.currentTimeMillis() - time) +"ms");


        time = System.currentTimeMillis();
        System.out.println("Start at : " + time + "ms");
        System.out.println(longestPalindrome("barajarab"));
        System.out.println("Ends at : "+ (System.currentTimeMillis() - time) +"ms");
    }

    public static String longestPalindromicSubstring(String s) {

        if (s.isEmpty()) {
            return null;
        }

        if (s.length() == 1) {
            return s.charAt(0) + "";
        }
        int start = 0, end = 0;
        int max = 0;
        for (int i = 1; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++)

                if (ispalindrome(s, i, j)) {
                    int length = j - i + 1;
                    if (max < length) {
                        max = length;
                        end = j;
                        start = i;
                    }
                }
        }

        return s.substring(start - 1, end + 1);
    }

    public static boolean ispalindrome(String s, int l, int h) {
        while (h > l) {
            if (s.charAt(l++) != s.charAt(h--) )
                return false;
        }
        return true;
    }


    public static String longestPalindrome(String s) {
        int length = s.length();
        boolean table[][] = new boolean[length][length];
        int maxLength = 1;
        int start = 0;
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {

                if ((j - i <= 2 || table[i + 1][j - 1]) && s.charAt(i) == s.charAt(j)) {
                    table[i][j] = true;
                    if (maxLength < j - i + 1) {
                        start = i;
                        maxLength = j - i + 1;
                    }
                }
            }
        }

//        for(int l = 0; l<length;l++){
//            for(int m = 0; m<length;m++){
//                System.out.print(table[l][m] + "  ");
//            }
//            System.out.println();
//        }
        return s.substring(start, start + maxLength);
    }
}