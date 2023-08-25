package com.unext.kafdemo;
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;


public class MessageSender {

    private static final String TOPIC = "demo-topic1";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    //private static final String BOOTSTRAP_SERVERS = "localhost:9093,localhost:9094,localhost:9095";

    public static void produce() {
        
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        //convert from byte[] to String
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        
        try (Producer<String, String> producer = new KafkaProducer<>(props)) {
            
            for (int i = 0;; i++) {
                String key = Integer.toString(1234);
                String message = "Messeage from Producer : Interesting - " + Integer.toString(1234);

                producer.send(new ProducerRecord<String, String>(TOPIC, 1, key, message)); 
                
                System.out.println("sent msg " + key);
                try {
                   
                    Thread.sleep(2000);
                } catch (Exception e) {
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Could not start producer: " + e);
        }
    }
}
