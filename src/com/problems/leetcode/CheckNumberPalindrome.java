package com.problems.leetcode;

/**
 * Created by raja on 02/08/15.
 */
public class CheckNumberPalindrome {


    public String s;

    public CheckNumberPalindrome(){

    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-13333331));
        System.out.println(isPalindrome("isPalindrome"));
//        CheckNumberPalindrome  a =  new CheckNumberPalindrome().f;

    }


    public static class f{
        f(){

        }

        static void print(){
        }
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

    static boolean isPalindrome(String args) {
        if(args.length() == 0 || args.length() == 1)
            return true;

        args= args.toUpperCase().trim();
        if(args.charAt(0) == args.charAt(args.length()-1))
            return isPalindrome(args.substring(1, args.length()-1));
        return false;

    }

}
