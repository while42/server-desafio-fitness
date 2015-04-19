package br.com.while42.treinofitness.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

	public LoginController() {
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void login() {
		
	}
	
}
