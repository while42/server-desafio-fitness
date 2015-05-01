package br.com.while42.treinofitness.controller.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeWebController {
 
    @RequestMapping(method = RequestMethod.GET)
    public String index(Principal principal) {
        return "homeNotSignedIn";
    }
 
}
