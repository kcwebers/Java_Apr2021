package com.kw.mysqldemo.controllers;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kw.mysqldemo.models.Book;
import com.kw.mysqldemo.services.AuthorService;
import com.kw.mysqldemo.services.BookService;

@Controller
public class FormController {
	
	private final BookService bookService;
	private final AuthorService authorService;

	public FormController(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}
	
	// ===============================================
	//	Regular Form Handling
	// ===============================================
	
	@GetMapping("/regularForm")
	public String regularForm() {
		return "/form/regularForm.jsp";
	}

	@RequestMapping(value="/regularForm/process", method=RequestMethod.POST)
	public String processRegularForm(
			@RequestParam("title") String title,
			@RequestParam("desc") String desc,
			@RequestParam("lang") String lang,
			@RequestParam("numba") int numba,
			HttpSession session,
			RedirectAttributes flash) {
		
		if(title.length() < 5) {
			flash.addFlashAttribute("terror", "Title must be at least 5 characters long");
		}
		if(desc.length() < 5) {
			flash.addFlashAttribute("derror", "Description must be at least 5 characters long");
		}
		if(lang.length() < 2) {
			flash.addFlashAttribute("lerror", "Language must be identified");
		}
		if(numba < 50) {
			System.out.println(numba);
			flash.addFlashAttribute("nerror", "Page count must be more than 50");
		}
		if(flash.getFlashAttributes().size() > 0) {
			return "redirect:/regularForm";
		} else {
		
//			Book b = new Book();
//			b.setTitle(title);
//			b.setDescription(desc);
//			b.setLanguage(lang);
//			b.setNumberOfPages(numba);
//			
			// OR
			
			Book b = new Book(title, desc, lang, numba);
			
			bookService.saveBook(b);
			session.setAttribute("title", b.getTitle());
			return "redirect:/success";
		}
	}


	// ===============================================
	//	Form : Form Handling
	// ===============================================
	
	@RequestMapping("/formForm")
	public String formForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("all_books", bookService.allBooks());
		return "/form/formForm.jsp";
	}
	
	@RequestMapping(value="/formForm/process", method=RequestMethod.POST)
	public String processFormForm(@Valid @ModelAttribute("book") Book book, BindingResult result, 
			HttpSession session,
			Model model) {
		if(result.hasErrors()) {
			model.addAttribute("all_books", bookService.allBooks());
			return "/form/formForm.jsp";
		} else {
			Book b = bookService.saveBook(book);
			session.setAttribute("bookId", b.getId());
			return "redirect:/success";
		}
	}
	
	// ===============================================
	//	Success Page
	// ===============================================
	
	@RequestMapping("/success")
	public String success(
			HttpSession session, 
			Model model) {
		Long bookId = (Long) session.getAttribute("bookId");		
		model.addAttribute("book", bookService.findBook(bookId));
		
		return "/form/success.jsp";
	}
	
	@RequestMapping("/clearSession")
	public String clearSession(
			HttpSession session) {
		session.invalidate();
		return "redirect:/formForm";
	}
	
	

}

