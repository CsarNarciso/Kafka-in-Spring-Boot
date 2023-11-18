package com.cesar.Producer.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	public Controller(KafkaTemplate<Integer, String> kT) {
		
		this.kT = kT;
	}

	
	
	@RequestMapping("/send/{param}")
	public void send(@PathVariable String param){
		
		kT.send("topic1", param);
	}
	
	
	
	private KafkaTemplate<Integer, String> kT;
}
