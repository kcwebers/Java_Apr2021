package com.kw.demoday.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")
public class DaikichiController {
	
	@RequestMapping("/lotto/{num}")
	public String lotto(@PathVariable("num") Integer num) {	
		if(num % 2 == 0) {
			return "You selected the number: " + num + " and you won!";
		} else {
			return "You selected the number: " + num + " and you lost!";
		}
	}

}
