package com.kw.mysqldemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.mysqldemo.models.Author;
import com.kw.mysqldemo.repositories.AuthorRepo;


@Service
public class AuthorService {
	private final AuthorRepo authorRepo;
    public AuthorService(AuthorRepo authorRepo) {
        this.authorRepo = authorRepo;
    } 
    // returns all the authors
    public List<Author> allAuthors() {
        return authorRepo.findAll();
    }
    
    // saves a author (either to update or create new)
    public Author saveAuthor(Author a) {
        return authorRepo.save(a);
    }
    
    // retrieves a author
    public Author findAuthor(Long id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get();
        } else {
            return null;
        }
    }
    
    // delete author
    public void deleteAuthor(Long id) {
    	authorRepo.deleteById(id);
    }
}
