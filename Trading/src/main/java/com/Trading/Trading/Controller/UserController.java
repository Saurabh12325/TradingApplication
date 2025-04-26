package com.Trading.Trading.Controller;

import com.Trading.Trading.Domain.VerificationType;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Service.EmailService;
import com.Trading.Trading.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService   emailService;


    @GetMapping("/api/users/profile")
    public ResponseEntity<UserEntity> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception {
        UserEntity user = userService.findUserProfileByJwt(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/api/users/verificaton/{verificationType}/send-otp")
    public ResponseEntity<UserEntity> sendVerificationOtp(@RequestHeader("Authorization") String jwt, @PathVariable VerificationType verificationType) throws Exception {
        UserEntity user = userService.findUserProfileByJwt(jwt);

        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    @PatchMapping("/api/users/enable-two-factor/verify-otp/{otp}")
    public ResponseEntity<UserEntity> enabdleTwoFactorAuthentication(@RequestHeader("Authorization") String jwt) throws Exception {
        UserEntity user = userService.findUserProfileByJwt(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
