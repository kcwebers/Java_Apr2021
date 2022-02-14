package com.kw.carproject.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.carproject.models.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
	
	Optional<Car> findById(Long id);
	
	List<Car> findAll();
	
	void deleteById(Long id);
	
//	Car save(Car c);

}
