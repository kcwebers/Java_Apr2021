package com.kw.firstspringproject.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class OtherController {

    @RequestMapping("/whalehello")
    public String hiya(Model model, HttpSession session) {
    	
    	//model.addAttribute("myName", "Hi! My name is Kaysee!");
    	//model.addAttribute("myAge", "My age is 27 y/o!");
    	
    	//session.setAttribute("count", 0);
    	
    	return "index.jsp";
    }
    
    @RequestMapping("/other")
    public String other(Model model, HttpSession session) {
    	
    	//model.addAttribute("myName", "Hi! My name is Spencer!");
    	//model.addAttribute("myAge", "My age is 34 y/o!");
    	
    	//Integer count = (Integer) session.getAttribute("count");
    	//count = count + 1;
    	//count ++;
    	//count += 1;
    	//session.setAttribute("count", count);
    	
    	return "index.jsp";
    	
    }
    

    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String login(
    		@RequestParam(value="username") String username, 
    		@RequestParam(value="password") String password,
    		HttpSession session, 
    		RedirectAttributes  redirectAttrbutes,
    		Model model) {
    	
    	session.setAttribute("name", username);
    	session.setAttribute("pass", password);
    	
    	model.addAttribute("label", "value at label");
    	
    	redirectAttrbutes.addFlashAttribute("success", "You created a user!");
    	
    	return "redirect:/other";
    }
   
}
