package com.kw.loginreg.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.loginreg.models.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

	// we can use this to see if a email exists in our database already!
	Optional<User> findByEmail(String email);
	
	List<User> findAll();
	
	void deleteById(Long id);
	
	User save(User x);
	
	Optional<User> findById(Long id);
	
}
