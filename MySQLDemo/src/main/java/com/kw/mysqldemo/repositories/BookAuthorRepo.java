package com.kw.mysqldemo.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.mysqldemo.models.BookAuthor;

@Repository
public interface BookAuthorRepo extends	CrudRepository<BookAuthor, Long> {

	BookAuthor save(BookAuthor ba);
	
}
