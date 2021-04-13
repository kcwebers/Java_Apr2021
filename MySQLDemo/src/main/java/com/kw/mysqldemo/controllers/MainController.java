package com.kw.mysqldemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	// "/allBooks"
	// call on service , which calls on repo to get all Books
	
	
	// "/createBook"
	// call on repo for creating book, and pass back a complete book to save
}
