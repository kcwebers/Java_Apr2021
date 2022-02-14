package com.kw.bookauth.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.bookauth.models.Author;
import com.kw.bookauth.repositories.AuthorRepo;

@Service
public class AuthorService {

	private final AuthorRepo authorRepo;
	public AuthorService(AuthorRepo authorRepo) {
		this.authorRepo = authorRepo;
	}
	
	public List<Author> getAllAuthors() {
		return authorRepo.findAll();
	}
	
	public Author saveAuthor(Author a) {
		return authorRepo.save(a);
	}
	
	public void deleteAuthor(Long id) {
		authorRepo.deleteById(id);
	}
	
	public Author getOneAuthor(Long id) {
		Optional<Author> optionalAuthor = authorRepo.findById(id);
		return optionalAuthor.isPresent() ? optionalAuthor.get() : null;
//		if(optionalAuthor.isPresent()) {
//			return optionalAuthor.get();
//		} else {
//			return null;
//		}
	}
}
