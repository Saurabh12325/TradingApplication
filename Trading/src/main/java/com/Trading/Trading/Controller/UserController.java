package com.Trading.Trading.Controller;

import com.Trading.Trading.DTO.ApiResponse;
import com.Trading.Trading.DTO.AuthResponse;
import com.Trading.Trading.DTO.ForgotPasswordTokenRequest;
import com.Trading.Trading.DTO.ResetPasswordRequest;
import com.Trading.Trading.Domain.VerificationType;
import com.Trading.Trading.Entity.ForgotPasswordToken;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Entity.VerificationCode;
import com.Trading.Trading.Service.EmailService;
import com.Trading.Trading.Service.ForgotPasswordService;
import com.Trading.Trading.Service.UserService;
import com.Trading.Trading.Service.VerificationCodeService;
import com.Trading.Trading.Utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController

public class UserController {
    @Autowired
    private ForgotPasswordService forgotPasswordService;
    @Autowired
    private UserService userService;
    @Autowired
    private EmailService emailService;
    @Autowired
    private VerificationCodeService verificationCodeService;


    @GetMapping("/api/users/profile")
    public ResponseEntity<UserEntity> getUserProfile(@RequestHeader("Authorization") String jwt) throws Exception {
        UserEntity user = userService.findUserProfileByJwt(jwt);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/api/users/verificaton/{verificationType}/send-otp")
    public ResponseEntity<String> sendVerificationOtp(@RequestHeader("Authorization") String jwt, @PathVariable VerificationType verificationType) throws Exception {
        UserEntity user = userService.findUserProfileByJwt(jwt);
        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUser(user.getId());
        if (verificationCode != null) {
            verificationCode = verificationCodeService.sendVerificationCode(user, verificationType);
        }
        if (verificationType.equals(VerificationType.EMAIL)) {
            emailService.sendVerificationOtpEmail(user.getEmail(), verificationCode.getOtp());

        }

        return new ResponseEntity<>("Verification Otp Sent Successful", HttpStatus.OK);
    }

    @PatchMapping("/api/users/enable-two-factor/verify-otp/{otp}")
    public ResponseEntity<UserEntity> enableTwoFactorAuthentication(@RequestHeader("Authorization") String jwt, @PathVariable String otp) throws Exception {
        UserEntity user = userService.findUserProfileByJwt(jwt);
        VerificationCode verificationCode = verificationCodeService.getVerificationCodeByUser(user.getId());
        String sendTo = verificationCode.getVerificationType().equals(VerificationType.EMAIL) ? verificationCode.getEmail() : verificationCode.getMobile();
        boolean isVerified = verificationCode.getOtp().equals(otp);
        if (isVerified) {
            UserEntity updatedUser = userService.enableTwoFactorAuthentication(verificationCode.getVerificationType(), sendTo, user);
            verificationCodeService.deleteVerificationCodeById(verificationCode);

            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        }
       throw  new Exception("wrong otp");
    }


@PostMapping("/auth/users/reset-password/send-otp")
    public ResponseEntity<AuthResponse> sendForgotPasswordOtp( @RequestBody ForgotPasswordTokenRequest req) throws Exception {
   UserEntity user = userService.findUserByEmail(req.getSendTo());
   String otp = OtpUtils.generateOtp();
    UUID uuid = UUID.randomUUID();
    String id = uuid.toString();

    ForgotPasswordToken token = forgotPasswordService.findByUser(user.getId());
    if(token==null){
        token = forgotPasswordService.createToken(user,id,otp,req.getVerificationType(), req.getSendTo());
    }
    if(req.getVerificationType().equals(VerificationType.EMAIL)){
        emailService.sendVerificationOtpEmail(user.getEmail(), token.getOtp());
    }
    AuthResponse authResponse = new AuthResponse();
    authResponse.setSession(token.getId());
    authResponse.setMessage("Password Reset Otp Sent Successfully");

        return new ResponseEntity<>(authResponse, HttpStatus.OK);
    }


    @PatchMapping("/auth/users/reset-password/verify-otp")
    public ResponseEntity<ApiResponse> VerifyResetPassword(@RequestHeader("Authorization") String jwt, @RequestBody ResetPasswordRequest req, @RequestParam String id) throws Exception {
//        UserEntity user = userService.findUserProfileByJwt(jwt);
        ForgotPasswordToken forgotPasswordToken = forgotPasswordService.findById(id);
       boolean isVerified = forgotPasswordToken.getOtp().equals(req.getOtp());
       if(isVerified){
           userService.updatePassword(forgotPasswordToken.getUser(),req.getPassword());
           ApiResponse res = new ApiResponse();
           res.setMessage("password Update successfully");
           return new ResponseEntity<>(res,HttpStatus.ACCEPTED);
       }
       throw  new Exception("wrong otp");
    }

}



