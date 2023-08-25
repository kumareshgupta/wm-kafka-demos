package com.unext.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.unext.model.User;

@Service
public class MessagePublisher {

	@Autowired
	private KafkaTemplate<String, Object> template;
	
	//sending string messages
	public void sendMessage(String message) {
		template.send("welcome-topic", message);
		System.out.println("Message sent");
	}
	
	//sending message in JSON format
	public void sendJsonMessage(User user) {
		template.send("user-topic", user);
	}
	
}
