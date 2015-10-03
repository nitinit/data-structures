package com.problems.general;

import java.util.HashSet;

/**
 * Created by raja on 17/08/15.
 */
public class HashSetTest {

    public static void main(String[] args) {

        HashSet<Demo> h = new HashSet<Demo>();
        System.out.println(h.add(new Demo("raja")));
        System.out.println(h.add(new Demo("raja1")));
        System.out.println(h.add(new Demo("raja2")));

        System.out.println(h.size());
    }
}


class Demo {

    public String name;

    Demo(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        Demo s = (Demo) obj;
        return s.name.equals(name);
    }
}
