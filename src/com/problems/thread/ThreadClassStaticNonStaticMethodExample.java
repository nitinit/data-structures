package com.problems.thread;

/**
 * Created by raja on 25/07/15.
 */
public class ThreadClassStaticNonStaticMethodExample {

//    static ThreadClassStaticNonStaticMethodExample INSTANCE = null;
//
//    public static ThreadClassStaticNonStaticMethodExample getInstance(){
//        if(INSTANCE == null){
//            INSTANCE = new ThreadClassStaticNonStaticMethodExample();
//        }
//        return INSTANCE;
//    }

    public synchronized void print1()  {
        System.out.println("Inside Print1 processing thread" + Thread.currentThread());
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with Inside Print1 processing thread" + Thread.currentThread());
    }

    public synchronized void print2(){
        System.out.println("Inside Print2 processing thread" + Thread.currentThread());
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    public static synchronized void print3(){
        System.out.println("Inside Print3 processing thread" + Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with Inside Print3 processing thread" + Thread.currentThread());
    }

    public static synchronized void print4(){
        System.out.println("Inside Print4 processing thread" + Thread.currentThread());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with Inside Print4 processing thread" + Thread.currentThread());
    }
    public static void main(String[] args){
        ThreadClassStaticNonStaticMethodExample o = new ThreadClassStaticNonStaticMethodExample();

        Thread1 t1= new Thread1(o);

        Thread2 t2= new Thread2(o);

        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();

    }
}
