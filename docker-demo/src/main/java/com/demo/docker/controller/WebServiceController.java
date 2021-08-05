package com.demo.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/docker")
public class WebServiceController {

	@GetMapping("/hello")
	public String hello() {
		return "Hello Saneesh";
	}
}
