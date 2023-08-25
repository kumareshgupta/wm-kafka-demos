package com.unext.kafdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
	private static final Logger log = LoggerFactory.getLogger(MessageReceiver.class.getSimpleName());
    public static void main( String[] args )
    {
        log.info( "Hello World!" );
        //MessageSender.produce();
        //MessageReceiver.consume();
        
       // Thread consumerThread = new Thread(MessageReceiver::consume);
        Thread consumerThread = new Thread(()->MessageReceiver.consume());
        consumerThread.start();

        Thread producerThread = new Thread(MessageSender::produce);
        producerThread.start();
        
        
    }
}
