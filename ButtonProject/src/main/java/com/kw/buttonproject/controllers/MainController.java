package com.kw.buttonproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/demostuff")
public class MainController {

	@RequestMapping("/")
	public String index(
			Model model,
			HttpSession session) {
		
		session.setAttribute("count", 0);
		
		model.addAttribute("name", "Kaysee");
		
		return "index.jsp";
	}
	
	@RequestMapping("/other")
	public String other(HttpSession session) {
		
		//Integer count = (Integer) session.getAttribute("count");
		session.setAttribute("count", 10);
		
		return "index.jsp";
	}
	
	@RequestMapping("/wipeout")
	public String wipeout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	//===========================================
	// Working with POST Data / Separate JSP file
	//===========================================
	
	@RequestMapping("/form")
	public String form() {
		
		return "NewFile.jsp";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String process(
			@RequestParam(value="username") String username, 
			@RequestParam(value="password") String password,
			HttpSession session) {
		
		session.setAttribute("newName", username);
		session.setAttribute("pass", password);
		
		return "redirect:/form";
	}

	
}
