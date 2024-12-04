package dev.ime.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.ime.service.ServiceClient;

@RestController
@RequestMapping("/cloud")
public class Controller {

	public final ServiceClient serviceClient;

	public Controller(ServiceClient serviceClient) {
		super();
		this.serviceClient = serviceClient;
	}

	@GetMapping("/sayHi")
	public ResponseEntity<String> sayHi(@RequestParam String name){
		
		String reply = serviceClient.sayHi(name);
		
		return ResponseEntity.ok(reply);
		
	}
	
}
