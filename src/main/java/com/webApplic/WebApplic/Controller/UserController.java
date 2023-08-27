package com.webApplic.WebApplic.Controller;

import com.webApplic.WebApplic.Exeption.ErrorException;
import com.webApplic.WebApplic.Records.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import com.webApplic.WebApplic.Exeption.ErrorException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @CrossOrigin()
    @PostMapping(path = "/login" , consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> loginUser(@RequestBody User user) throws ErrorException {
        try {
            if (user.password().equals("12345") && user.email().equals("mo@test.de")) {
                return new ResponseEntity<>( HttpStatus.OK);
            } else {
                throw new ErrorException("email or Password are false");
            }
        }catch (ErrorException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);}

    }
}