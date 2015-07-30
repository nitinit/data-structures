package com.kafka;

import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

/**
 * Created by raja on 15/06/15.
 */
public class Producer {

    public static void main(String[] args){

        long events = 15;
        Random rnd = new Random();

        Properties props = new Properties();
//        props.put("metadata.broker.list", "localhost:9092,localhost:9093,localhost:9094");
//        props.put("metadata.broker.list", "10.1.2.98:9092,10.1.2.49:9092");
        props.put("metadata.broker.list", "10.1.2.98:9092");
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("partitioner.class", "com.kafka.SimplePartitioner");
        props.put("request.required.acks", "1");

        ProducerConfig config = new ProducerConfig(props);

        kafka.javaapi.producer.Producer<String, String> producer = new kafka.javaapi.producer.Producer<String, String>(config);

//        for (long nEvents = 0; nEvents < events; nEvents++) {
//            long runtime = new Date().getTime();
//            String ip = "192.168.2." + rnd.nextInt(255);
//            String msg = runtime + ",www.example.com," + ip;
//            KeyedMessage<String, String> data = new KeyedMessage<String, String>("test.topic", ip, msg);
//            producer.send(data);
//        }
        for (long nEvents = 0; nEvents < events; nEvents++) {
            long runtime = new Date().getTime();
            String ip = System.getProperties().getProperty("ip","192.168.102.111");
            String msg = "producing message form ip "+ ip + " on zooKeeper 10.1.2.49 for topic test10";
            KeyedMessage<String, String> data = new KeyedMessage<String, String>("test10", ip, msg);
            producer.send(data);
        }
        producer.close();
    }
}
