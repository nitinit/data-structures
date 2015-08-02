package com.problems.leetcode;

/**
 * Created by raja on 02/08/15.
 */
public class CheckNumberPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome(-13333331));
    }

    public static boolean isPalindrome(int x) {
        if(x<0){
            x= -1 * x;
        }
        int rev = 0, rmd;
        int num = x;
        while (x > 0) {
            rmd = x % 10;
            rev = rev * 10 + rmd;
            x = x / 10;
        }
        if (rev == num) {
            return true;
        }
        return false;

    }
}
