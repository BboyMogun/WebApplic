package com.webApplic.WebApplic;

import com.webApplic.WebApplic.Records.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@SpringBootApplication
@Configuration
public class WebApplicApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebApplicApplication.class, args);

	}
	@PostMapping(path = "/login" , consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> loginUser(@RequestBody User user) {
		if (user.password().equals("12345")  && user.email().equals("mo@test.de")) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
