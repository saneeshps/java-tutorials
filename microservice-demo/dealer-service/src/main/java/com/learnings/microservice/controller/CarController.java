package com.learnings.microservice.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.learnings.microservice.dto.Car;
import com.learnings.microservice.service.CarClient;

@RestController
public class CarController {

	private final CarClient carClient;

	public CarController(CarClient carClient) {
		this.carClient = carClient;
	}

	private Collection<Car> fallback() {
		return new ArrayList<>();
	}

	@GetMapping("/cool-cars")
	@CrossOrigin
	@HystrixCommand(fallbackMethod = "fallback")
	public Collection<Car> goodCars() {
		return carClient.readCars().getContent().stream().filter(this::isCool).collect(Collectors.toList());
	}

	private boolean isCool(Car car) {
		return !car.getName().equals("AMC Gremlin") && !car.getName().equals("Triumph Stag")
				&& !car.getName().equals("Ford Pinto") && !car.getName().equals("Yugo GV");
	}
}
