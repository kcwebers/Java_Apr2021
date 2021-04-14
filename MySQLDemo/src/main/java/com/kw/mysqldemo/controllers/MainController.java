package com.kw.mysqldemo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kw.mysqldemo.models.Book;
import com.kw.mysqldemo.services.BookService;

@Controller
public class MainController {
	
    private final BookService bookService;
    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// "/allBooks"
	// call on service , which calls on repo to get all Books
	
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "/books/books.jsp";
    }
	
	// "/createBook"
	// call on repo for creating book, and pass back a complete book to save
    
    @RequestMapping("/books/new")
    public String newBook(Model model) {
    	model.addAttribute("book", new Book());
        return "/books/new.jsp";
    }
    
    @RequestMapping(value="/books", method=RequestMethod.POST)
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/books/new.jsp";
        } else {
            bookService.createBook(book);
            return "redirect:/books";
        }
    }
}
