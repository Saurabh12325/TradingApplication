package com.Trading.Trading.Service;

import com.Trading.Trading.Config.JwtTokenProvider;
import com.Trading.Trading.Entity.UserEntity;
import com.Trading.Trading.Repository.UserRespository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceimpl implements UserService{
    private final UserRespository userRespository;

    public UserServiceimpl(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserEntity findUserProfileByJwt(String jwt) throws Exception {
        String email = JwtTokenProvider.getEmailFromToken(jwt);
        UserEntity user = userRespository.findByEmail(email);

        if(user == null) {
            throw  new Exception("user not found");
        }

        return user;
    }

    @Override
    public UserEntity findUserByEmail(String email) throws Exception {

        UserEntity user = userRespository.findByEmail(email);

        if(user == null) {
            throw  new Exception("user not found");
        }

        return user;
    }

    @Override
    public UserEntity findUserById(Long userId) throws Exception {
        Optional<UserEntity>  user = userRespository.findById(userId);
        if(user.isEmpty()){
            throw new Exception("user not found");
        }
        return user.get();

    }

    @Override
    public UserEntity enableTwoFactorAuthentication(UserEntity user) {

        return null;
    }

    @Override
    public UserEntity updatePassword(UserEntity user, String newPassword) {
        return null;
    }
}
