package br.com.while42.treinofitness.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.while42.treinofitness.model.Status;

@RestController
@RequestMapping("/status")
public class StatusController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Status> status() {
		return new ResponseEntity<Status>(new Status(), HttpStatus.OK);
	}
}
