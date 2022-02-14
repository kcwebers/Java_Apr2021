package com.kw.bookiboi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kw.bookiboi.models.AuthorBook;

@Repository
public interface AuthorBookRepo extends CrudRepository<AuthorBook, Long> {

	
	
}
