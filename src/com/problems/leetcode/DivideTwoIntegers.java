package com.problems.leetcode;

/**
 * Created by raja on 17/09/15.
 */
public class DivideTwoIntegers {

    public static void main(String[] args) {
        System.out.println(divide(-2147483648, 1));
    }

//    public static int divide(int dividend, int divisor) {
//
//        System.out.println(divisor ^ ((dividend ^ divisor) & (~(dividend < divisor))));
//        int n = Math.abs(dividend);
//        int d = Math.abs(divisor);
//        int q = 0;
//
//        while (n >= d) {
//            q++;
//            n -= d;
//        }
//
//        if ((dividend < 0) ^ (divisor < 0)) return -q;
//        return q;
//
//    }

    public static int divide(int dividend, int divisor) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        // Note: The Solution object is instantiated only once.
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        if(divisor==1){
            return dividend;
        }
        if(a< 0 || b<0){
            return Integer.MAX_VALUE;
        }
        int res = 0;
        int count=0;
        while (a >= b) {
            long c = b;
            for (int i = 0; a >= c; i++, c <<= 1) {
                a -= c;
                res += 1 << i;
                count ++;
            }
        }
        System.out.println(count);

        if(dividend < 0 && divisor>0){
            return -res;
        }

        if(dividend > 0 && divisor<0){
            return -res;
        }
        return res;
//        return ((dividend ^ divisor) >> 31)==1 ? (-res) : (res);
    }
}
