package com.problems.thread;

import java.util.List;

/**
 * Created by raja on 08/09/15.
 */
public class ProducerThread extends Thread {

    private int count;
    private volatile List<String> data;

    public ProducerThread(List data) {
        this.data = data;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (data) {
                while (data.size() >= 10) {
                    try {
                        data.wait();
                    } catch (InterruptedException e) {

                    }
                }

            }
            synchronized (data) {
                System.out.println("Produced entity : " + count++);
                data.add(count + "");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }
                data.notify();
            }
        }
    }
}
