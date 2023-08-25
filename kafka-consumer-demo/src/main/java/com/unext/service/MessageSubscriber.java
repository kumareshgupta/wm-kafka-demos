package com.unext.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.unext.model.User;

@Service
public class MessageSubscriber {

	Logger log = LoggerFactory.getLogger(MessageSubscriber.class);
	
	@KafkaListener(topics = "welcome-topic", groupId = "wel-group-id1")
	public void consumeMessage(String message) {
		log.info("Message is being consumed : {}", message);
		
	}
	
	
	@KafkaListener(topics = "user-topic", groupId = "user-group-id1")
	public void consumeJsonMessage(User user) {
		log.info("Message is being consumed : {}", user);
		
	}
}
