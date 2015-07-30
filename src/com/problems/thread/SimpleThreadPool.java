package com.problems.thread;

import java.util.concurrent.*;

/**
 * Created by raja on 01/07/15.
 */
public class SimpleThreadPool {
    public static void main(String[] args) {
        BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<Runnable>(2);
        ExecutorService executor = new ThreadPoolExecutor(2,3,1,TimeUnit.MINUTES,workQueue);
        for (int i = 0; i < 10; i++) {
            Runnable worker = new WorkerThread("" + i);
            executor.execute(worker);
        }
        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Finished all threads");
    }
}
