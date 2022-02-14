package com.kw.mvcforms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.mvcforms.models.Author;
import com.kw.mvcforms.repositories.AuthorRepository;

@Service
public class AuthorService {
    // adding the author repository as a dependency
	private final AuthorRepository authorRepo;
    
    public AuthorService(AuthorRepository authorRepo) {
        this.authorRepo = authorRepo;
    }
    
    // returns all the authors
    public List<Author> allAuthors() {
        return authorRepo.findAll();
    }
    // creates a author
    public Author createAuthor(Author a) {
        return authorRepo.save(a);
    }
    // retrieves a author
    public Author findAuthor(Long id) {
        Optional<Author> optionalAuthor = authorRepo.findById(id);
        if(optionalAuthor.isPresent()) {
            return optionalAuthor.get(); // return the retrieved information
        } else {
            return null;
        }
    }
    
    // edits/updates a author
    public Author updateAuthor(Author a) {
    	return authorRepo.save(a);
    }
    
    // delete a author
    public void deleteAuthor(Long id) {
    	authorRepo.deleteById(id);
    }
}