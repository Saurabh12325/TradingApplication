package com.Trading.Trading.Service;

import com.Trading.Trading.Domain.VerificationType;
import com.Trading.Trading.Entity.UserEntity;
import org.springframework.stereotype.Service;


public interface UserService {

    public UserEntity findUserProfileByJwt(String jwt) throws Exception;

    public UserEntity findUserByEmail(String email) throws Exception;

    public UserEntity findUserById(Long userId) throws Exception;

    public UserEntity enableTwoFactorAuthentication(VerificationType verificationType,
                                                    String sendTo,UserEntity user);

    UserEntity updatePassword(UserEntity user ,String newPassword);

}
