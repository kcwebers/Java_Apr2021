package com.kw.mvcforms.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.mvcforms.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	
	List<Book> findAll();

	// this method find a book by their description
	List<Book> findByDescriptionContaining(String search);

	// this method counts how many titles contain a certain string
	Long countByTitleContaining(String search);

	// this method deletes a book that starts with a specific title
	Long deleteByTitleStartingWith(String search);
	
	Optional<Book> findById(Long id);
	
	void deleteById(Long id); // output type is void b/c nothing returned after a deletion
		
}
