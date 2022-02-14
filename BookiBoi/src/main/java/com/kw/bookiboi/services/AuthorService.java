package com.kw.bookiboi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.bookiboi.models.Author;
import com.kw.bookiboi.repositories.AuthorRepo;

@Service
public class AuthorService {
	private final AuthorRepo authRepo;
	
	public AuthorService(AuthorRepo authRepo) {
		this.authRepo = authRepo;
	}
	
	
	public List<Author> allAuthors() {
		return authRepo.findAll();
	}
	
	public Author findAuthor(Long id) {
        Optional<Author> optionalAuthor = authRepo.findById(id);
        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            return null;
        }
	}
	
	public Author saveAuthor(Author a) {
		return authRepo.save(a);
	}
	
}
