package com.kw.bookiboi.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.bookiboi.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

	List<Book> findByTitleContaining(String title);
	
	List<Book> findAll();
	
	Optional<Book> findById(Long id);
	
	void deleteById(Long id);
	
	//	Book save(Book book);
	
}
