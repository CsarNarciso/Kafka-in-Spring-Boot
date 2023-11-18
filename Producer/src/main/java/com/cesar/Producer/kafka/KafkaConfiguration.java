
package com.cesar.Producer.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfiguration {

	@Bean
	public Map<String, Object> producerConfigs(){
		
		Map<String, Object> configs = new HashMap<>();
		
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, IntegerSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		
		return configs;
	}
	
	@Bean
	public ProducerFactory<Integer, String> producerFactory(){
		
		return new DefaultKafkaProducerFactory<>( producerConfigs() );
	}
	
	@Bean
	public KafkaTemplate<Integer, String> kafkaTemplate(){
		
		return new KafkaTemplate<>( producerFactory() );
	}
	
}
