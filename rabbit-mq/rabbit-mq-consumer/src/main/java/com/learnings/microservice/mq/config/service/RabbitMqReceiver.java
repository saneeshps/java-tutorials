package com.learnings.microservice.mq.config.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.stereotype.Component;

import com.learnings.microservice.mq.dto.User;

@Component
public class RabbitMqReceiver {

	private static final Logger logger = LoggerFactory.getLogger(RabbitMqReceiver.class);

	public void configureRabbitListeners(RabbitListenerEndpointRegistrar rabbitListenerEndpointRegistrar) {
	}

	@RabbitListener(queues = "${spring.rabbitmq.queue}")
	public void receivedMessage(User user) {
		logger.info("User Details Received is.. " + user);
	}

}
