package com.problems.thread;

import java.util.List;

/**
 * Created by raja on 08/09/15.
 */
public class ConsumerThread extends Thread {

    private volatile List<String> data;

    public ConsumerThread(List data) {
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (data) {
                while (data.size() <= 0) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {

                    }
                }

            }

            synchronized (data) {
                System.out.println("Consumed entity : " + data.get(0));
                data.remove(0);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
                data.notify();
            }
        }

    }
}
