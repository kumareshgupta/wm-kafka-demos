package com.unext.kafdemo;

import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageReceiver {

    private static final String TOPIC = "demo-topic1";
    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    //private static final String BOOTSTRAP_SERVERS = "localhost:9093,localhost:9094,localhost:9095";
    private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class.getSimpleName());

    public static void consume() {
       
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", BOOTSTRAP_SERVERS);
        
        props.setProperty("group.id", "my-group-id");
        //convert from String to byte[]
        props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        
        props.setProperty("enable.auto.commit", "true");
        props.setProperty("auto.commit.interval.ms", "1000");
        props.setProperty("auto.offset.reset", "earliest");

        
        try (KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {            
            consumer.subscribe(Arrays.asList(TOPIC));            
            while (true) {                
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(1000));
                for (ConsumerRecord<String, String> record : records) {                    
                	log.info("Key: " + record.key()+ ", Value: " +record.value());
                	log.info("Partition : " + record.partition()+ ", Offsets: "+ record.partition());
                }
            }
        }
    }

}
