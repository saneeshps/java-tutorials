package com.learnings.microservice.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learnings.microservice.mq.dto.User;
import com.learnings.microservice.mq.service.RabbitMqSender;

@RestController
@RequestMapping(value = "/api/v1/")
public class ProducerController {

	private RabbitMqSender rabbitMqSender;
	@Value("${app.message}")
	private String message;

	@Autowired
	public ProducerController(RabbitMqSender rabbitMqSender) {
		this.rabbitMqSender = rabbitMqSender;
	}

	@PostMapping(value = "user")
	public String publishUserDetails(@RequestBody User user) {
		rabbitMqSender.send(user);
		return message;
	}

}
