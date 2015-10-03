package com.problems.thread;

/**
 * Created by raja on 25/07/15.
 */
public class Thread1 extends Thread{

    protected int i;

    public ThreadClassStaticNonStaticMethodExample obj;

    Thread1(ThreadClassStaticNonStaticMethodExample obj){
        this.obj=obj;
    }

   public Thread1(){

    }
    @Override
    public void run() {
       obj.print2();

    }

    protected void print(){

    }
}
