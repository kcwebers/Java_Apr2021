package com.kw.buttonproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ButtonController {

	@RequestMapping("/")
	public String select(){
		return "button/select.jsp";
	}
	
	@RequestMapping("/results")
	public String results() {
		
		return "button/results.jsp";
	}
	
	
	// =======================================================
	// POST route to handle form submission
	// =======================================================
	
	//@RequestMapping(value="/process_click", method=RequestMethod.POST)
	@PostMapping("/process_click")
	public String process(
			@RequestParam(value="color") String color,
			HttpSession session) {
		
		if(color.equals("red")) {
			session.setAttribute("color", "danger");
			session.setAttribute("colorName", "Red");
		} else if(color.equals("yellow")) {
			session.setAttribute("color", "warning");
			session.setAttribute("colorName", "Yellow");
		} else if(color.equals("green")) {
			session.setAttribute("color", "success");
			session.setAttribute("colorName", "Green");
		}
		
		return "redirect:/results";
	}
	
	// =======================================================
	// Reset route
	// =======================================================

	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	
	
}
