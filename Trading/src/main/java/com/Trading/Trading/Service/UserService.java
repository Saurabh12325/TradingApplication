package com.Trading.Trading.Service;

import com.Trading.Trading.Entity.UserEntity;
import org.springframework.stereotype.Service;


public interface UserService {

    public UserEntity findUserProfileByJwt(String jwt) throws Exception;

    public UserEntity findUserByEmail(String email) throws Exception;

    public UserEntity findUserById(Long userId) throws Exception;

    public UserEntity enableTwoFactorAuthentication(UserEntity user);

    UserEntity updatePassword(UserEntity user ,String newPassword);

}
