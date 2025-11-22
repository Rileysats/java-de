package com.kafka.main;

import com.kafka.consumer.Consumer;
import com.kafka.producer.Producer;

public class runner {
    public static void main(String[] args) throws InterruptedException {
        if (args[0].equals("producer")) {
            Producer.main(args);
        } else if (args[0].equals("consumer")) {
            Consumer.main(args);
        // } else if (args[0].equals("stream")) {
        //     Stream.main(args);
        } else {
            throw new IllegalArgumentException("Don't know how to do " + args[0]);
        }
    }
}