package com.kw.bookiboi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.bookiboi.models.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {

	List<Author> findAll();
	
	Optional<Author> findById(Long id);
	
	void deleteById(Long id);
	
	//	Author save(Author author);
	
}
