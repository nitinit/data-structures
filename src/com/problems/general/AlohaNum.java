package com.problems.general;

public class AlohaNum {

	public static void main(String[] args) {
	           System.out.println(findNextAlohaNumber(74));
	   }

	   private static String findNextAlohaNumber(int num) {
	       StringBuilder sb = new StringBuilder();
	       String num1 = num + "";
	       int carry = 0;
	       for (int i = num1.length() - 1; i >= 0; --i) {
	           int c = num1.charAt(i) - '0';
	           c += carry;
	           if (c < 4) {
	               sb.insert(0, 4);
	               carry = 0;
	           } else if (c >= 4 && c < 7) {
	               sb.insert(0, 7);
	               carry = 0;
	           } else {
	               sb.insert(0, 4);
	               carry = 1;
	           }
	       }
	       if (carry > 0) {
	           sb.insert(0, 4);
	       }
	       return sb.toString();
	   }
	}
