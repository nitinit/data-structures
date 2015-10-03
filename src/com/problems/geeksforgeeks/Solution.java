package com.problems.geeksforgeeks;

/**
 * Created by raja on 03/09/15.
 */
public class Solution {


    public static void main(String args[]){
        System.out.println(CalculateReverseSum(24,1));

    }

   public  static int CalculateReverseSum(int input1, int input2) {
        StringBuilder s1 = new StringBuilder(input1+"");
       StringBuilder s2 = new StringBuilder(input2+"");

       String s11 = s1.reverse().toString();
       String s22 = s2.reverse().toString();

       int i =  Integer.parseInt(s11) + Integer.parseInt(s22);

       StringBuilder s3 = new StringBuilder(i+"");

       return Integer.parseInt(s3.reverse().toString());
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
