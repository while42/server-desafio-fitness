package br.com.while42.treinofitness.controller.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiControllerConfiguration.BASE_URL_API + "/login")
public class LoginController {

	@RequestMapping(method = RequestMethod.POST)
	public void login() {
		
	}
	
}
