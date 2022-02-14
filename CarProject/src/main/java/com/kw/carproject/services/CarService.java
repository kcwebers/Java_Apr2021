package com.kw.carproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.carproject.models.Car;
import com.kw.carproject.repositories.CarRepository;

@Service
public class CarService {
	
	private final CarRepository carRepo;
	public CarService(CarRepository carRepo) {
		this.carRepo = carRepo;
	}
	
	public Car saveCar(Car c) {
		return carRepo.save(c);
	}
	
	public List<Car> getAllCars() {
		return carRepo.findAll();
	}
	
	public Car findOneCar(Long id) {
		Optional<Car> optionalCar = carRepo.findById(id);
		if(optionalCar.isPresent()) {
			return optionalCar.get();
		} else {
			return null;
		}
	}
	
	public void deleteCar(Long id) {
		carRepo.deleteById(id);
	}

}
