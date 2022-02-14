package com.kw.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.beltreview.models.Trip;
import com.kw.beltreview.repositories.TripRepo;

@Service
public class TripService {
	final private TripRepo tripRepo;
	public TripService(TripRepo tripRepo) {
		this.tripRepo = tripRepo;
	}
	
	// find one record of Trip
    public Trip findTripById(Long id) {
    	Optional<Trip> u = tripRepo.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // find all records of Trip
    public List<Trip> findAllTrips() {
    	return tripRepo.findAll();
    }
    
    // delete one record of Trip
    public void deleteOneTrip(Long id) {
    	tripRepo.deleteById(id);
    }
    
    // save Trip (for either create or update)
    public Trip saveTrip(Trip t) {
    	return tripRepo.save(t);
    }
    
    public List<String> tripLocations() {
    	return tripRepo.locations();
    }
    
    public int tripByLocation(String x, String y) {
    	return tripRepo.changeLoc(x, y);
    }
	
	
}
