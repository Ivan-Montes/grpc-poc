package dev.ime.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.ime.service.ServiceClient;

@RestController
@RequestMapping("/api")
public class Controller {

	public final ServiceClient serviceClient;
	
	public Controller(ServiceClient serviceClient) {
		super();
		this.serviceClient = serviceClient;
	}

	@GetMapping("/hi1")
	public ResponseEntity<String> helloWorld(@RequestParam String name){
		
		String reply = serviceClient.helloWorld(name);
		
		return ResponseEntity.ok(reply);
	}
	

	@GetMapping("/hi2")
	public ResponseEntity<String> helloWorld2(@RequestParam String name){
		
		String reply = serviceClient.helloWorld2(name);

		return ResponseEntity.ok(reply);
	}

	@GetMapping("/bye")
	public ResponseEntity<String> goodbyeWorld(@RequestParam String name){
		
		String reply = serviceClient.goodbyeWorld(name);

		return ResponseEntity.ok(reply);
		
	}

	@GetMapping("/ays")
	public ResponseEntity<String> areYouSure(@RequestParam String name){
		
		String reply = serviceClient.areYouSure(name);

		return ResponseEntity.ok(reply);
		
	}
	
}
