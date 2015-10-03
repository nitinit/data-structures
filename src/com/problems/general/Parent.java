package com.problems.general;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raja on 04/09/15.
 */
public class Parent {

    public void print() throws Exception{
        System.out.println("Parent");
    }

    public static void main(String[] args) {
    List<Parent> p = new ArrayList<Parent>();
        p.add(new Parent());
        p.add(new Child());

    }
}


class Child extends Parent{
    public void print() throws IndexOutOfBoundsException{
        System.out.println("Child");
    }
}
