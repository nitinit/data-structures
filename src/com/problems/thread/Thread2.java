package com.problems.thread;

/**
 * Created by raja on 25/07/15.
 */
public class Thread2 extends Thread{

    public ThreadClassStaticNonStaticMethodExample obj;

    Thread2(ThreadClassStaticNonStaticMethodExample obj){
        this.obj=obj;
    }
    @Override
    public void run() {
        obj.print2();
    }
}
