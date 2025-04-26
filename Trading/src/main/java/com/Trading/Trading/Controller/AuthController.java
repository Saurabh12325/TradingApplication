package com.Trading.Trading.Controller;

import com.Trading.Trading.Config.JwtTokenProvider;
import com.Trading.Trading.DTO.AuthResponse;
import com.Trading.Trading.Entity.TwoFactorOTP;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.UserRespository;
import com.Trading.Trading.Service.CustomUserDetailsService;
import com.Trading.Trading.Service.EmailService;
import com.Trading.Trading.Service.TwoFactorOtpService;
import com.Trading.Trading.Utils.OtpUtils;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserRespository userRespository;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

   @Autowired
   private OtpUtils otpUtils;
   @Autowired
   private TwoFactorOtpService twoFactorOtpService;
   @Autowired
   private EmailService emailService;

@PostMapping("/signUp")
public ResponseEntity<AuthResponse> register(@RequestBody UserEntity user) {
       UserEntity isEmailExist = userRespository.findByEmail(user.getEmail());
       if (isEmailExist != null) {
           throw new ResponseStatusException(HttpStatus.CONFLICT, "Email Already Exists");
       }
       userRespository.save(user); // Just save directly
    Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(),user.getPassword());
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = JwtTokenProvider.generateToken(authentication);

    AuthResponse res = new AuthResponse();
    res.setJwt(jwt);
    res.setStatus(true);
    res.setMessage("Registered Successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody UserEntity user) throws MessagingException {
        String userName = user.getEmail();
        String Password = user.getPassword();

        Authentication authentication = authenticate(userName,Password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = JwtTokenProvider.generateToken(authentication);

       UserEntity authUser = userRespository.findByEmail(userName);

        if(user.getTwoFactorAuth().isEnabled()){
            AuthResponse res = new AuthResponse();
            res.setJwt(jwt);
            res.setMessage("Two Factor Auth is Enabled");
            res.setTwoFactorAuthEnabled(true);
            String otp = otpUtils.generateOtp();
            TwoFactorOTP oldTwoFActorOtp = twoFactorOtpService.findByUserEntity(authUser.getId());
            if(oldTwoFActorOtp!=null){
                twoFactorOtpService.deleteTwoFactorOtp(oldTwoFActorOtp);
            }
            TwoFactorOTP newTwoFactorOtp =  twoFactorOtpService.createTwoFactorOtp(authUser,otp,jwt);
            emailService.sendVerificationOtpEmail(userName,otp);
            res.setSession(newTwoFactorOtp.getId());
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }

        AuthResponse res = new AuthResponse();
        res.setJwt(jwt);
        res.setStatus(true);
        res.setMessage("Login Successfully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    private Authentication authenticate(String userName, String password) {
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(userName);

        if(userDetails == null) {
            throw new BadCredentialsException("Invalid username or password");
        }
        if (!password.equals(userDetails.getPassword())) {
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
    }

    @PostMapping("/Two-factor/otp/{otp}")
public ResponseEntity<AuthResponse> verifySignInOtp(@PathVariable String otp,@RequestParam String id) throws Exception {
    TwoFactorOTP twoFactorOTP = twoFactorOtpService.findById(id);
    if(twoFactorOtpService.verifyTwoFactorOtp(twoFactorOTP,otp)){
       AuthResponse res = new AuthResponse();
       res.setMessage("Two factor authentication verify");
       res.setTwoFactorAuthEnabled(true);
       res.setJwt(twoFactorOTP.getJwt());
       return new ResponseEntity<>(res, HttpStatus.OK);
    }
    throw new Exception("Invalid Otp");

}

}



