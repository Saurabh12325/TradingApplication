package com.Trading.Trading.Controller;

import com.Trading.Trading.Config.JwtTokenProvider;
import com.Trading.Trading.DTO.AuthResponse;
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
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRespository userRespository;


@PostMapping("/signUp")
public ResponseEntity<AuthResponse> register(@RequestBody UserEntity user) {
       UserEntity isEmailExist = userRespository.findByEmail(user.getEmail());
       if (isEmailExist != null) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
       }
        UserEntity savedUser = userRespository.save(user); // Just save directly
    Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = JwtTokenProvider.generateToken(authentication);

    AuthResponse res = new AuthResponse();
    res.setJwt(jwt);
    res.setStatus(true);
    res.setMessage("Registered Successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }
//
//    @PostMapping("/login")
//    public ResponseEntity<UserEntity> login(@RequestBody String Email, @RequestBody String Password) {
//
//    }

}



