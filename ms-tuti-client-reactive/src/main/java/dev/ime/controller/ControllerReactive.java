package dev.ime.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.ime.service.ServiceClientReactive;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/reactive")
public class ControllerReactive {

	public final ServiceClientReactive serviceClientReactive;

	public ControllerReactive(ServiceClientReactive serviceClientReactive) {
		super();
		this.serviceClientReactive = serviceClientReactive;
	}
	
	@GetMapping("/hi1")
	public Mono<String> helloWorld(@RequestParam String name){
		
		return serviceClientReactive.helloWorld(name);
		
	}

	@GetMapping("/ays")
	public Mono<String> areYouSure(@RequestParam String name){
		
		return serviceClientReactive.areYouSure(name);
		
	}
	
}
