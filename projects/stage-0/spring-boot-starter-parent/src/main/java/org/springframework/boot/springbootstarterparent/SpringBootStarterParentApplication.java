package org.springframework.boot.springbootstarterparent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SpringBootStarterParentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterParentApplication.class, args);
	}

	@GetMapping("/")
	public String hello() {
		return "Hello Spring Native --- Powered by GraalVM";
	}
}
