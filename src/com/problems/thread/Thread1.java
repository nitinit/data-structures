package com.problems.thread;

/**
 * Created by raja on 25/07/15.
 */
public class Thread1 extends Thread{

    public ThreadClassStaticNonStaticMethodExample obj;

    Thread1(ThreadClassStaticNonStaticMethodExample obj){
        this.obj=obj;
    }
    @Override
    public void run() {
       obj.print2();

    }
}
