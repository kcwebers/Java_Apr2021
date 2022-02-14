package com.kw.mvcforms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.mvcforms.models.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

	List<Author> findAll();
	
	Optional<Author> findById(Long id);
	
	// save(Author) saves author to DB
	
	void deleteById(Long id);
}
