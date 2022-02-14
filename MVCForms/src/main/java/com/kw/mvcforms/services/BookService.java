package com.kw.mvcforms.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kw.mvcforms.models.Author;
import com.kw.mvcforms.models.Book;
import com.kw.mvcforms.repositories.BookRepository;

@Service
public class BookService {
    // adding the book repository as a dependency
	private final BookRepository bookRepository;
	private final AuthorService authorService;
    
    public BookService(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }
    
    // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
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
    
    // edits/updates a book
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
    
    public Book updateBook(Long id, String title, String desc, String lang, Integer numPages) {
    	Optional <Book> bookToUpdate = bookRepository.findById(id); // basically creates a temporary holder for this book
    	if(bookToUpdate != null) { // if the find by id came back successful
    		bookToUpdate.get().setTitle(title); // will retrieve info, then reset field to new values input
    		bookToUpdate.get().setDescription(desc);
    		bookToUpdate.get().setLanguage(lang);
    		bookToUpdate.get().setNumberOfPages(numPages);
    		
    		Book book = bookToUpdate.get(); // creates a book of the updates (takes it out of optional) so it can be saved
    		bookRepository.save(book);
    		
    		return book;
    	}
    	return null; // if not found, return null for now
    }

    
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    }
    
    public void createRelationship(Long bookId, Long authId) {
        // retrieve an instance of a category using another method in the service.
        Book thisBook = findBook(bookId);
        
        // retrieve an instance of a product using another method in the service.
        Author thisAuthor = authorService.findAuthor(authId);
        
        // add the product to this category's list of products
        thisBook.getAuthors().add(thisAuthor);
        
        // Save thisCategory, since you made changes to its product list.
        bookRepository.save(thisBook);
    }
    
}