package com.problems.leetcode;

import java.util.Stack;

/**
 * Created by raja on 14/09/15.
 */
public class ValidParentheses {

    public static void main(String[] args) {
        System.out.println(isValid("}"));
    }

    public static boolean isValid(String s) {

        int index = 0;
        Stack<Character> stack = new Stack<Character>();
//        stack.push(s.charAt(index));
//        index++;

        char c;
        while (s.length() > index) {

            char elem = s.charAt(index);

            switch (elem) {
                case '(':
                    stack.push(elem);
                    break;
                case ')':
                    if(stack.isEmpty()){
                        return false;
                    }
                    c = stack.pop();
                    if (c != '(') {
                        return false;
                    }
                    break;
                case '[':
                    stack.push(elem);
                    break;
                case ']':
                    if(stack.isEmpty()){
                        return false;
                    }
                    c = stack.pop();
                    if (c != '[') {
                        return false;
                    }
                    break;

                case '{':
                    stack.push(elem);
                    break;

                case '}':
                    if(stack.isEmpty()){
                        return false;
                    }
                    c = stack.pop();
                    if (c != '{') {
                        return false;
                    }
                    break;

            }

            index++;

        }

        return stack.isEmpty();
    }
}
