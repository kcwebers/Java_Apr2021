package com.kw.demoday.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/omikuji")
public class OmikujiController {
	
	@RequestMapping("/")
	public String index() {
		
		return "index.jsp";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(
			@RequestParam(value="firstName") String firstName,
			@RequestParam(value="age") Integer age,
			HttpSession session) {
		
		session.setAttribute("firstName", firstName);
		session.setAttribute("age", age);

		return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/show")
	public String show(
			HttpSession session,
			Model model) {
		
		// get session attributes
		String firstName = (String) session.getAttribute("firstName");
		// assign to variables
		
		// staging info to the domain model, so we can access it in jsp
		model.addAttribute("zebra", firstName);
		
		return "show.jsp";
	}

}
