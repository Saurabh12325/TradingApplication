package com.Trading.Trading.Controller;

import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AuthController {
    @Autowired
    private UserRespository userRespository;


@PostMapping("/signUp")
public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
       UserEntity isEmailExist = userRespository.findByEmail(user.getEmail());
       if (isEmailExist != null) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
       }
        UserEntity savedUser = userRespository.save(user); // Just save directly
    Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
    SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
//
//    @PostMapping("/login")
//    public ResponseEntity<UserEntity> login(@RequestBody String Email, @RequestBody String Password) {
//
//    }

}



