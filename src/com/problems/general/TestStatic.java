package com.problems.general;

/**
 * Created by raja on 28/09/15.
 */
public class TestStatic {

    static{
        System.out.println("print static block");
    }

    static String sayHello()  {
        return a;
    }

    static String b = sayHello(); // a static method is called to assign value to b.
    // but its a has not been initialized yet.

    static String c = sayHello(); // assignes "hello" to variable c

    static String a = "hello";

    public static void main(String[] arg) throws Throwable {
        TestStatic.a="A";
        System.out.println("SAY HELLO : " + TestStatic.sayHello()); // prints "hello"
        System.out.println("B : " + TestStatic.b); // prints null
        System.out.println(TestStatic.sayHello()); // prints "hello"
        System.out.println("C = " + TestStatic.c);
    }
}
