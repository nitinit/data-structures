package com.problems.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raja on 08/09/15.
 */
public class ProducerConsumerMainClass {

    public static void main(String[] args) {
        List<String> data = new ArrayList<String>(10);
        ProducerThread p = new ProducerThread(data);
        ConsumerThread c = new ConsumerThread(data);

        p.start();
        c.start();

    }
}
