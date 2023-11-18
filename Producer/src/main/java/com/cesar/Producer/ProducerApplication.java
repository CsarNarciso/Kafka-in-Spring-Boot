package com.cesar.Producer;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class ProducerApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(ProducerApplication.class, args);
	}
	
	@Bean
	public NewTopic topic1() {
		
		return TopicBuilder.name("topic1")
				.partitions(1)
				.replicas(1)
				.build();
	}
}
