package com.learnings.microservice.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.learnings.microservice.dto.Car;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<Car, Long> {

}
