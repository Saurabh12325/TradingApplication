package com.Trading.Trading.Controller;

import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRespository userRespository;


@PostMapping("/signUp")
public ResponseEntity<UserEntity> register(@RequestBody UserEntity user) {
        UserEntity savedUser = userRespository.save(user); // Just save directly
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

}



