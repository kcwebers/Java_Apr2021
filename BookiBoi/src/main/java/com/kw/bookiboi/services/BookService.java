package com.kw.bookiboi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.bookiboi.models.Book;
import com.kw.bookiboi.repositories.BookRepo;

@Service
public class BookService {

	private final BookRepo bookRepo;
	
	public BookService(BookRepo bookRepo) {
		this.bookRepo = bookRepo;
	}

	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
//    public Book createBook(Book b) {
//    	return bookRepo.save(b);
//    }
//    
//    public Book updateBook(Book b) {
//    	return bookRepo.save(b);
//    }
    
    public Book saveBook(Book b) {
    	return bookRepo.save(b);
    }
    
    public void deleteBook(Long id) {
    	bookRepo.deleteById(id);
    }
	
	
}
