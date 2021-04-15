package com.kw.mysqldemo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.mysqldemo.models.Book;
import com.kw.mysqldemo.models.BookAuthor;
import com.kw.mysqldemo.repositories.BookAuthorRepo;
import com.kw.mysqldemo.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    private final BookAuthorRepo bookAuthorRepo;
    public BookService(BookRepository bookRepository, BookAuthorRepo bookAuthorRepo) {
        this.bookRepository = bookRepository;
        this.bookAuthorRepo = bookAuthorRepo;
    } 
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    
    // saves a book (either to update or create new)
    public Book saveBook(Book b) {
        return bookRepository.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // delete book
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
    
    // ===========================
    // create relationship b/w author and book
    // ===========================
    public BookAuthor saveRelationship(BookAuthor ba) {
    	return bookAuthorRepo.save(ba);
    }
    
}
