package com.problems.general;

/**
 * Created by raja on 27/09/15.
 */
public class Test1 {

    private static final int AB = 10;

    static String sayHello() {
        return a;
    }

    static String b = sayHello(); // a static method is called to assign value to b.
    // but its a has not been initialized yet.

    static String a = "hello";

    static String c = sayHello(); // assignes "hello" to variable c

    public static void main(String[] arg) throws Throwable {
        System.out.println(Test1.b); // prints null
        System.out.println(Test1.sayHello()); // prints "hello"
    }
}
