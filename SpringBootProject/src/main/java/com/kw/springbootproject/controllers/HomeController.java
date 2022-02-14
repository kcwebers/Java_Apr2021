package com.kw.springbootproject.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class HomeController {

	@RequestMapping("")
	public String hello() {
		return "Hello World!";
	}
	
	@RequestMapping("/greet")
	public String greet(
			@RequestParam(value="name", required=false, defaultValue="DefaultyFace") String name,
			@RequestParam(value="age", required=false) String age,
			@RequestParam(value="pet", required=false) String pet
			) {
		return "Well, hi " + name + " and you are aged " + age + " with a pet " + pet;
	}
	
	@RequestMapping("/{name}/{age}/{pet}")
	public String greeting(
			@PathVariable("name") String name,
			@PathVariable("age") Integer age,
			@PathVariable("pet") String pet
			) {
		
		if(age < 18) {
			return "Sorry! Must be 18 to see mesasage!";
		}
		return "Well, hi " + name + "! You are " + age + " years old! and you have a pet named " + pet;
	}
	
	
	@RequestMapping("/hello")
	public String hellothere() {
		return "Hello there friendo!";
	}
	
	@RequestMapping("/goodbye")
	public String goodbye() {
		return "Farewell fine friend!";
	}
	

}
