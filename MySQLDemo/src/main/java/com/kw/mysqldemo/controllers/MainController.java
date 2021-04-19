package com.kw.mysqldemo.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kw.mysqldemo.models.Author;
import com.kw.mysqldemo.models.Book;
import com.kw.mysqldemo.models.BookAuthor;
import com.kw.mysqldemo.services.AuthorService;
import com.kw.mysqldemo.services.BookService;

@Controller
public class MainController {
    private final BookService bookService;
    private final AuthorService authorService;
    public MainController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

// ======================================================================
//  INITIAL RENDER TO CHECK THAT SET UP WAS CORRECT
// ======================================================================
    
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
// ======================================================================
//  MAIN PAGE
// ======================================================================
	
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        
        List<Author> authors = authorService.allAuthors();
        model.addAttribute("authors", authors);
        return "/books/books.jsp";
    }
    
// ======================================================================
//  CREATE ROUTES FOR AUTHOR (render new form, process information submitted by form)
// ======================================================================
    
    @RequestMapping("/authors/new")
    public String newAuthor(Model model) {
    	model.addAttribute("author", new Author());
        return "/books/createAuth.jsp";
    }
    
    @RequestMapping(value="/authors/new", method=RequestMethod.POST)
    public String createAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/createAuth.jsp";
        } else {
            authorService.saveAuthor(author);
            return "redirect:/books";
        }
    }
	
// ======================================================================
//  CREATE ROUTES (render new form, process information submitted by form)
// ======================================================================
    
    @RequestMapping("/books/new")
    public String newBook(Model model) {
    	model.addAttribute("book", new Book());
    	List<Author> authors = authorService.allAuthors();
		model.addAttribute("authors", authors);
		 
        return "/books/new.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
        	bookService.saveBook(book);
            return "redirect:/books";
        }
    }
    
// ======================================================================
//  SHOW ROUTE FOR BOOK 
// ======================================================================
  
    @RequestMapping("/books/{id}/show")
    public String showBook(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("book", bookService.findBook(id));
    	
    	List<Author> authors = authorService.allAuthors();
    	model.addAttribute("authors", authors);
        return "/books/show.jsp";
    }
    
// ======================================================================
//  EDIT ROUTES (render edit form, process information submitted by form)
// ======================================================================
    
    @RequestMapping("/books/{id}")
    public String editBook(@PathVariable("id") Long book_id, Model model) {
    	model.addAttribute("book", bookService.findBook(book_id));
        return "/books/edit.jsp";
    }
    
    @RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/edit.jsp";
        } else {
            bookService.saveBook(book);
            return "redirect:/books";
        }
    }
    
// ======================================================================
//  DELETE ROUTE BOOK (delete single item based on the ID)
// ======================================================================
    
    @RequestMapping(value="/books/{id}/delete", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }
    
// ======================================================================
//  DELETE ROUTE Author (delete single item based on the ID)
// ======================================================================
    
    @RequestMapping(value="/author/{id}", method=RequestMethod.DELETE)
    public String destroyAuth(@PathVariable("id") Long id) {
        authorService.deleteAuthor(id);
        return "redirect:/books";
    }
    
// ======================================================================
//  CONNECT BOOK TO AUTHOR ROUTE
// ======================================================================
    
    @RequestMapping(value="/books/addAuthor", method=RequestMethod.POST)
    public String addAuthor(@RequestParam(value="book_id") Long book_id,
    		@RequestParam(value="author_id") Long author_id) {
    	
    	Author a = authorService.findAuthor(author_id);
    	Book b = bookService.findBook(book_id);
    	
    	BookAuthor ba = new BookAuthor(a, b);
    	
    	bookService.saveRelationship(ba);
    	
    	return "redirect:/books";
    }
 
}
