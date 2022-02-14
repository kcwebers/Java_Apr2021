package com.kw.beltreview.repositories;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.beltreview.models.Trip;

@Repository
public interface TripRepo extends CrudRepository<Trip, Long> {
	
	List<Trip> findAll();
	
	@Query("SELECT t FROM Trip t")
	List<Trip> raddish();
	
	@Query("SELECT t.location FROM Trip t")
	List<String> locations();
	
	@Transactional
	@Modifying
	@Query("update Trip d set d.location = ?1 WHERE d.location = ?2")
	int changeLoc(String search, String change);
	
	void deleteById(Long id);
	
	Trip save(Trip x);
	
	Optional<Trip> findById(Long id);
}
