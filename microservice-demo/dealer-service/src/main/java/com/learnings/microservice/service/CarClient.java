package com.learnings.microservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import com.learnings.microservice.dto.Car;

@FeignClient("car-service")
public interface CarClient {

	@GetMapping("/cars")
	@CrossOrigin
	CollectionModel<Car> readCars();

}
