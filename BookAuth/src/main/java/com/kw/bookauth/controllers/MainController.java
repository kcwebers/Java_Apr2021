package com.kw.bookauth.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.kw.bookauth.models.Author;
import com.kw.bookauth.models.Book;
import com.kw.bookauth.services.AuthorService;
import com.kw.bookauth.services.BookService;

@Controller
public class MainController {
	
	private final BookService bookServ;
	private final AuthorService authServ;
	public MainController(BookService bookServ, AuthorService authServ) {
		this.bookServ = bookServ;
		this.authServ = authServ;
	}

	@GetMapping("/")
	public String index(Model model) {
		
		// send forward all books for table
		List<Book> books = bookServ.getAllBooks();
		model.addAttribute("allBooks", books);
		
		// send forward empty author model for create
		Author author = new Author();
		model.addAttribute("author", author);
		return "index.jsp";
	}
	
	@PostMapping("/newAuthor")
	public String newAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Book> books = bookServ.getAllBooks();
			model.addAttribute("allBooks", books);
			return "index.jsp";
		} 
		authServ.saveAuthor(author);
		return "redirect:/";
	}
	
	@GetMapping("/books/new")
	public String createBook(Model model) {
		
		// list of all authors to choose from
		List<Author> allAuthors = authServ.getAllAuthors();
		model.addAttribute("allAuthors", allAuthors);
		
		// empty book instance for the form
		Book book = new Book();
		model.addAttribute("book", book);
		
		return "newBook.jsp";
	}
	
	@PostMapping("/addBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if(result.hasErrors()) {
			List<Author> allAuthors = authServ.getAllAuthors();
			model.addAttribute("allAuthors", allAuthors);
			return "newBook.jsp";
		}
		bookServ.saveBook(book);
		return "redirect:/";
	}
	
	@GetMapping("/books/{id}/edit")
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		
		// list of all authors to choose from
		List<Author> allAuthors = authServ.getAllAuthors();
		model.addAttribute("allAuthors", allAuthors);
		
		// find the book that I want to edit based on id
		Book book = bookServ.getOneBook(bookId);
		model.addAttribute("book", book);
		
		return "editBook.jsp";
	}
	
	@PutMapping("/updateBook/{id}")
	public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model,
			@PathVariable("id") Long bookId) {
		if(result.hasErrors()) {
			List<Author> allAuthors = authServ.getAllAuthors();
			model.addAttribute("allAuthors", allAuthors);
			return "editBook.jsp";
		}
		bookServ.saveBook(book);
		return "redirect:/";
	}
	
	
}
