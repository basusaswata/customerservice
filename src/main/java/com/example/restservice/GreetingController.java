package com.example.restservice;

import java.security.Principal;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class GreetingController {

	private static final String template = "Hi, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	
    @RequestMapping(value = "/customer")
    public String user(Model model, Principal principal) {
       // UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
        return "customer service";
    }
}
