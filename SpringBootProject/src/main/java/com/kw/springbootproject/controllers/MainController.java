package com.kw.springbootproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/jsp")
	public String jsp() {
		return "home.jsp";
	}
	
	

}
