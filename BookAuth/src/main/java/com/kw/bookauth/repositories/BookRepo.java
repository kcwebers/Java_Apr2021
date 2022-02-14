package com.kw.bookauth.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.bookauth.models.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {
	// get all Books
	List<Book> findAll();
	// SELECT * FROM books;
	
	// get one Book based on Id
	Optional<Book> findById(Long id);
	// SELECT * FROM books WHERE id = #;
	
	// save Book
	// Book save(Book b);
	
	// delete Book by Id
	void deleteById(Long id);
	
}
