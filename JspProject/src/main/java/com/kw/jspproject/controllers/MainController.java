package com.kw.jspproject.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(
			Model model,
			HttpSession session
			) {
		
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			session.setAttribute("count", 0);
		} else {
			count = count + 1;
			session.setAttribute("count", count);
		}
		Integer c = (Integer) session.getAttribute("count");
		model.addAttribute("count", c);
		
		String name = (String) session.getAttribute("name");
		model.addAttribute("name", name);
		
//		model.addAttribute("name", "Rafaelangelo Turtle");
		ArrayList<String> pets = new ArrayList<String>();
		pets.add("Spike");
		pets.add("Mike");
		pets.add("Tyke");
		pets.add("Mary");
		model.addAttribute("pets", pets);
		return "index.jsp";
	}
	
	@RequestMapping("/{name}")
	public String addName(
			HttpSession session,
			@PathVariable("name") String name
			) {
		session.setAttribute("name", name);
		return "redirect:/";
	}
	
	// =====================================
	// Form Section
	// =====================================
	
	@RequestMapping("/form")
	public String form(
			HttpSession session,
			Model model) {
		String intro = (String) session.getAttribute("intro");
		System.out.println(intro);
		
		model.addAttribute("intro", intro);
		
		return "form.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(
			@RequestParam(value="name") String name,
			@RequestParam(value="email") String email,
			@RequestParam(value="password") String password,
			HttpSession session,
			RedirectAttributes flash
			) {
		
		flash.addFlashAttribute("message", "You added a new user!");
		
		String intro = "Hello, my name is " + name + " and my email is " + email + " and my password is " + password;
		session.setAttribute("intro", intro);
		
		return "redirect:/form";
	}
	

}
