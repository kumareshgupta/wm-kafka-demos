package com.unext.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unext.service.MessagePublisher;

@RestController
@RequestMapping("/producer")
public class MessageController {
	@Autowired
	private MessagePublisher publisher;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message) {
		publisher.sendMessage(message);
		return ResponseEntity.ok("Message is published successfully"); // message for Rest Client
	}
	
	
}
