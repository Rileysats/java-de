package com.streaming.main;

import com.streaming.consumer.Consumer;
import com.streaming.producer.Producer;

public class Runner {
    
    public static void main(String[] args) throws InterruptedException {
        if (args[0].equals("producer")) {
            System.out.println("Starting Producer");
            Producer.main(args);
        } else if (args[0].equals("consumer")) {
            System.out.println("Starting Consumer");
            Consumer.main(args);
        // } else if (args[0].equals("stream")) {
        //     Stream.main(args);
        } else {
            throw new IllegalArgumentException("Don't know how to do " + args[0]);
        }
    }
}