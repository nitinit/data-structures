package com.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raja on 09/08/15.
 */
public class FindPossibleWordsPhoneDigits {

    public static void main(String[] args) {

        List<String> words = printWords("234");

        for(String s : words){
          System.out.println(s);
        }

    }

    public static List<String> printWords(String digits) {
        List<String> output = new ArrayList<String>();
        String[] hash = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        printWordsUtil(digits, 0, output, digits.length(), hash, "");
        if(output.size()==1 && output.get(0)==""){
            return new ArrayList<String>();
        }
        return output;
    }

    public static void printWordsUtil(String digits, int currentDigit, List<String> output, int n, String[] hash, String out) {

        if (out.length() == n) {
            output.add(out);
            return;
        }

        int currentNumber = Integer.parseInt(digits.charAt(currentDigit) + "");
        for (int i = 0; i < hash[currentNumber].length(); i++) {

            out = out + hash[currentNumber].charAt(i);
            printWordsUtil(digits, currentDigit + 1, output, n, hash, out);
            out = out.substring(0,out.length()-1);
            if (currentNumber == 0 || currentNumber == 1) {
                return;
            }
        }

    }

}
