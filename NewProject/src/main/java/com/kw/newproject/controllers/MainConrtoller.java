package com.kw.newproject.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kw.newproject.services.MainService;

@RestController
public class MainConrtoller {
	private final MainService mainServ;
	
	public MainConrtoller(MainService mainServ) {
		this.mainServ = mainServ;
	}
	
	@RequestMapping("/")
	public String index() {
		System.out.println("++++++++++++Hello there");
		System.out.println("Goodbye there");
		String word = mainServ.serviceMethod();
		System.out.println(word);
		return "Hello there";
	}
	
}
