package com.learnings.microservice.mq.dto;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;

@Data
@Component
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@id", scope = User.class)
public class User implements Serializable {

	private static final long serialVersionUID = -8592021834310383520L;
	private String userId;
	private String userName;

	public User() {
	}

	public User(String userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

}
