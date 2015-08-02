package com.problems.leetcode;

/**
 * Created by raja on 02/08/15.
 */
public class ReverseAnInteger {

    public static void main(String[] args) {
        System.out.println(reverse(-1333333129));
    }

    private static int reverse(int x) {
        String s = Integer.valueOf(x).toString();
        String pre = "";
        if(x<0){
            pre = "-";
            s = s.substring(1);
        }
        String rev = new StringBuilder(s).reverse().toString();
        int reverse = 0;

        try{
            reverse = Integer.parseInt(pre+rev);
        }catch (Exception e){
            reverse = 0;
        }
        return reverse;
    }
}
