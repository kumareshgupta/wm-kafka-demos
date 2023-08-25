package com.unext.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class MessagePublisher {

	@Autowired
	private KafkaTemplate<String, String> template;
	
	public void sendMessage(String message) {
		template.send("welcome-topic", message);
		System.out.println("Message sent");
	}
}
