package com.kw.firstspringproject.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController {
	// RequestParam Example
    @RequestMapping("/search")
    public String index(@RequestParam(value="q") String searchQuery, @RequestParam(value="q2") String searchQuery2) {
        return "You searched for: " + searchQuery + ", " + searchQuery2;
    }
    
    //PathVariable Example
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track, @PathVariable("module") String module, @PathVariable("lesson") String lesson){
    	return "Track: " + track + ", Module: " + module + ", Lesson: " + lesson;
    }
    
    @RequestMapping("/hello")
    public String helloOther() {
    	return "Hello to the rest of the Universe!!";
    }
    

}
