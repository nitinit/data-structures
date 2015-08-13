package com.problems.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raja on 09/08/15.
 */
public class GenerateParentheses {

    public static void main(String[] args) {

        for (String s : generateParenthesis(3)) {
            System.out.println(s);
        }

    }

    public static List<String> generateParenthesis(int n) {
        String[] s = new String[n * 2];
        List<String> list = new ArrayList<String>();
        printParenthesis(0, n, 0, 0, new String[n * 2], list);
        return list;
    }

    public static void printParenthesis(int pos, int n, int open, int close, String[] expression, List<String> list) {

        if (n == close) {
            String s1 = "";
            for (String s : expression) {
                s1 += s;
            }
            list.add(s1);
            return;
        } else {
            if (open > close) {
                expression[pos] = ")";
                printParenthesis(pos + 1, n, open, close + 1, expression, list);
            }
            if (open < n) {
                expression[pos] = "(";
                printParenthesis(pos + 1, n, open + 1, close, expression, list);
            }
        }

    }
}
