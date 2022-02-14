package com.kw.newproject.services;

import org.springframework.stereotype.Service;

@Service
public class MainService {
	public String serviceMethod() {
		System.out.println("======================This is from the service");
		return "Okee dokee";
	}
}
