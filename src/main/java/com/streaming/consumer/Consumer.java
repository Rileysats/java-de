package com.streaming.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;

import java.util.Arrays;
import java.util.Properties;
import java.time.Duration;

public class Consumer {
    public static void main(final String[] args)  {
        final Properties props = new Properties();

        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "test-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);

        consumer.subscribe(Arrays.asList("test"));

        Duration duration = Duration.ofSeconds(1);
        
        int counter = 0;
        while (counter <= 1000) {
            ConsumerRecords<String, String> recs = consumer.poll(duration);
            if (recs.count() == 0) {
            } else {
                for (ConsumerRecord<String, String> rec : recs) {
                    System.out.printf("Recieved %s: %s%n", rec.key(), rec.value());
                }
            }
            counter++;
        }

        consumer.close();

    }
}
