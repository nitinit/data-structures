package com.problems.general;

/**
 * Created by raja on 05/09/15.
 */
public class ThreadStart implements Runnable{


    @Override
    public void run() {
        System.out.println("run");
    }

    public static void main(String[] args) {

        Thread t = new Thread();
        t.start();

    }
}
