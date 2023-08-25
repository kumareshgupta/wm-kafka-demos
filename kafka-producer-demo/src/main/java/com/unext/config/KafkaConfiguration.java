package com.unext.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfiguration {

	@Bean
	public NewTopic createTopic1() {
		return TopicBuilder.name("user-topic1")
				.partitions(3)
				.replicas(1)
				.build();
	}
	
	@Bean
	public NewTopic createTopic2() {
		return TopicBuilder.name("user-topic2")
				.partitions(4)
				.replicas(1)
				.build();
	}
}
