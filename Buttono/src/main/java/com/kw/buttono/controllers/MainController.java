package com.kw.buttono.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	@RequestMapping("/")
	public String index(
			HttpSession session,
			Model model) {
		
		String bgcolor = (String) session.getAttribute("bgcolor");
		if(bgcolor == null) {
			bgcolor = "light";
		}
		model.addAttribute("bgcolor", bgcolor);
		return "index.jsp";
	}
	
	@RequestMapping("/{color}")
	public String danger(
			HttpSession session,
			@PathVariable("color") String color
			) {
		session.setAttribute("bgcolor", color);
		return "redirect:/";
	}
	
	@RequestMapping("/clear")
	public String clearSession(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}
